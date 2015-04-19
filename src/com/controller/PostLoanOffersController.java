package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PostLoanOffersDAO;
import com.daoImpl.PostLoanOffersDAOImpl;
import com.dto.PostLoanOffersDTO;
import com.utils.ValidatorUtils;

/**
 * Servlet implementation class PostLoanOffersController
 */
@WebServlet("/PostLoanOffersController")
public class PostLoanOffersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostLoanOffersController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		PostLoanOffersDTO postLoanOffersDTO;
		PostLoanOffersDAO postLoanOffersDAO;
		RequestDispatcher rd = null;
		String message = null;
		System.out.println(session);
		if (session != null) {
			System.out.println("Session ID: " + session.getId());
			try {
				postLoanOffersDTO = new PostLoanOffersDTO();
				postLoanOffersDTO.setBankerId((int) session.getAttribute("userId"));
				postLoanOffersDTO.setOfferName(request.getParameter("postName")
						.trim());
				postLoanOffersDTO.setUniversityId(Integer.parseInt(request
						.getParameter("universityName")));
				postLoanOffersDTO.setFeatures(request.getParameter("loanFeatures")
						.trim());
				if (ValidatorUtils.validateString(request.getParameter("mandtoryDocs"))) {
					postLoanOffersDTO.setMandatoryDocs(request.getParameter(
							"mandtoryDocs").trim());
				} else {
					postLoanOffersDTO.setMandatoryDocs("Mandatory Documents not specified. Please contact banker for details.");
				}
				if (ValidatorUtils.validateString(request.getParameter("interestRate"))) {
					postLoanOffersDTO.setInterestRate(Float.parseFloat(request
							.getParameter("interestRate")));
				}
				if (ValidatorUtils.validateString(request.getParameter("minLoanAmount"))) {
					postLoanOffersDTO.setMinLoanAmount(Long.parseLong(request.getParameter("minLoanAmount")));
				}
				if (ValidatorUtils.validateString(request.getParameter("maxLoanAmount"))) {
					postLoanOffersDTO.setMaxLoanAmount(Long.parseLong(request
							.getParameter("maxLoanAmount")));
				}
				if (ValidatorUtils.validateString(request.getParameter("maxDuration"))) {
					postLoanOffersDTO.setMaxDuration(Integer.parseInt(request
							.getParameter("maxDuration")));
				}
				if (ValidatorUtils.validateString(request.getParameter("processingFee"))) {
					postLoanOffersDTO.setProcessingFee(Integer.parseInt(request
							.getParameter("processingFee")));
				}
				if(request.getParameter("prePayments").equals("true")){
					postLoanOffersDTO.setPrePayments(Boolean.TRUE);
				}else{
					postLoanOffersDTO.setPrePayments(Boolean.FALSE);
				}
				
				System.out.println("Test entry printing");
				System.out.println(session.getAttribute("userId"));
				System.out.println(request.getParameter("postName").trim());
				System.out.println(Integer.parseInt(request.getParameter("universityName")));
				System.out.println(request.getParameter("loanFeatures").trim());
				System.out.println(request.getParameter("mandtoryDocs").trim());
				System.out.println(request.getParameter("interestRate").trim());
				System.out
						.println(request.getParameter("maxLoanAmount").trim());
				try {
					postLoanOffersDAO = new PostLoanOffersDAOImpl();
					if (postLoanOffersDAO.postOffer(postLoanOffersDTO)) {
						message = "New Offer : " + postLoanOffersDTO.getOfferName()
								+ " is added in the application.";
						System.out.println(message);
					} else {
						message = "New Offer : "
								+ postLoanOffersDTO.getOfferName()
								+ " couldn't be added in the application. Because of DB Issue. Try after sometime.";
						System.out.println(message);
					}
				} catch (Exception e) {
					e.printStackTrace();
					message = "Error at the DB side. Try after sometime.";
				}
				request.setAttribute("message", message);
				rd = request.getRequestDispatcher("postLoanOffers.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", e.getMessage());
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("message", "Session Expired. Sign In Again!!!");
			rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}
}
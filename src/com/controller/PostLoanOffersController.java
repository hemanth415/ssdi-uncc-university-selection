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
import com.dto.LoanOffersDTO;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		LoanOffersDTO loanOffersDTO;
		PostLoanOffersDAO postLoanOffersDAO;
		RequestDispatcher rd = null;
		String message = null;
		System.out.println(session);
		if(session != null){
			System.out.println("Session ID: "+session.getId());
			try {
				loanOffersDTO = new LoanOffersDTO();
				loanOffersDTO.setBankerId((int)session.getAttribute("userId"));
				loanOffersDTO.setOfferName(request.getParameter("postName").trim());
				loanOffersDTO.setUniversityId(Integer.parseInt(request.getParameter("universityName")));
				loanOffersDTO.setFeatures(request.getParameter("loanFeatures").trim());
				loanOffersDTO.setMandatoryDocs(request.getParameter("mandtoryDocs").trim());
				loanOffersDTO.setInterestRate(Integer.parseInt(request.getParameter("interestRate")));
				loanOffersDTO.setMaxLoanAmount(Long.parseLong(request.getParameter("maxLoanAmount")));
				
				System.out.println("Test entry printing");
				System.out.println(session.getAttribute("userId"));
				System.out.println(request.getParameter("postName").trim());
				System.out.println(Integer.parseInt(request.getParameter("universityName")));
				System.out.println(request.getParameter("loanFeatures").trim());
				System.out.println(request.getParameter("mandtoryDocs").trim());
				System.out.println(request.getParameter("interestRate").trim());
				System.out.println(request.getParameter("maxLoanAmount").trim());
				try{
					postLoanOffersDAO = new PostLoanOffersDAOImpl();
					if(postLoanOffersDAO.postOffer(loanOffersDTO)){
						message = "New Offer : " + loanOffersDTO.getOfferName() + " is added in the application.";
						System.out.println(message);
					} else {
						message = "New Offer : " + loanOffersDTO.getOfferName() + " couldn't be added in the application. Because of DB Issue. Try after sometime.";
						System.out.println(message);
					}
				}catch(Exception e){
					e.printStackTrace();
		    		message = "Error at the DB side. Try after sometime.";
				}
				request.setAttribute("message", message);
				rd = request.getRequestDispatcher("postLoanOffers.jsp");
	    		rd.forward(request,response);
			}catch(Exception e){
	    		e.printStackTrace();
	    		request.setAttribute("message", e.getMessage());
	    		rd = request.getRequestDispatcher("index.jsp");
	    		rd.forward(request,response);
	    	}
		}else{
			request.setAttribute("message", "Session Expired. Sign In Again!!!");
			rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}
}
package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SearchLoanOfferDAO;
import com.daoImpl.SearchLoanOfferDAOImpl;
import com.dto.LoanOfferDTO;
import com.utils.ValidatorUtils;

/**
 * Servlet implementation class SearchLoanOfferController
 */
@WebServlet("/SearchLoanOfferController")
public class SearchLoanOfferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchLoanOfferDAO searchLoanOfferDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchLoanOfferController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
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
		HttpSession session = request.getSession(false);
		RequestDispatcher rd = null;
		List<LoanOfferDTO> resultList = null;
		boolean result = false;
		if (session != null) {
			/*System.out.println("Loan Offering Country:     "+ request.getParameter("loanCountry"));
			System.out.println("University ID:     " + request.getParameter("universityID"));*/
			
			LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
			searchLoanOfferDAO = new SearchLoanOfferDAOImpl();
			
			if (ValidatorUtils.validateString(request.getParameter("loanCountry").trim())) {
				loanOfferDTO.setUniversityID(Integer.parseInt(request.getParameter("universityID")));
				loanOfferDTO.setLoanCountry(request.getParameter("loanCountry").trim());
				resultList = searchLoanOfferDAO.fetchLoanOffersByUnivLcoun(loanOfferDTO);
				if(resultList != null && resultList.size()>0){
					printResults(resultList); //Prints the Loan offers that are retrieved from the DataBase.
					result = true;
				}else{
					request.setAttribute("message", "No Offers Found."); 
				}
				request.setAttribute("result", result);
				request.setAttribute("resultList", resultList);
				rd = getServletContext().getRequestDispatcher("/SearchLoanOffers.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("message", "Provide valid university or country where loan needs to be availed ");
				rd = getServletContext().getRequestDispatcher("/SearchLoanOffers.jsp");
				rd.forward(request, response);
			}

		} else {
			request.setAttribute("message", "Session Expired. Sign In Again!!!");
			rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}
	
	private void printResults(List<LoanOfferDTO> resultList){
		for(LoanOfferDTO post: resultList){
			System.out.println(post.getBankName());
			System.out.println(post.getLoanOfficerName());
			System.out.println(post.getBankerContactNum());
			System.out.println(post.getBankerEmailId());
			System.out.println(post.getInterestRate());
			System.out.println(post.getMaxLoanAmount());
			System.out.println(post.getLoanDescription());
		}
	}
}

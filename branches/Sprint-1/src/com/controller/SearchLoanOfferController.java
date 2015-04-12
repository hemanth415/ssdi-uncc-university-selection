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
import com.dto.LofferDTO;
import com.utils.ValidatorUtils;

/**
 * Servlet implementation class SearchLoanOfferController
 */
@WebServlet("/SearchLoanOfferController")
public class SearchLoanOfferController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private SearchLoanOfferDAO searchLoanOfferDAO= null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchLoanOfferController() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/** 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
    {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
    protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
    {
		HttpSession session = request.getSession(false);
		RequestDispatcher rd = null;
		String message = null;
		if(session != null)
		{
			System.out.println("L Country:     " + request.getParameter("lCountry"));
			System.out.println("U Name:     " + request.getParameter("uName"));
			LofferDTO lofferDTO = new LofferDTO();
			boolean result = false;
			searchLoanOfferDAO = new SearchLoanOfferDAOImpl();
			List<LofferDTO> resultList = null;
			String lAmount;
			if (
					(ValidatorUtils.validateString(request.getParameter("uName").trim()))
					&& 
					(ValidatorUtils.validateString(request.getParameter("lCountry").trim()))
					
					
			    )
			{
				searchLoanOfferDAO = new SearchLoanOfferDAOImpl();
				lofferDTO.setUniversityName(request.getParameter("uName").trim());
				lofferDTO.setLCountry(request.getParameter("lCountry").trim());
				resultList = searchLoanOfferDAO.fetchLoanOffersByUnivLcoun(lofferDTO);
			}
			else 
			{
				message = "Provide valid university or country where loan needs to be availed ";
			}
			
			
				
				
		}else{
			request.setAttribute("message", "Session Expired. Sign In Again!!!");
			rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		     }
	}
}	

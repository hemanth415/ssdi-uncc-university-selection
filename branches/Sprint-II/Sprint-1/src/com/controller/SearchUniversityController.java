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

import com.dao.SearchUniversityDAO;
import com.daoImpl.SearchUniversityDAOImpl;
import com.dto.UniversityDTO;
import com.utils.ValidatorUtils;

/**
 * Servlet implementation class SearchUniversityController
 * 
 * @author Hemanth
 *
 */
@WebServlet("/SearchUniversityController")
public class SearchUniversityController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private SearchUniversityDAO searchUniversityDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchUniversityController() {
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
		HttpSession session = request.getSession(false);
		RequestDispatcher rd = null;
		String message = null;
		if(session != null){
			System.out.println("U Country:     " + request.getParameter("uCountry"));
			System.out.println("U State:     " + request.getParameter("uState"));
			UniversityDTO universityDTO = new UniversityDTO();
			boolean result = false;
			searchUniversityDAO = new SearchUniversityDAOImpl();
			List<UniversityDTO> resultList = null;
			if (ValidatorUtils.validateString(request.getParameter("uName"))) {
				searchUniversityDAO = new SearchUniversityDAOImpl();
				universityDTO.setUniversityName(request.getParameter("uName").trim());
				resultList = searchUniversityDAO
						.fetchUniversityByName(universityDTO);
			} else if (ValidatorUtils.validateString(request.getParameter("uCountry"))
					&& ValidatorUtils.validateString(request.getParameter("uState"))) {
				searchUniversityDAO = new SearchUniversityDAOImpl();
				if (ValidatorUtils.validateCountry(request.getParameter("uCountry").trim())) {
					if (ValidatorUtils.validateCountryState(
							request.getParameter("uCountry").trim(), request.getParameter("uState").trim())) {
						universityDTO.setUniversityState(request.getParameter("uState").trim());
						universityDTO.setUniversityCountry(request.getParameter("uCountry").trim());
						resultList = searchUniversityDAO.fetchUniversitiesByCntryState(universityDTO);
					} else {
						message = "Invalid state for the provided country";
					}
				} else {
					message = "Invalid country";
				}
			} else {
				message = "Provide valid university or combination of country and state";
			}
			if (resultList !=null && !resultList.isEmpty()) {
				for (UniversityDTO dto : resultList) {
					System.out.println("Name: " + dto.getUniversityName());
				}
				message = "Obtained search result: " + resultList.size();
				result = true;
			}
			request.setAttribute("result", result);
			request.setAttribute("uniList", resultList);
			request.setAttribute("message", message);
			rd = getServletContext().getRequestDispatcher("/universitySearch.jsp");
			rd.forward(request, response);		
		}else{
			request.setAttribute("message", "Session Expired. Sign In Again!!!");
			rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}
}
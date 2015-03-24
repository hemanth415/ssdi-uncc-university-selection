package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SearchUniversityDAO;
import com.daoImpl.SearchUniversityDAOImpl;
import com.dto.UniversityDTO;

/**
 * Servlet implementation class SearchUniversityServlet
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//if(session != null){
		System.out.println("U Country:     "+request.getParameter("uCountry"));
		System.out.println("U State:     "+request.getParameter("uState"));
		//if(request.getParameter("universityName") != null){
			UniversityDTO universityDTO = new UniversityDTO();
			boolean result = false;
			searchUniversityDAO = new SearchUniversityDAOImpl();
			List<UniversityDTO> resultList = null;
			if(request.getParameter("uName") != null && !request.getParameter("uName").isEmpty()){
				searchUniversityDAO = new SearchUniversityDAOImpl();
				universityDTO.setUniversityName(request.getParameter("uName"));
				resultList=searchUniversityDAO.fetchUniversityByName(universityDTO);
			}else if (request.getParameter("uState") != null && request.getParameter("uCountry") != null){
				searchUniversityDAO = new SearchUniversityDAOImpl();
				universityDTO.setUniversityState(request.getParameter("uState"));
				universityDTO.setUniversityCountry(request.getParameter("uCountry"));
				resultList=searchUniversityDAO.fetchUniversitiesByCntryState(universityDTO);
			}
			RequestDispatcher rd = null;
			if(!resultList.isEmpty()){
				for(UniversityDTO dto:resultList){
					System.out.println("Name: "+dto.getUniversityName());
				}
				result = true;
			}
			request.setAttribute("result", result);
			request.setAttribute("uniList", resultList);
			rd = getServletContext().getRequestDispatcher("/universitySearch.jsp");
			rd.forward(request, response);
			
		//}
		//}
	}

}

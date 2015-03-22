package com.controller;

import java.io.IOException;

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
		System.out.println("Name:     "+request.getParameter("universityName"));
		if(request.getParameter("universityName") != null){
			UniversityDTO universityDTO = new UniversityDTO();
			searchUniversityDAO = new SearchUniversityDAOImpl();
			universityDTO.setUniversityName("Charlotte");
			searchUniversityDAO.fetchUniversityDetails(universityDTO);
		}
		//}
	}

}

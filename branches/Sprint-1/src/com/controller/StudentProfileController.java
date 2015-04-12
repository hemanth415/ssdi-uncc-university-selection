package com.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentProfileDAO;
import com.daoImpl.StudentProfileDAOImpl;
import com.dto.StudentDTO;
import com.utils.ValidatorUtils;

/**
 * Servlet implementation class StudentProfileController
 *
 * @author Hemanth
 *
 */
@WebServlet("/StudentProfileController")
public class StudentProfileController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StudentProfileDAO studentProfileDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentProfileController() {
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
		String term1 = null;
		String term2 = null;
		boolean execute = Boolean.FALSE;
		if (session != null) {
			boolean result = false;
			studentProfileDAO = new StudentProfileDAOImpl();
			if (ValidatorUtils.validateString(request
					.getParameter("spring2015"))) {
				term1 = request.getParameter("spring2015");
				execute = Boolean.TRUE;
			}
			if (ValidatorUtils.validateString(request.getParameter("fall2015"))) {
				term2 = request.getParameter("fall2015");
				execute = Boolean.TRUE;
			}
			System.out.println("Term 1:\t" + term1);
			System.out.println("Term 2:\t" + term2);
			List<StudentDTO> resultList = null;
			try {
				if (execute) {
					resultList = studentProfileDAO.fetchStudentProfiles(term1,
							term2);
					if (resultList != null && !resultList.isEmpty()) {
						Collections.sort(resultList, NameComparator);
						for (StudentDTO dto : resultList) {
							System.out.println("Name: " + dto.getFirstName());
						}
						message = "Student profiles  obtained: "
								+ resultList.size();
						result = true;
					} else {
						message = "No Profiles to be viewed.";
					}
				} else {
					message = "Select atleast one term to obtain students profiles. ";
				}
			} catch (Exception e) {
				message = "Error at the DB side. Try after sometime.";
				e.printStackTrace();
			}
			request.setAttribute("studentResult", result);
			request.setAttribute("studentList", resultList);
			request.setAttribute("studentMessage", message);
			rd = getServletContext().getRequestDispatcher(
					"/studentProfiles.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("message", "Session Expired. Sign In Again!!!");
			rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * Comparator to sort employees list or array in order of Name
	 */
	public static Comparator<StudentDTO> NameComparator = new Comparator<StudentDTO>() {

		@Override
		public int compare(StudentDTO e1, StudentDTO e2) {
			return e1.getFirstName().compareTo(e2.getFirstName());
		}
	};
}

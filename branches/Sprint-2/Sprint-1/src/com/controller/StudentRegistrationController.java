package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentRegistrationDAO;
import com.daoImpl.StudentRegistrationDAOImpl;
import com.dto.StudentDTO;

/**
 * Servlet implementation class StudentRegistrationController
 */
@WebServlet("/StudentRegistrationController")
public class StudentRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationController() {
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
		StudentDTO studentDTO = new StudentDTO();
		RequestDispatcher rd = null;
		try{
			studentDTO.setFirstName(request.getParameter("firstName").trim());
			studentDTO.setLastName(request.getParameter("lastName").trim());
			studentDTO.setStudentEmailId(request.getParameter("email").trim());
			studentDTO.setPassword(request.getParameter("passWord").trim());
			studentDTO.setAddress(request.getParameter("address").trim());
			studentDTO.setZipCode(Integer.parseInt(request.getParameter("zipCode").trim()));
			studentDTO.setStudentContactNum(Long.parseLong(request.getParameter("contactNum").trim()));
			
			System.out.println("Test entry printing");
			System.out.println(studentDTO.getFirstName());
			System.out.println(studentDTO.getLastName());
			System.out.println(studentDTO.getStudentEmailId());
			System.out.println(studentDTO.getPassword());
			System.out.println(studentDTO.getAddress());
			System.out.println(studentDTO.getZipCode());
			System.out.println(studentDTO.getStudentContactNum());
					
			StudentRegistrationDAO studentRegistrationDAOImpl = new StudentRegistrationDAOImpl();
			//Session Creation.
			HttpSession session = request.getSession();
			if(studentRegistrationDAOImpl.studentRegistration(studentDTO)){
				System.out.println("Success");
				session.setAttribute("userName", studentDTO.getFirstName() + "," + studentDTO.getLastName());
				session.setAttribute("userRole", 'S');
	            // Session inactive time check to 20 mins.
	            session.setMaxInactiveInterval(20*60);
				rd=request.getRequestDispatcher("studentHome.jsp");  
				request.setAttribute("First Name", studentDTO.getFirstName());
			} else {
				rd=request.getRequestDispatcher("index.jsp");  
				request.setAttribute("First Name", studentDTO.getFirstName());
				System.out.println("Failure");
			}
			rd.forward(request, response);
		}catch(Exception e){
    		e.printStackTrace();
    		request.setAttribute("message", e.getMessage());
    		rd = request.getRequestDispatcher("index.jsp");
    		rd.forward(request,response);
    	} 
	}

}

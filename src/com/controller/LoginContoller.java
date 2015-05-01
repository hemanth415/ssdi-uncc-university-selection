package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;
import com.daoImpl.LoginDaoImpl;
import com.dto.UserDTO;
import com.utils.ValidatorUtils;

/**
 * Servlet implementation class LoginContoller
 */
@WebServlet("/LoginContoller")
public class LoginContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginContoller() {
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
        String message = null;
        LoginDao loginDao = null;
        UserDTO userDTO = null;
        char userRole= ' ';
        RequestDispatcher requestDispatcher = null;
        try{
        	if (ValidatorUtils.validateString(request.getParameter("userName"))) {
            	if(ValidatorUtils.validateString(request.getParameter("userPassword"))){
            		userDTO = new UserDTO();
            		loginDao = new LoginDaoImpl();
            		userDTO.setUserName(request.getParameter("userName"));
            		userDTO.setUserPassword(request.getParameter("userPassword"));
            		userRole = loginDao.validateLogin(userDTO);
            		//Session Creation.
            		HttpSession session = request.getSession();
            		session.setAttribute("userName", userDTO.getUserName());
    	            // Session inactive time check to 20 mins.
    	            session.setMaxInactiveInterval(20*60);
            		if(userRole == 'B'){
            			userDTO.setUserRole(userRole);
            			loginDao.fetchBankerDetails(userDTO);
            			System.out.println(userDTO.getFirstName()+","+userDTO.getLastName());
            			System.out.println(userRole);
            			session.setAttribute("userName", userDTO.getFirstName()+","+userDTO.getLastName());
            			session.setAttribute("userRole", userRole);
            			session.setAttribute("userId", userDTO.getBankerId());
            			requestDispatcher = request.getRequestDispatcher("welcome.jsp");
            		}else if(userRole == 'S'){
            			userDTO.setUserRole(userRole);
            			loginDao.fetchStudentDetails(userDTO);
            			System.out.println(userDTO.getFirstName()+","+userDTO.getLastName());
            			System.out.println(userRole);
            			session.setAttribute("userName", userDTO.getFirstName()+","+userDTO.getLastName());
            			session.setAttribute("userRole", userRole);
            			session.setAttribute("userId", userDTO.getStudentId());
            			requestDispatcher = request.getRequestDispatcher("studentHome.jsp");
            		}else{
            			message = "Invalid user details.";
            			requestDispatcher = request.getRequestDispatcher("index.jsp");
            		}
            	}else{
            		userDTO = null;
            		message = "Password can't be empty";
            		requestDispatcher = request.getRequestDispatcher("index.jsp");
            	}
            }else{
            	userDTO = null;
            	message = "Username can't be empty";
            	requestDispatcher = request.getRequestDispatcher("index.jsp");
            }
        	request.setAttribute("message", message);
        	requestDispatcher.forward(request,response);
    	}catch(Exception e){
    		e.printStackTrace();
    		request.setAttribute("message", e.getMessage());
    		requestDispatcher = request.getRequestDispatcher("index.jsp");
    		requestDispatcher.forward(request,response);
    	}
	}
}

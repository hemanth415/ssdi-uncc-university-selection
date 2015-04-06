package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BankerRegistrationDAO;
import com.daoImpl.BankerRegistrationDAOImpl;
import com.dto.BankerDTO;

/**
 * Servlet implementation class BankerRegistrationController
 */
@WebServlet("/BankerRegistrationController")
public class BankerRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankerRegistrationController() {
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
		// TODO Auto-generated method stub
		BankerDTO bankerDTO = new BankerDTO();
		RequestDispatcher rd = null;
		try {
			bankerDTO.setFirstName(request.getParameter("firstName").trim());
			bankerDTO.setLastName(request.getParameter("lastName").trim());
			bankerDTO.setUserName(request.getParameter("bankerEmail").trim());
			bankerDTO.setPassword(request.getParameter("passWord").trim());
			bankerDTO.setBankerEmailId(request.getParameter("bankerEmail").trim());
			bankerDTO.setBankerContactNum(Long.parseLong(request.getParameter("bankerContactNum").trim()));
			bankerDTO.setBankName(request.getParameter("bankName").trim());
			bankerDTO.setBankAddress(request.getParameter("bankAddress").trim());
			bankerDTO.setBankZipCode(Integer.parseInt(request.getParameter("bankZipCode").trim()));
			bankerDTO.setBankContactNum(Long.parseLong(request.getParameter("bankContactNum").trim()));
			bankerDTO.setBankEmailId(request.getParameter("bankEmail").trim());
			
			System.out.println("Test entry printing");
			System.out.println(bankerDTO.getFirstName());
			System.out.println(bankerDTO.getLastName());
			System.out.println(bankerDTO.getUserName());
			System.out.println(bankerDTO.getPassword());
			System.out.println(bankerDTO.getBankerEmailId());
			System.out.println(bankerDTO.getBankerContactNum());
			System.out.println(bankerDTO.getBankName());
			System.out.println(bankerDTO.getBankAddress());
			System.out.println(bankerDTO.getBankZipCode());
			System.out.println(bankerDTO.getBankContactNum());
			System.out.println(bankerDTO.getBankEmailId());
			
			BankerRegistrationDAO bankerRegistrationDAOImpl = new BankerRegistrationDAOImpl();
			//Session Creation.
    		HttpSession session = request.getSession();
			if(bankerRegistrationDAOImpl.bankerRegistration(bankerDTO)){
				System.out.println("Success");
				session.setAttribute("userName", bankerDTO.getFirstName() + "," + bankerDTO.getLastName());
				session.setAttribute("userRole", 'B');
	            // Session inactive time check to 20 mins.
	            session.setMaxInactiveInterval(20*60);
				rd=request.getRequestDispatcher("welcome.jsp");  
				request.setAttribute("First Name", bankerDTO.getFirstName());
			} else {
				rd=request.getRequestDispatcher("index.jsp");  
				request.setAttribute("First Name", bankerDTO.getFirstName());
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

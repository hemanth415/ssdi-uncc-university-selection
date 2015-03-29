package com.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		bankerDTO.setFirstName(request.getParameter("firstName").trim());
		bankerDTO.setLastName(request.getParameter("lastName").trim());
		bankerDTO.setUserName(request.getParameter("userName").trim());
		bankerDTO.setPassword(request.getParameter("passWord").trim());
		bankerDTO.setBankerEmailId(request.getParameter("bankerEmail").trim());
		bankerDTO.setBankerContactNum(Long.parseLong(request.getParameter("bankerContactNum").trim()));
		bankerDTO.setBankName(request.getParameter("bankName").trim());
		bankerDTO.setBankAddress(request.getParameter("bankAddress").trim());
		bankerDTO.setBankZipCode(Integer.parseInt(request.getParameter("bankZipCode").trim()));
		bankerDTO.setBankContactNum(Long.parseLong(request.getParameter("bankContactNum").trim()));
		bankerDTO.setBankEmailId(request.getParameter("bankEmail").trim());
		
		System.out.println("Test entry");
		System.out.println(bankerDTO.getFirstName());
		System.out.println(bankerDTO.getLastName());
		System.out.println(bankerDTO.getUserName());
		System.out.println(bankerDTO.getPassword());
		System.out.println(bankerDTO.getBankerEmailId());
		System.out.println(bankerDTO.getBankerContactNum()+"");
		System.out.println(bankerDTO.getBankName());
		System.out.println(bankerDTO.getBankAddress());
		System.out.println(bankerDTO.getBankZipCode()+"");
		System.out.println(bankerDTO.getBankContactNum()+"");
		System.out.println(bankerDTO.getBankEmailId());
		
		
		BankerRegistrationDAOImpl bankerRegistrationDAOImpl = new BankerRegistrationDAOImpl();
		if(bankerRegistrationDAOImpl.bankerRegistration(bankerDTO)){
			System.out.println("Success");
		} else {
			System.out.println("Failure");
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("success.jsp");  
		request.setAttribute("First Name", bankerDTO.getFirstName());
		rd.forward(request, response);  
	}

}

package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.WishListDAO;
import com.daoImpl.WishListDAOImpl;
import com.dto.WishListDTO;

/**
 * Servlet implementation class WishListController
 */
@WebServlet("/WishListController")
public class WishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WishListDAO wishListDAO = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishListController() {
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
		HttpSession session = request.getSession();
		
		RequestDispatcher rd = null;
		boolean result = false;
		
		if (session != null) {
			WishListDTO wishListDTO = new WishListDTO();
			wishListDAO = new WishListDAOImpl();
			
			System.out.println("Test for request object"+ request.getAttribute("result"));
			
			if(request.getParameter("wishID")!=null){
				System.out.println("WishList controller invoked. Value =  " + Integer.parseInt(request.getParameter("wishID")));
				System.out.println("User ID = "+session.getAttribute("userId"));
			}
			
			wishListDTO.setPost_id(Integer.parseInt(request.getParameter("wishID")));
			wishListDTO.setUser_id((int) session.getAttribute("userId"));
				
			result = wishListDAO.saveToWishList(wishListDTO);
				
			if(result){
				request.setAttribute("message", "Item added to WishList");
			}else{
				request.setAttribute("message", "Item deleted from WishList"); 
			}
			rd = getServletContext().getRequestDispatcher("/MyWishList.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("message", "Session Expired. Sign In Again!!!");
			rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}
}

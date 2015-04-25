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

import com.dao.GetWishListDAO;
import com.daoImpl.GetWishListDAOImpl;
import com.dto.GetWishListDTO;

/**
 * Servlet implementation class GetWishListDataController
 */
@WebServlet("/GetWishListDataController")
public class GetWishListDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GetWishListDAO getWishListDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetWishListDataController() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		RequestDispatcher rd = null;
		List<GetWishListDTO> resultList = null;
		boolean result = false;

		if (session != null) {
			GetWishListDTO getWishListDTO = new GetWishListDTO();
			getWishListDAO = new GetWishListDAOImpl();

			getWishListDTO.setUserId((int) session.getAttribute("userId"));

			resultList = getWishListDAO.fetchWishList(getWishListDTO);

			if (resultList != null && resultList.size() > 0) {
				result = true;
				request.setAttribute("message", "Below is your Wish List");
			} else {
				result = false;
				request.setAttribute("message", "WishList is empty");
			}
			// changed below 2 lines
			request.setAttribute("result", result);
			request.setAttribute("resultList", resultList);

			rd = getServletContext().getRequestDispatcher("/MyWishList.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("message", "Session Expired. Sign In Again!!!");
			rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}
}
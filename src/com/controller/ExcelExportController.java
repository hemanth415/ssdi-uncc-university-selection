package com.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import com.dto.LoanOffersDTO;
import com.service.ExcelExportDAO;
import com.serviceImpl.ExcelExportDAOImpl;

/**
 * Servlet implementation class ExcelExportController
 */
@WebServlet("/ExcelExportController")
public class ExcelExportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExcelExportController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null) {
			List<LoanOffersDTO> loanOffersDTOs;
			ExcelExportDAO excelExportDAO;
			Workbook workbook;
			if (session.getAttribute("loanOffers") != null) {
				loanOffersDTOs = (List<LoanOffersDTO>) session
						.getAttribute("loanOffers");
				excelExportDAO = new ExcelExportDAOImpl();
/*				workbook = excelExportDAO
						.createLoanOffersXls(loanOffersDTOs);*/
				workbook = excelExportDAO
						.createLoanOffersXlsx(loanOffersDTOs);
				if (workbook != null) {
					OutputStream out = response.getOutputStream();
					 if (workbook instanceof HSSFWorkbook) {
					       response.setContentType("application/vnd.ms-excel");
					       response.setHeader("Content-Disposition",
					                                "attachment; filename=report.xls");
					       workbook.write(out);
					    } else {
					       response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					       response.setHeader("Content-Disposition",
					                                "attachment; filename=report.xlsx");
					       workbook.write(out);
					    }
					 out.flush();
					 out.close();
					
					/*fileOut = new FileOutputStream("report.xlsx");
					response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					response.setHeader("Content-Disposition",
							"attachment; filename=report.xlsx");*/
				} else {

				}
			}
		}

	}

}

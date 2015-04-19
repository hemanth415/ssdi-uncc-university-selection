package com.serviceImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dto.LoanOffersDTO;
import com.service.ExcelExportDAO;

public class ExcelExportDAOImpl implements ExcelExportDAO {

	@Override
	public HSSFWorkbook createLoanOffersXls(List<LoanOffersDTO> loanOffersDTOs)
			throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("LoanOffers");

		HSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("Bank Name");
		headRow.createCell(1).setCellValue("Offer Name");
		headRow.createCell(2).setCellValue("Loan Officer");
		headRow.createCell(3).setCellValue("Telephone");
		headRow.createCell(4).setCellValue("Email");
		headRow.createCell(5).setCellValue("Interest Rate");
		headRow.createCell(6).setCellValue("Period");
		headRow.createCell(7).setCellValue("Pre-Payment");
		headRow.createCell(8).setCellValue("Installment");
		headRow.createCell(9).setCellValue("Loan details");

		HSSFRow dataRow;
		int rowCount = 1;
		for (LoanOffersDTO loanOffersDTO : loanOffersDTOs) {
			dataRow = sheet.createRow(rowCount++);
			dataRow.createCell(0).setCellValue(loanOffersDTO.getBankName());
			dataRow.createCell(1).setCellValue(loanOffersDTO.getOfferName());
			dataRow.createCell(2).setCellValue(
					loanOffersDTO.getLoanOfficerName());
			dataRow.createCell(3).setCellValue(
					loanOffersDTO.getBankerContactNum());
			dataRow.createCell(4)
					.setCellValue(loanOffersDTO.getBankerEmailId());
			dataRow.createCell(5).setCellValue(loanOffersDTO.getInterestRate());
			dataRow.createCell(6).setCellValue(loanOffersDTO.getDuration());
			dataRow.createCell(7).setCellValue(
					loanOffersDTO.getPrePaymentValue());
			dataRow.createCell(8).setCellValue(loanOffersDTO.getInstallments());
			dataRow.createCell(9).setCellValue(
					loanOffersDTO.getLoanDescription());
		}

/*		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\Hemanth\\Desktop\\report_"
						+ Calendar.getInstance().getTimeInMillis() + ".xlsx");
		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();*/

		return workbook;
	}

	@Override
	public XSSFWorkbook createLoanOffersXlsx(List<LoanOffersDTO> loanOffersDTOs)
			throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("LoanOffers");

		XSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("Bank Name");
		headRow.createCell(1).setCellValue("Offer Name");
		headRow.createCell(2).setCellValue("Loan Officer");
		headRow.createCell(3).setCellValue("Telephone");
		headRow.createCell(4).setCellValue("Email");
		headRow.createCell(5).setCellValue("Interest Rate");
		headRow.createCell(6).setCellValue("Period");
		headRow.createCell(7).setCellValue("Pre-Payment");
		headRow.createCell(8).setCellValue("Installment");
		headRow.createCell(9).setCellValue("Loan details");

		XSSFRow dataRow;
		int rowCount = 1;
		for (LoanOffersDTO loanOffersDTO : loanOffersDTOs) {
			dataRow = sheet.createRow(rowCount++);
			dataRow.createCell(0).setCellValue(loanOffersDTO.getBankName());
			dataRow.createCell(1).setCellValue(loanOffersDTO.getOfferName());
			dataRow.createCell(2).setCellValue(
					loanOffersDTO.getLoanOfficerName());
			dataRow.createCell(3).setCellValue(
					loanOffersDTO.getBankerContactNum());
			dataRow.createCell(4)
					.setCellValue(loanOffersDTO.getBankerEmailId());
			dataRow.createCell(5).setCellValue(loanOffersDTO.getInterestRate());
			dataRow.createCell(6).setCellValue(loanOffersDTO.getDuration());
			dataRow.createCell(7).setCellValue(
					loanOffersDTO.getPrePaymentValue());
			dataRow.createCell(8).setCellValue(loanOffersDTO.getInstallments());
			dataRow.createCell(9).setCellValue(
					loanOffersDTO.getLoanDescription());
		}

/*		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\Hemanth\\Desktop\\report_"
						+ Calendar.getInstance().getTimeInMillis() + ".xlsx");
		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();*/

		return workbook;
		
	}
}
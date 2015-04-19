package com.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dto.LoanOffersDTO;

public interface ExcelExportDAO {
	HSSFWorkbook createLoanOffersXls(List<LoanOffersDTO> loanOffersDTOs)
			throws IOException;
	
	XSSFWorkbook createLoanOffersXlsx(List<LoanOffersDTO> loanOffersDTOs)
			throws IOException;
}

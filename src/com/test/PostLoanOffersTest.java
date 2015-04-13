package com.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.dao.PostLoanOffersDAO;
import com.daoImpl.PostLoanOffersDAOImpl;
import com.dto.LoanOffersDTO;

public class PostLoanOffersTest {
	LoanOffersDTO dto = null;
	PostLoanOffersDAO postLoanOffersDAO;

	@Before
	public void setUp() throws Exception {
		dto = new LoanOffersDTO();
		postLoanOffersDAO = new PostLoanOffersDAOImpl();
	}

	@Test
	public void validatePostLoanOfferSuccess() throws Exception {
		dto.setBankerId(1);
		dto.setUniversityId(50000);
		dto.setOfferName("Spring 2016 Indian Bank loan offer");
		dto.setFeatures("Student Loan");
		dto.setMandatoryDocs("Security documents");
		dto.setInterestRate(10);
		dto.setMaxLoanAmount(1000000);
		
		assertTrue("Success validation for Banker registration",
				postLoanOffersDAO.postOffer(dto));
	}
	
	@Test
	public void validatePostLoanOfferFailure() throws Exception {
		//Commenting the required banker ID to test for failure condition. Returns a DB exception
		//dto.setBankerId(1);
		dto.setUniversityId(50000);
		dto.setOfferName("Spring 2016 Indian Bank loan offer");
		dto.setFeatures("Student Loan");
		dto.setMandatoryDocs("Security documents");
		dto.setInterestRate(10);
		dto.setMaxLoanAmount(1000000);
		
		assertFalse("Failure validation for Banker registration",
				postLoanOffersDAO.postOffer(dto));
		
	}
}

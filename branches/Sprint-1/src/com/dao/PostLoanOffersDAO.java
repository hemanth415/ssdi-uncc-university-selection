package com.dao;

import com.dto.LoanOffersDTO;

public interface PostLoanOffersDAO {
	public boolean postOffer(LoanOffersDTO loanOfferDTO) throws Exception;
}
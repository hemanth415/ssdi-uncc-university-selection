package com.dao;

import java.util.List;

import com.dto.LoanOffersDTO;

public interface SearchLoanOfferDAO {

	public List<LoanOffersDTO> fetchLoanOffers(LoanOffersDTO loanOffersDTO) throws Exception;

}

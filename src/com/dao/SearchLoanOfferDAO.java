package com.dao;

import java.util.List;

import com.dto.LoanOfferDTO;


public interface SearchLoanOfferDAO
{

	public List<LoanOfferDTO> fetchLoanOffersByUnivLcoun(LoanOfferDTO loanOfferDTO);

}

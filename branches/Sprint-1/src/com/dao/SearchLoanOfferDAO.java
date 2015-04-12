package com.dao;

import java.util.List;

import com.dto.LofferDTO;

public interface SearchLoanOfferDAO
{

	public List<LofferDTO> fetchLoanOffersByUnivLcoun(LofferDTO lofferDTO);

}

package com.dao;

import java.util.List;
import java.util.Map;

import com.dto.LoanOffersDTO;
import com.dto.WishListDTO;

public interface SearchLoanOfferDAO {

	public List<LoanOffersDTO> fetchLoanOffers(LoanOffersDTO loanOffersDTO) throws Exception;

	public Map<Integer,WishListDTO> fetchWishList(int userId) throws Exception;

}

package com.dao;

import com.dto.PostLoanOffersDTO;

public interface PostLoanOffersDAO {
	public boolean postOffer(PostLoanOffersDTO postLoanOffersDTO) throws Exception;
}
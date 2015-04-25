package com.dao;

import java.util.List;

import com.dto.GetWishListDTO;

public interface GetWishListDAO {
	public List<GetWishListDTO> fetchWishList(GetWishListDTO getWishListDTO);
}

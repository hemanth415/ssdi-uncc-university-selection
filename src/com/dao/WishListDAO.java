package com.dao;

import com.dto.WishListDTO;

public interface WishListDAO {
	public boolean saveToWishList(WishListDTO wishListDTO);
}

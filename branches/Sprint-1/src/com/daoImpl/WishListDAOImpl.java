package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.connection.MySQLConnection;
import com.dao.WishListDAO;
import com.dto.WishListDTO;
import com.utils.Constants;

public class WishListDAOImpl extends MySQLConnection implements WishListDAO{

	@Override
	public boolean saveToWishList(WishListDTO wishListDTO) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement findStatusStatement = null;
		PreparedStatement wishListInsertStatement = null;
		PreparedStatement deleteFromInsertStatement = null;
		ResultSet resultSet = null;
		int insertStatus, deleteStatus;
		
		try{
			conn = getConnection();
			
			findStatusStatement = conn.prepareStatement(Constants.GET_STATUS_WISH_LIST);
			findStatusStatement.setInt(1, wishListDTO.getPostId());
			findStatusStatement.setInt(2, wishListDTO.getUserId());
			
			resultSet = findStatusStatement.executeQuery();
			
			if(resultSet.next()){
				deleteFromInsertStatement = conn.prepareStatement(Constants.DELETE_FROM_WISH_LIST);
				deleteFromInsertStatement.setInt(1, wishListDTO.getPostId());
				deleteFromInsertStatement.setInt(2, wishListDTO.getUserId());
				
				deleteStatus = deleteFromInsertStatement.executeUpdate();		
				
				if(deleteStatus == 1){
					System.out.println("DATA deleted from Wish List");
					return false;
				}
				else{
					System.out.println("Failed to delete");
					return true;
				}
			} else{
				wishListInsertStatement = conn.prepareStatement(Constants.INSERT_TO_WISH_LIST);
				wishListInsertStatement.setInt(1, wishListDTO.getPostId());
				wishListInsertStatement.setInt(2, wishListDTO.getUserId());
				
				insertStatus = wishListInsertStatement.executeUpdate();		
				
				if(insertStatus == 1){
					System.out.println("DATA inserted into Wish List");
					return true;
				}
				else{
					System.out.println("Failed to insert into Wish List");
					return false;
				}
			}
			
		} catch(Exception E){
			System.out.println(E+"");
		}
		return false;
	}
}

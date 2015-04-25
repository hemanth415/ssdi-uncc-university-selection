package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.MySQLConnection;
import com.dao.GetWishListDAO;
import com.dto.GetWishListDTO;
import com.utils.Constants;

public class GetWishListDAOImpl extends MySQLConnection implements GetWishListDAO{

	@Override
	public List<GetWishListDTO> fetchWishList(GetWishListDTO getWishListDTO) {
		Connection conn = null;
		PreparedStatement fetchFromWishListStatement = null;
		PreparedStatement fetchFromLoanOffersStatement = null;
		PreparedStatement fetchFromBankersStatement = null;
		
		ResultSet wishListSet = null;
		ResultSet  loanOffersSet = null;
		ResultSet  bankerSet = null;
		int userId = getWishListDTO.getUserId(), postId, bankerId;
		
		List<GetWishListDTO> searchResultsList = new ArrayList<GetWishListDTO>();
		
		try{
			conn = getConnection();
			//Condition check for loan offers related to all Universities/ a specific University using University ID
			fetchFromWishListStatement = conn.prepareStatement(Constants.FETCH_WISH_LIST);
			fetchFromWishListStatement.setString(1, userId+"");
			wishListSet = fetchFromWishListStatement.executeQuery();
			
			while(wishListSet.next()){
				postId = wishListSet.getInt("post_id");
				fetchFromLoanOffersStatement = conn.prepareStatement(Constants.FETCH_LOANOFFER_FOR_WISHLIST);
				fetchFromLoanOffersStatement.setString(1, postId+"");
				loanOffersSet = fetchFromLoanOffersStatement.executeQuery();
				
				if(loanOffersSet.next()){
					bankerId = loanOffersSet.getInt("banker_id");
					fetchFromBankersStatement = conn.prepareStatement(Constants.FETCH_BANKER_FOR_WISHLIST);
					fetchFromBankersStatement.setString(1, bankerId+"");
					bankerSet = fetchFromBankersStatement.executeQuery();
					
					if(bankerSet.next()){
						GetWishListDTO getWishListResultDTO = new GetWishListDTO();
						getWishListResultDTO.setPostId(wishListSet.getInt("post_id"));
						getWishListResultDTO.setBankName(bankerSet.getString("bank_name"));
						getWishListResultDTO.setLoanOfficer(bankerSet.getString("first_name")+" "+bankerSet.getString("last_name"));
						getWishListResultDTO.setTelephone(bankerSet.getLong("bank_contact_no"));
						getWishListResultDTO.setEmail(bankerSet.getString("bank_email_id"));
						getWishListResultDTO.setInterestRate(loanOffersSet.getFloat("interest_rate"));
						getWishListResultDTO.setLoanAmount(loanOffersSet.getLong("max_amount"));
						getWishListResultDTO.setLoanDetails(loanOffersSet.getString("post_features")
										+" "+loanOffersSet.getString("mandatory_docs"));
						
						searchResultsList.add(getWishListResultDTO);
					}else{
						System.out.println("Nothing found in Banker Set with ID="+loanOffersSet.getInt("banker_id"));
					}
				} else{
					System.out.println("Nothing found in Wish List Set with ID="+wishListSet.getInt("post_id"));
				}
			}
			return searchResultsList;
		} catch(Exception E){
			System.out.println(E+"");
		}
		return null;
	}

}
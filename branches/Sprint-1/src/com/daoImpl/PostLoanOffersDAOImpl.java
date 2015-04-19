package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.connection.MySQLConnection;
import com.dao.PostLoanOffersDAO;
import com.dto.PostLoanOffersDTO;
import com.utils.Constants;

/**
 * @author Hemchand
 * @author Hemanth : After Harini Review
 *
 */

public class PostLoanOffersDAOImpl extends MySQLConnection implements
		PostLoanOffersDAO {

	@Override
	public boolean postOffer(PostLoanOffersDTO postLoanOffersDTO) throws Exception {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		int check = 0;
		try {
			conn = getConnection();
			preparedStatement = conn
					.prepareStatement(Constants.INSERT_LOAN_OFFERS);

			preparedStatement.setInt(1, postLoanOffersDTO.getBankerId());
			preparedStatement.setInt(2, postLoanOffersDTO.getUniversityId());
			preparedStatement.setString(3,postLoanOffersDTO.getOfferName());
			preparedStatement.setFloat(4, postLoanOffersDTO.getInterestRate());
			preparedStatement.setLong(5,postLoanOffersDTO.getMinLoanAmount());
			preparedStatement.setLong(6, postLoanOffersDTO.getMaxLoanAmount());
			preparedStatement.setInt(7, postLoanOffersDTO.getMaxDuration());
			preparedStatement.setString(8, postLoanOffersDTO.getFeatures());
			preparedStatement.setString(9, postLoanOffersDTO.getMandatoryDocs());
			preparedStatement.setBoolean(10, postLoanOffersDTO.isPrePayments());
			preparedStatement.setInt(11, postLoanOffersDTO.getProcessingFee());
			
			check = preparedStatement.executeUpdate();
			
			if(check == 0){
				return false;
			}

		} catch (Exception e) {
			throw e;
		}
		return true;
	}
}
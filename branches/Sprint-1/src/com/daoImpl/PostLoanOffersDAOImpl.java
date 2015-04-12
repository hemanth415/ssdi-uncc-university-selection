package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.connection.MySQLConnection;
import com.dao.PostLoanOffersDAO;
import com.dto.LoanOffersDTO;

public class PostLoanOffersDAOImpl extends MySQLConnection implements
		PostLoanOffersDAO {

	@Override
	public boolean postOffer(LoanOffersDTO loanOfferDTO) throws Exception {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		int check = 0;
		try {
			conn = getConnection();
			preparedStatement = conn
					.prepareStatement("INSERT INTO  loan_offers (banker_id, university_id, post_name, interest_rate, max_amount, post_features,mandatory_docs) VALUES (?,?,?,?,?,?,?)");

			preparedStatement.setInt(1, loanOfferDTO.getBankerId());
			preparedStatement.setInt(2, loanOfferDTO.getUniversityId());
			preparedStatement.setString(3,loanOfferDTO.getOfferName());
			preparedStatement.setInt(4, loanOfferDTO.getInterestRate());
			preparedStatement.setLong(5, loanOfferDTO.getMaxLoanAmount());
			preparedStatement.setString(6, loanOfferDTO.getFeatures());
			preparedStatement.setString(7, loanOfferDTO.getMandatoryDocs());

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
package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.connection.MySQLConnection;
import com.dao.PostLoanOffersDAO;
import com.dto.LoanOffersDTO;
import com.utils.Constants;

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
					.prepareStatement(Constants.INSERT_LOAN_OFFERS);

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
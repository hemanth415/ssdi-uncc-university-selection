package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.MySQLConnection;
import com.dao.SearchLoanOfferDAO;
import com.dto.LoanOffersDTO;
import com.utils.Constants;
import com.utils.EMICalculationUtil;

/**
 * @author Hemchand
 * @author Hemanth : After Harini Review
 *
 */

public class SearchLoanOfferDAOImpl extends MySQLConnection implements SearchLoanOfferDAO{

	@Override
	public List<LoanOffersDTO> fetchLoanOffers(LoanOffersDTO loanOffersDTO) throws Exception {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet  resultSet = null;
		List<LoanOffersDTO> searchResultsList = new ArrayList<LoanOffersDTO>();
		LoanOffersDTO loanOffersResultDTO;
		
		try{
			conn = getConnection();
			//Condition check for loan offers related to all Universities/ a specific University using University ID
	/*		if(loanOfferDTO.getUniversityID() == 1){
				fetchFromLoanOffersStatement = conn.prepareStatement(""
						+ "select banker_id, interest_rate, max_amount, post_features, mandatory_docs  "
						+ "from loan_offers where university_id= 1");
			}else{
				fetchFromLoanOffersStatement = conn.prepareStatement(""
						+ "select banker_id, interest_rate, max_amount, post_features, mandatory_docs "
						+ "from loan_offers "
						+ "where university_id="+loanOfferDTO.getUniversityID());
			}
			System.out.println("Executing Fetch Loan offers");
			loanOffersSet = fetchFromLoanOffersStatement.executeQuery();
			
			//Retrieves bank related details of the Posts retrieved above. 
			System.out.println("Executing fetch From Bankers query");
			while(loanOffersSet.next()){
				fetchFromBankersStatement = conn.prepareStatement(""
						+ "select bank_name, first_name, last_name, bank_contact_no, bank_email_id "
						+ "from bankers "
						+ "where banker_id=" +loanOffersSet.getInt("banker_id") 
						+" and bank_location_id in("
						+ "select location_id"
						+ " from location"
						+ " where country='"+loanOfferDTO.getLoanCountry()+"')");
				
				bankerSet = fetchFromBankersStatement.executeQuery();
				if(bankerSet.next()){
					LoanOfferDTO loanOfferResultDTO = new LoanOfferDTO();
					loanOfferResultDTO.setBankName(bankerSet.getString("bank_name"));
					loanOfferResultDTO.setLoanOfficerName(bankerSet.getString("first_name") +" "+bankerSet.getString("last_name"));
					loanOfferResultDTO.setBankerContactNum(bankerSet.getLong("bank_contact_no"));
					loanOfferResultDTO.setBankerEmailId(bankerSet.getString("bank_email_id"));
					loanOfferResultDTO.setInterestRate(loanOffersSet.getFloat("interest_rate"));
					loanOfferResultDTO.setMaxLoanAmount(loanOffersSet.getLong("max_amount"));
					loanOfferResultDTO.setLoanDescription(loanOffersSet.getString("post_features")+
							" Required Documents are "+ loanOffersSet.getString("mandatory_docs"));
					
					searchResultsList.add(loanOfferResultDTO);
					
				}
			}*/
			preparedStatement = conn.prepareStatement(Constants.SEARCH_LOAN_OFFERS);
			System.out.println(Constants.SEARCH_LOAN_OFFERS);
			preparedStatement.setInt(1, loanOffersDTO.getUniversityID());
			preparedStatement.setLong(2, loanOffersDTO.getLoanAmount());
			preparedStatement.setLong(3, loanOffersDTO.getLoanAmount());
			preparedStatement.setString(4, loanOffersDTO.getLoanCountry());
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				loanOffersResultDTO = new LoanOffersDTO();
				loanOffersResultDTO.setPostId(resultSet.getInt("post_id"));
				loanOffersResultDTO.setBankName(resultSet.getString("bank_name"));
				loanOffersResultDTO.setLoanOfficerName(resultSet.getString("first_name") +", "+resultSet.getString("last_name"));
				loanOffersResultDTO.setBankerContactNum(resultSet.getLong("bank_contact_no"));
				loanOffersResultDTO.setBankerEmailId(resultSet.getString("bank_email_id"));
				loanOffersResultDTO.setInterestRate(resultSet.getFloat("interest_rate"));
				loanOffersResultDTO.setOfferName(resultSet.getString("post_name"));
				loanOffersResultDTO.setDuration(resultSet.getInt("max_duration"));
				loanOffersResultDTO.setLoanDescription(resultSet.getString("post_features")+"\n"+
						" Required Documents are "+ resultSet.getString("mandatory_docs"));
				loanOffersResultDTO.setLoanAmount(loanOffersDTO.getLoanAmount());
				EMICalculationUtil.calculateInstallment(loanOffersResultDTO);
				loanOffersResultDTO.setPrePaymentValue(resultSet.getInt("prePayment") == 0? "No":"Yes");
				searchResultsList.add(loanOffersResultDTO);
			}
		} catch(Exception e){
			throw e;
		}
		return searchResultsList;
	}

}

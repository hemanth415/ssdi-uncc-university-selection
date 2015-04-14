package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.MySQLConnection;
import com.dao.SearchLoanOfferDAO;
import com.dto.LoanOfferDTO;

/**
 * @author Hemchand
 *
 */

public class SearchLoanOfferDAOImpl extends MySQLConnection implements SearchLoanOfferDAO{

	@Override
	public List<LoanOfferDTO> fetchLoanOffersByUnivLcoun(LoanOfferDTO loanOfferDTO) {
		Connection conn = null;
		PreparedStatement fetchFromLoanOffersStatement = null;
		PreparedStatement fetchFromBankersStatement = null;
		ResultSet  loanOffersSet = null;
		ResultSet  bankerSet = null;
		List<LoanOfferDTO> searchResultsList = new ArrayList<LoanOfferDTO>();
		
		try{
			conn = getConnection();
			//Condition check for loan offers related to all Universities/ a specific University using University ID
			if(loanOfferDTO.getUniversityID() == 1){
				fetchFromLoanOffersStatement = conn.prepareStatement(""
						+ "select banker_id, interest_rate, max_amount, post_features, mandloan_offersatory_docs  "
						+ "from loan_offers");
			}else{
				fetchFromLoanOffersStatement = conn.prepareStatement(""
						+ "select banker_id, interest_rate, max_amount, post_features, mandloan_offersatory_docs "
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
							" Required Documents are "+ loanOffersSet.getString("mandloan_offersatory_docs"));
					
					searchResultsList.add(loanOfferResultDTO);
					
					/*System.out.println(bankerSet.getString("bank_name"));
					System.out.println(bankerSet.getString("first_name") +" "+bankerSet.getString("last_name"));
					System.out.println(bankerSet.getLong("bank_contact_no")+"");
					System.out.println(bankerSet.getString("bank_email_id"));
					System.out.println(loanOffersSet.getFloat("interest_rate")+"");
					System.out.println(loanOffersSet.getLong("max_amount")+"");
					System.out.println(loanOffersSet.getString("post_features")+
							" Required Documents are "+ loanOffersSet.getString("mandloan_offersatory_docs"));*/
					
				}
			}
			return searchResultsList;
		} catch(Exception E){
			System.out.println(E+"");
		}
		return null;
	}

}

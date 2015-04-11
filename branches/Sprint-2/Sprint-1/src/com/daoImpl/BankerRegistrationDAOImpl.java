package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.connection.MySQLConnection;
import com.dao.BankerRegistrationDAO;
import com.dto.BankerDTO;

public class BankerRegistrationDAOImpl extends MySQLConnection implements BankerRegistrationDAO{

	int i=0;
	
	@Override
	public boolean bankerRegistration(BankerDTO bankerDTO) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement bankerPreparedStatement = null;
		PreparedStatement loginPreparedStatement = null;
		
		try{
			conn = getConnection();
			bankerPreparedStatement = conn.prepareStatement("INSERT INTO bankers (first_name, last_name, bank_name, bank_address, "
					+ "bank_contact_no, bank_email_id, bank_location_id, bank_zip_code, email_id, contact_no) "
					+ "values(?,?,?,?,?,?,?,?,?,?)");
			bankerPreparedStatement.setString(1, bankerDTO.getFirstName());
			bankerPreparedStatement.setString(2, bankerDTO.getLastName());
			bankerPreparedStatement.setString(3, bankerDTO.getBankName());
			bankerPreparedStatement.setString(4, bankerDTO.getBankAddress());
			bankerPreparedStatement.setLong(5, bankerDTO.getBankContactNum());
			bankerPreparedStatement.setString(6, bankerDTO.getBankEmailId());
			bankerPreparedStatement.setInt(7, 103);
			bankerPreparedStatement.setInt(8, bankerDTO.getBankZipCode());
			bankerPreparedStatement.setString(9, bankerDTO.getBankerEmailId());
			bankerPreparedStatement.setLong(10, bankerDTO.getBankerContactNum());
			i = bankerPreparedStatement.executeUpdate();
			
			if(i != 0){
				System.out.println("Insert data in to bankers table success");
				loginPreparedStatement = conn.prepareStatement("INSERT INTO login_cred (login_id, login_password, user_type) VALUES(?,?,?)");
				loginPreparedStatement.setString(1, bankerDTO.getBankerEmailId());
				loginPreparedStatement.setString(2, bankerDTO.getPassword());
				loginPreparedStatement.setString(3, "B");
				i = loginPreparedStatement.executeUpdate();
				
				if(i == 0) {
					System.out.println("Insert Login credentials in to login_cred table failed");
					return false;
				}
			}
			
			
		} catch(Exception e){
			System.out.println(e+"");
		}
		
		if(i != 0) {
			return true;
		} else {
			return false;
		}
	}

}

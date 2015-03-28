package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.MySQLConnection;
import com.dao.BankerRegistrationDAO;
import com.dto.BankerDTO;

public class BankerRegistrationDAOImpl extends MySQLConnection implements BankerRegistrationDAO{

	int i=0;
	
	@Override
	public boolean bankerRegistration(BankerDTO bankerDTO) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try{
			conn = getConnection();
			preparedStatement = conn.prepareStatement("INSERT INTO bankers (first_name, last_name, bank_name, bank_address, "
					+ "bank_contact_no, bank_email_id, bank_location_id, bank_zip_code, email_id, contact_no) "
					+ "values(?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, bankerDTO.getFirstName());
			preparedStatement.setString(2, bankerDTO.getLastName());
			preparedStatement.setString(3, bankerDTO.getBankName());
			preparedStatement.setString(4, bankerDTO.getBankAddress());
			preparedStatement.setLong(5, bankerDTO.getBankContactNum());
			preparedStatement.setString(6, bankerDTO.getBankEmailId());
			preparedStatement.setInt(7, 103);
			preparedStatement.setInt(8, bankerDTO.getBankZipCode());
			preparedStatement.setString(9, bankerDTO.getBankerEmailId());
			preparedStatement.setLong(10, bankerDTO.getBankerContactNum());
			i = preparedStatement.executeUpdate();
			
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

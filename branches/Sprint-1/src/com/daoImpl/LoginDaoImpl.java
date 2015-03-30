package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.MySQLConnection;
import com.dao.LoginDao;
import com.dto.UserDTO;

public class LoginDaoImpl extends MySQLConnection implements LoginDao{

	@Override
	public char validateLogin(UserDTO userDTO) {
      char userRole = ' ';  
      Connection connection = null;  
      PreparedStatement preparedStatement = null;  
      ResultSet resultSet = null;    
      try {   
    	  connection = getConnection();  
    	  preparedStatement = connection  
                   .prepareStatement("select user_type from login_cred where login_id=? and login_password=?");  
    	  preparedStatement.setString(1, userDTO.getUserName());
    	  preparedStatement.setString(2, userDTO.getUserPassword());  
    	  resultSet = preparedStatement.executeQuery();  
          if(resultSet.next()){
        	  userRole = resultSet.getString("user_type").charAt(0);
          }
      }catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
					if(connection != null){
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
      return userRole; 
	}

	@Override
	public UserDTO fetchBankerDetails(UserDTO userDTO) {
		Connection connection = null;  
		PreparedStatement preparedStatement = null;  
		ResultSet resultSet = null;
		try {
			connection = getConnection();  
			preparedStatement = connection.prepareStatement("select * from bankers where email_id=?");  
			preparedStatement.setString(1, userDTO.getUserName());
			resultSet = preparedStatement.executeQuery();
			if(resultSet != null && resultSet.next()){
				userDTO.setFirstName(resultSet.getString("first_name"));
				userDTO.setLastName(resultSet.getString("last_name"));
				userDTO.setBankName(resultSet.getString("bank_name"));
				userDTO.setBankAddress(resultSet.getString("bank_address"));
				userDTO.setBankContactNo(resultSet.getLong("bank_contact_no"));
				userDTO.setBankEmailId(resultSet.getString("bank_email_id"));
				//userDTO.setbank(resultSet.getString("bank_location_id"));
				userDTO.setBankZipCode(resultSet.getInt("bank_zip_code"));
				userDTO.setEmailId(resultSet.getString("email_id"));
				userDTO.setContactNo(resultSet.getLong("contact_no"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
					if(connection != null){
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userDTO;
	}

	@Override
	public UserDTO fetchStudentDetails(UserDTO userDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;  
		ResultSet resultSet = null;
		try {
			connection = getConnection();  
			preparedStatement = connection.prepareStatement("select * from students where email_id=?");  
			preparedStatement.setString(1, userDTO.getUserName());
			resultSet = preparedStatement.executeQuery();
			if(resultSet != null && resultSet.next()){
				userDTO.setFirstName(resultSet.getString("first_name"));
				userDTO.setLastName(resultSet.getString("last_name"));
				userDTO.setEmailId(resultSet.getString("email_id"));
				userDTO.setContactNo(resultSet.getLong("contact_no"));	
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
					if(connection != null){
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userDTO;
	}

	
}
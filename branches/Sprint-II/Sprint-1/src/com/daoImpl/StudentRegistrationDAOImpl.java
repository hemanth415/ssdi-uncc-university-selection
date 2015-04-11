package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.connection.MySQLConnection;
import com.dao.StudentRegistrationDAO;
import com.dto.StudentDTO;

public class StudentRegistrationDAOImpl extends MySQLConnection implements StudentRegistrationDAO{
	
	@Override
	public boolean studentRegistration(StudentDTO studentDTO) {
		int i=0;
		Connection conn = null;
		PreparedStatement studentPreparedStatement = null;
		PreparedStatement loginPreparedStatement = null;
		
		try{
			conn = getConnection();
			studentPreparedStatement = conn.prepareStatement("INSERT INTO students (first_name, last_name, address, "
					+ "location_id, zip_code, email_id, contact_no) "
					+ "values(?,?,?,?,?,?,?)");
			studentPreparedStatement.setString(1, studentDTO.getFirstName());
			studentPreparedStatement.setString(2, studentDTO.getLastName());
			studentPreparedStatement.setString(3, studentDTO.getAddress());
			studentPreparedStatement.setInt(4, 103);
			studentPreparedStatement.setInt(5, studentDTO.getZipCode());
			studentPreparedStatement.setString(6, studentDTO.getStudentEmailId());
			studentPreparedStatement.setLong(7, studentDTO.getStudentContactNum());
			i = studentPreparedStatement.executeUpdate();
			
			if(i != 0){
				System.out.println("Insert data in to students table success");
				loginPreparedStatement = conn.prepareStatement("INSERT INTO login_cred (login_id, login_password, user_type) VALUES(?,?,?)");
				loginPreparedStatement.setString(1, studentDTO.getStudentEmailId());
				loginPreparedStatement.setString(2, studentDTO.getPassword());
				loginPreparedStatement.setString(3, "S");
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

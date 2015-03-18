package com.daoImpl;

import java.sql.Connection;
import java.sql.Statement;

import com.connection.MySQLConnection;
import com.dao.UniversitySearchDAO;
import com.dto.UniversityDTO;

public class UniversitySearchDAOImpl  extends MySQLConnection implements UniversitySearchDAO{

	@Override
	public UniversityDTO fetchUniversityDetails() {
		Connection conn = null;
		Statement stmt = null;
		StringBuffer query = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
		    //stmt.executeUpdate(query);
		}catch(Exception e){
			
		}
		return null;
	}

}

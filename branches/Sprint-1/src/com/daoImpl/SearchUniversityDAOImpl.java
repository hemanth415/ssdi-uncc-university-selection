package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.connection.MySQLConnection;
import com.dao.SearchUniversityDAO;
import com.dto.UniversityDTO;

/**
 * @author Hemanth
 *
 */
public class SearchUniversityDAOImpl  extends MySQLConnection implements SearchUniversityDAO{

	@Override
	public UniversityDTO fetchUniversityDetails(UniversityDTO universityDTO) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		StringBuffer query = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			query = new StringBuffer().append("select count(1) from universities");
			resultSet = stmt.executeQuery(query.toString());
			while(resultSet.next()){
				
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}

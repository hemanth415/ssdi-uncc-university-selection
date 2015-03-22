package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.MySQLConnection;
import com.dao.SearchUniversityDAO;
import com.dto.UniversityDTO;
import com.utils.Constants;

/**
 * @author Hemanth
 *
 */
public class SearchUniversityDAOImpl  extends MySQLConnection implements SearchUniversityDAO{

	@Override
	public List<UniversityDTO> fetchUniversityDetails(UniversityDTO universityDTO) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<UniversityDTO> universityDTOs = new ArrayList<UniversityDTO>();
		UniversityDTO dto=null;
		try{
			conn = getConnection();
			preparedStatement = conn.prepareStatement(Constants.SEARCH_BY_COUNTRY_STATE);
			preparedStatement.setString(1, universityDTO.getUniversityCountry());
			preparedStatement.setString(2, universityDTO.getUniversityState());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				dto = new UniversityDTO();
				dto.setUniversityName(resultSet.getString("university_name"));
				dto.setUniversityDesc(resultSet.getString("university_desc"));
				dto.setAddress(resultSet.getString("address"));
				dto.setContact(resultSet.getLong("contact_no"));
				dto.seteMail(resultSet.getString("email_id"));
				universityDTOs.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return universityDTOs;
	}

}

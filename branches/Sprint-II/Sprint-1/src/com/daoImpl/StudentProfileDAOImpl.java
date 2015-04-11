package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.MySQLConnection;
import com.dao.StudentProfileDAO;
import com.dto.StudentDTO;
import com.utils.Constants;
import com.utils.ValidatorUtils;

public class StudentProfileDAOImpl extends MySQLConnection implements
		StudentProfileDAO {

	@Override
	public List<StudentDTO> fetchStudentProfiles(String term1, String term2)
			throws Exception {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<StudentDTO> studentDTOs = new ArrayList<StudentDTO>();
		StudentDTO dto = null;
		StringBuilder builder = new StringBuilder();
		try {
			builder.append(Constants.SEARCH_STUDENTS_PROFILE);
			if (ValidatorUtils.validateString(term1)) {
				builder.append(Constants.SINGLE_QUOTE).append(term1)
						.append(Constants.SINGLE_QUOTE);
				if (ValidatorUtils.validateString(term2)) {
					builder.append(Constants.COMMA)
							.append(Constants.SINGLE_QUOTE).append(term2)
							.append(Constants.SINGLE_QUOTE);
				}
			} else if (ValidatorUtils.validateString(term2)) {
				builder.append(Constants.SINGLE_QUOTE).append(term2)
						.append(Constants.SINGLE_QUOTE);
			}
			builder.append(")");
			System.out.println(builder.toString());
			conn = getConnection();
			preparedStatement = conn.prepareStatement(builder.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				dto = new StudentDTO();
				dto.setFirstName(resultSet.getString("first_name")
						+ Constants.COMMA + resultSet.getString("last_name"));
				dto.setAddress(resultSet.getString("address") + Constants.COMMA
						+ resultSet.getString("state") + Constants.COMMA
						+ resultSet.getString("country") + ", "
						+ resultSet.getInt("zip_code"));
				dto.setAppliedTerm(resultSet.getString("applied_term"));
				studentDTOs.add(dto);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return studentDTOs;
	}

}

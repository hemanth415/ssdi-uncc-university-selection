package com.dao;

import java.util.List;

import com.dto.StudentDTO;

public interface StudentProfileDAO {
	public List<StudentDTO> fetchStudentProfiles(String term1,String term2) throws Exception;
}

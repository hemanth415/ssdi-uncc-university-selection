package com.dao;

import java.util.List;

import com.dto.UniversityDTO;

/**
 * @author Hemanth
 *
 */
public interface SearchUniversityDAO {
	public List<UniversityDTO> fetchUniversityDetails(UniversityDTO universityDTO);
}

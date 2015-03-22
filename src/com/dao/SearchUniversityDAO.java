package com.dao;

import com.dto.UniversityDTO;

/**
 * @author Hemanth
 *
 */
public interface SearchUniversityDAO {
	public UniversityDTO fetchUniversityDetails(UniversityDTO universityDTO);
}

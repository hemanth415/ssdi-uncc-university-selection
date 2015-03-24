package com.dao;

import java.util.List;

import com.dto.UniversityDTO;

/**
 * @author Hemanth
 *
 */
public interface SearchUniversityDAO {
	public List<UniversityDTO> fetchUniversitiesByCntryState(UniversityDTO universityDTO);
	public List<UniversityDTO> fetchUniversityByName(UniversityDTO universityDTO);
}

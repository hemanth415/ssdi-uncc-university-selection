package com.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.dao.SearchUniversityDAO;
import com.daoImpl.SearchUniversityDAOImpl;
import com.dto.UniversityDTO;
import com.utils.ValidatorUtils;

/**
 * @author Hemanth
 *
 */
public class SearchUniversityTest {
	UniversityDTO dto;
	SearchUniversityDAO searchUniversityDAO;

	@Before
	public void setUp() throws Exception {
		dto = new UniversityDTO();
		searchUniversityDAO = new SearchUniversityDAOImpl();
	}

	@Test
	public void validateFetchUnivByNameSuccess() {
		dto.setUniversityName("North Carolina State University");
		assertTrue("Success validation Fetch University By Name",
				searchUniversityDAO.fetchUniversityByName(dto).size() > 0);
	}
	
	@Test
	public void validateFetchUnivByNameFailure() {
		dto.setUniversityName("South Carolina State University");
		assertFalse("Failure validation Fetch University By Name",
				searchUniversityDAO.fetchUniversityByName(dto).size() > 0);
	}
	
	@Test
	public void validateFetchUnivByCntryStateSuccess() {
		dto.setUniversityCountry("US");
		dto.setUniversityState("north carolina");
		assertTrue("Success validation Fetch University By Country and State",
				searchUniversityDAO.fetchUniversitiesByCntryState(dto).size() > 0);
	}
	
	@Test
	public void validateCountrySuccess() {
		dto.setUniversityCountry("US");
		assertTrue("Success validation Country",ValidatorUtils.validateCountry(dto.getUniversityCountry()));
	}
	
	@Test
	public void validateCountryFailure() {
		dto.setUniversityCountry("ENGLAND");
		assertFalse("Faliure validation Country",ValidatorUtils.validateCountry(dto.getUniversityCountry()));
	}

}

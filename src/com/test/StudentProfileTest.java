/**
 * 
 */
package com.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dao.StudentProfileDAO;
import com.daoImpl.StudentProfileDAOImpl;
import com.dto.StudentDTO;

/**
 * @author Hemanth
 *
 */
public class StudentProfileTest {

	private StudentProfileDAO studentProfileDAO;
	private String term1 = null;
	private String term2 = null;

	@Before
	public void setUp() throws Exception {
		studentProfileDAO = new StudentProfileDAOImpl();
	}

	/**
	 * Test method for
	 * {@link com.daoImpl.StudentProfileDAOImpl#fetchStudentProfiles(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void validateFetchStdntProfiesSuccess1() {
		List<StudentDTO> studentDTOs = null;
		term1 = "Spring-2015";
		try {
			studentDTOs = studentProfileDAO.fetchStudentProfiles(term1, term2);
			assertTrue("Success validation Fetch Student Profiles",
					studentDTOs.size() > 0);
		} catch (Exception e) {
			fail("Unexpected error. " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.daoImpl.StudentProfileDAOImpl#fetchStudentProfiles(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void validateFetchStdntProfiesSuccess2() {
		List<StudentDTO> studentDTOs = null;
		term1 = "Spring-2015";
		term2 = "Fall-2015";
		try {
			studentDTOs = studentProfileDAO.fetchStudentProfiles(term1, term2);
			assertTrue("Success validation Fetch Student Profiles",
					studentDTOs.size() > 0);
		} catch (Exception e) {
			fail("Unexpected error. " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.daoImpl.StudentProfileDAOImpl#fetchStudentProfiles(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void validateFetchStdntProfiesFailure() {
		List<StudentDTO> studentDTOs = null;
		term2 = "Fall-2015";
		try {
			studentDTOs = studentProfileDAO.fetchStudentProfiles(term1, term2);
			assertFalse("Failure validation Fetch Student Profiles",
					studentDTOs.size() > 0);
		} catch (Exception e) {
			fail("Unexpected error. " + e.getMessage());
		}
	}
}

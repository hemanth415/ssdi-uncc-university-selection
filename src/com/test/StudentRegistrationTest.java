package com.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.dao.StudentRegistrationDAO;
import com.daoImpl.StudentRegistrationDAOImpl;
import com.dto.StudentDTO;

public class StudentRegistrationTest {
	StudentDTO dto = null;
	StudentRegistrationDAO studentRegistrationDAO;

	@Before
	public void setUp() throws Exception {
		dto = new StudentDTO();
		studentRegistrationDAO = new StudentRegistrationDAOImpl();
	}

	@Test
	public void validateStudentRegistrationSuccess() {
		dto.setFirstName("Hemchand");
		dto.setLastName("Ramireddy");
		dto.setStudentEmailId("bofa@bofa.com");
		dto.setPassword("hemdec24");
		dto.setAddress("University Terrace drive");
		dto.setZipCode(28262);
		dto.setStudentContactNum(Long.parseLong("9123123123"));	
		
		assertTrue("Success validation for Banker registration",
				studentRegistrationDAO.studentRegistration(dto));
	}
	
	@Test
	public void validateStudentRegistrationFailure() {
		//Commenting the entry of the required email.
		//dto.setStudentEmailId("bofa@bofa.com");
		
		dto.setFirstName("Hemchand");
		dto.setLastName("Ramireddy");
		dto.setPassword("hemdec24");
		dto.setAddress("University Terrace drive");
		dto.setZipCode(28262);
		dto.setStudentContactNum(Long.parseLong("9123123123"));
		
		assertFalse("Failure validation for Banker registration",
				studentRegistrationDAO.studentRegistration(dto));
		
	}
	
	@Test
	public void validateLoginInsertionSuccess() {
		dto.setFirstName("Hemchand");
		dto.setLastName("Ramireddy");
		dto.setStudentEmailId("hem@bofa.com");
		dto.setPassword("hemdec24");
		dto.setAddress("University Terrace drive");
		dto.setZipCode(28262);
		dto.setStudentContactNum(Long.parseLong("9123123123"));
		
		assertTrue("Sccess validation for Login credentials insertion",
				studentRegistrationDAO.studentRegistration(dto));
		
	}
	
	@Test
	public void validateLoginInsertionFailure() {
		dto.setFirstName("Hemchand");
		dto.setLastName("Ramireddy");
		dto.setStudentEmailId("hem@bofa.com");
		dto.setPassword("hemdec24");
		dto.setAddress("University Terrace drive");
		dto.setZipCode(28262);
		dto.setStudentContactNum(Long.parseLong("9123123123"));
		
		assertFalse("Failure validation for Login credentials insertion",
				studentRegistrationDAO.studentRegistration(dto));
		
	}
}

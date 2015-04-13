package com.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.dao.BankerRegistrationDAO;
import com.daoImpl.BankerRegistrationDAOImpl;
import com.dto.BankerDTO;

/**
 * @author Hemchand
 *
 */
public class BankerRegistrationTest {
	BankerDTO dto = null;
	BankerRegistrationDAO bankerRegistrationDAO;

	@Before
	public void setUp() throws Exception {
		dto = new BankerDTO();
		bankerRegistrationDAO = new BankerRegistrationDAOImpl();
	}

	@Test
	public void validateBankerRegistrationSuccess() {
		
		dto.setFirstName("Hemchand");
		dto.setLastName("Ramireddy");
		dto.setBankName("BOFA");
		dto.setBankAddress("North Tryon Street");
		dto.setBankContactNum(Long.parseLong("9123123123"));
		dto.setBankEmailId("bofa@bofa.com");
		dto.setBankZipCode(28262);
		dto.setUserName("hemdec24");
		dto.setPassword("hemdec24");
		dto.setBankerEmailId("scott@bofa.com");
		dto.setBankerContactNum(Long.parseLong("9234234234"));
		
		
		assertTrue("Success validation for Banker registration",
				bankerRegistrationDAO.bankerRegistration(dto));
	}
	
	@Test
	public void validateBankerRegistrationFailure() {
		//dto.setFirstName("Hemanth");
		dto.setLastName("Ponnuru");
		dto.setBankName("BOFA");
		dto.setBankAddress("North Tryon Street");
		dto.setBankContactNum(Long.parseLong("9123123123"));
		dto.setBankEmailId("bofa@bofa.com");
		dto.setBankZipCode(28262);
		dto.setUserName("hponnuru");
		dto.setPassword("hponnuru");
		dto.setBankerEmailId("hemanth@bofa.com");
		dto.setBankerContactNum(Long.parseLong("9234234234"));
		
		assertFalse("Failure validation for Banker registration",
				bankerRegistrationDAO.bankerRegistration(dto));
		
	}
	
	@Test
	public void validateLoginInsertionSuccess() {
		dto.setFirstName("Siva");
		dto.setLastName("Krishna");
		dto.setBankName("BOFA");
		dto.setBankAddress("North Tryon Street");
		dto.setBankContactNum(Long.parseLong("9123123123"));
		dto.setBankEmailId("bofa@bofa.com");
		dto.setBankZipCode(28262);
		dto.setUserName("siva");
		dto.setPassword("siva");
		dto.setBankerEmailId("siva@bofa.com");
		dto.setBankerContactNum(Long.parseLong("9234234234"));
		
		assertTrue("Sccess validation for Login credentials insertion",
				bankerRegistrationDAO.bankerRegistration(dto));
		
	}
	
	@Test
	public void validateLoginInsertionFailure() {
		dto.setFirstName("Anusha");
		dto.setLastName("vanam");
		dto.setBankName("BOFA");
		dto.setBankAddress("North Tryon Street");
		dto.setBankContactNum(Long.parseLong("9123123123"));
		dto.setBankEmailId("bofa@bofa.com");
		dto.setBankZipCode(28262);
		dto.setUserName("hemdec24");
		dto.setPassword("hemdec24");
		dto.setBankerEmailId("siva@bofa.com");
		dto.setBankerContactNum(Long.parseLong("9234234234"));
		
		assertFalse("Failure validation for Login credentials insertion",
				bankerRegistrationDAO.bankerRegistration(dto));
		
	}
}
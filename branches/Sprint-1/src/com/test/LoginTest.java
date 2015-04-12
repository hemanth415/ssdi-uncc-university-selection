/**
 * 
 */
package com.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.dao.LoginDao;
import com.daoImpl.LoginDaoImpl;
import com.dto.UserDTO;

/**
 * @author Hemanth
 *
 */
public class LoginTest {
	
	private LoginDao loginDao;
	private UserDTO userDTO;

	@Before
	public void setUp() throws Exception {
		loginDao = new LoginDaoImpl();
		userDTO = new UserDTO();
	}

	/**
	 * Test method for
	 * {@link com.daoImpl.LoginDaoImpl#validateLogin(com.dto.UserDTO)}.
	 */
	@Test
	public void validateStudentLoginSuccess() {
		userDTO.setUserName("siva123@gmail.com");
		userDTO.setUserPassword("123");
		assertEquals("Successful Student Login.", 'S',loginDao.validateLogin(userDTO));
	}
	
	
	/**
	 * Test method for
	 * {@link com.daoImpl.LoginDaoImpl#validateLogin(com.dto.UserDTO)}.
	 */
	@Test
	public void validateBankerLoginSuccess() {
		userDTO.setUserName("kvineet@gmail.com");
		userDTO.setUserPassword("kvineet@gmail.com");
		assertEquals("Successful Banker Login.", 'B',loginDao.validateLogin(userDTO));
	}

	/**
	 * Test method for
	 * {@link com.daoImpl.LoginDaoImpl#fetchBankerDetails(com.dto.UserDTO)}.
	 */
	@Test
	public void testFetchBankerDetails() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link com.daoImpl.LoginDaoImpl#fetchStudentDetails(com.dto.UserDTO)}.
	 */
	@Test
	public void testFetchStudentDetails() {
		fail("Not yet implemented"); // TODO
	}

}

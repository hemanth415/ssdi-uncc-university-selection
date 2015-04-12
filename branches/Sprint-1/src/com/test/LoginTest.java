/**
 * 
 */
package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
		try {
			userDTO.setUserName("siva123@gmail.com");
			userDTO.setUserPassword("123");
			assertEquals("Successful Student Login.", 'B',
					loginDao.validateLogin(userDTO));
		} catch (Exception e) {
			fail("Unexpected error. " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.daoImpl.LoginDaoImpl#validateLogin(com.dto.UserDTO)}.
	 */
	@Test
	public void validateBankerLoginSuccess() {
		try {
			userDTO.setUserName("kvineet@gmail.com");
			userDTO.setUserPassword("kvineet@gmail.com");
			assertEquals("Successful Banker Login.", 'S',
					loginDao.validateLogin(userDTO));
		} catch (Exception e) {
			fail("Unexpected error. " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.daoImpl.LoginDaoImpl#validateLogin(com.dto.UserDTO)}.
	 */
	@Test
	public void validatePwdLoginFailure() {
		try {
			userDTO.setUserName("kvineet@gmail.com");
			userDTO.setUserPassword("123");
			assertNotEquals("Login Failure.", 'S',
					loginDao.validateLogin(userDTO));
		} catch (Exception e) {
			fail("Unexpected error. " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.daoImpl.LoginDaoImpl#validateLogin(com.dto.UserDTO)}.
	 */
	@Test
	public void validateUserNameLoginFailure() {
		try {
			userDTO.setUserName("siva1234@gmail.com");
			userDTO.setUserPassword("123");
			assertNotEquals("Login Failure.", 'S',
					loginDao.validateLogin(userDTO));
		} catch (Exception e) {
			fail("Unexpected error. " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.daoImpl.LoginDaoImpl#fetchStudentDetails(com.dto.UserDTO)}.
	 */
	@Test
	public void testFetchStudentDetails() {
		try {
			userDTO.setUserName("kvineet@gmail.com");
			userDTO.setUserPassword("kvineet@gmail.com");
			loginDao.fetchStudentDetails(userDTO);
			assertTrue("Successful in fetching Student details.", userDTO
					.getFirstName().equals("Vineet"));
		} catch (Exception e) {
			fail("Unexpected error. " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.daoImpl.LoginDaoImpl#fetchBankerDetails(com.dto.UserDTO)}.
	 */
	@Test
	public void testFetchBankerDetails() {
		try {
			userDTO.setUserName("siva123@gmail.com");
			userDTO.setUserPassword("123");
			loginDao.fetchBankerDetails(userDTO);
			assertTrue("Successful in fetching Banker details.", userDTO
					.getFirstName().equals("Siva"));
		} catch (Exception e) {
			fail("Unexpected error. " + e.getMessage());
		}
	}

}

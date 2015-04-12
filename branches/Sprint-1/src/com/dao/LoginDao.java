package com.dao;

import com.dto.UserDTO;

public interface LoginDao {

	public char validateLogin(UserDTO userDTO);

	public UserDTO fetchStudentDetails(UserDTO userDTO);

	public UserDTO fetchBankerDetails(UserDTO userDTO);
}

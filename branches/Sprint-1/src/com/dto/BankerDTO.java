package com.dto;

import java.math.BigDecimal;

/**
 * @author Hemchand
 *
 */

public class BankerDTO {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String bankerEmailId;
	private long bankerContactNum;
	
	private String bankName;
	private String bankAddress;
	private long bankContactNum;
	private String bankEmailId;
	private int bankZipCode; //bank_location_id
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	public long getBankContactNum() {
		return bankContactNum;
	}
	public void setBankContactNum(long bankContactNum) {
		this.bankContactNum = bankContactNum;
	}
	public String getBankEmailId() {
		return bankEmailId;
	}
	public void setBankEmailId(String bankEmailId) {
		this.bankEmailId = bankEmailId;
	}
	public int getBankZipCode() {
		return bankZipCode;
	}
	public void setBankZipCode(int bankZipCode) {
		this.bankZipCode = bankZipCode;
	}
	public String getBankerEmailId() {
		return bankerEmailId;
	}
	public void setBankerEmailId(String bankerEmailId) {
		this.bankerEmailId = bankerEmailId;
	}
	public long getBankerContactNum() {
		return bankerContactNum;
	}
	public void setBankerContactNum(long bankerContactNum) {
		this.bankerContactNum = bankerContactNum;
	}
}

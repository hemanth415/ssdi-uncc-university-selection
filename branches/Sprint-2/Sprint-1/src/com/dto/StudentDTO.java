package com.dto;

public class StudentDTO {
	private String firstName;
	private String lastName;
	private String password;
	private String studentEmailId;
	private String address;
	private int zipCode;
	private long studentContactNum;
	private String appliedTerm;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStudentEmailId() {
		return studentEmailId;
	}
	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public long getStudentContactNum() {
		return studentContactNum;
	}
	public void setStudentContactNum(long studentContactNum) {
		this.studentContactNum = studentContactNum;
	}
	public String getAppliedTerm() {
		return appliedTerm;
	}
	public void setAppliedTerm(String appliedTerm) {
		this.appliedTerm = appliedTerm;
	}
}

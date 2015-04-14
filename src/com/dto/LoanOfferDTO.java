package com.dto;

public class LoanOfferDTO {
	private int universityID;
	private String loanCountry;
	private String bankName;
	private String loanOfficerName;
	private long bankerContactNum;
	private String bankerEmailId;
	private float interestRate;
	private long maxLoanAmount;
	private String loanDescription;
	
	public int getUniversityID() {
		return universityID;
	}
	public void setUniversityID(int universityID) {
		this.universityID = universityID;
	}
	public String getLoanCountry() {
		return loanCountry;
	}
	public void setLoanCountry(String loanCountry) {
		this.loanCountry = loanCountry;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getLoanOfficerName() {
		return loanOfficerName;
	}
	public void setLoanOfficerName(String loanOfficerName) {
		this.loanOfficerName = loanOfficerName;
	}
	public long getBankerContactNum() {
		return bankerContactNum;
	}
	public void setBankerContactNum(long bankerContactNum) {
		this.bankerContactNum = bankerContactNum;
	}
	public String getBankerEmailId() {
		return bankerEmailId;
	}
	public void setBankerEmailId(String bankerEmailId) {
		this.bankerEmailId = bankerEmailId;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	public long getMaxLoanAmount() {
		return maxLoanAmount;
	}
	public void setMaxLoanAmount(long maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}
	public String getLoanDescription() {
		return loanDescription;
	}
	public void setLoanDescription(String loanDescription) {
		this.loanDescription = loanDescription;
	}
}

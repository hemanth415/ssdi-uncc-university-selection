package com.dto;

public class LofferDTO {
	
	private String universityName;
	private String lCountry;
	private String bankName;
	private String lOfficer;
	private long bankerContactNum;
	private String bankerEmailId;
	private float interestRate;
	private long maxLoanAmount;
	private String loanDescription; //bank_location_id
	
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getLCountry() {
		return lCountry;
	}
	public void setLCountry(String lCountry) {
		this.lCountry = lCountry;
	}
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getLOfficer() {
		return lOfficer;
	}
	public void setLOfficer(String lOfficer) {
		this.lOfficer = lOfficer;
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

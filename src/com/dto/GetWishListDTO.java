package com.dto;

public class GetWishListDTO {
	private int postId, userId;
	private float interestRate;
	private String bankName, loanOfficer;
	private long telephone, loanAmount;
	private String email, loanDetails;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	public long getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getLoanOfficer() {
		return loanOfficer;
	}
	public void setLoanOfficer(String loanOfficer) {
		this.loanOfficer = loanOfficer;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoanDetails() {
		return loanDetails;
	}
	public void setLoanDetails(String loanDetails) {
		this.loanDetails = loanDetails;
	}
	
	@Override
	public String toString() {
		return "GetWishListDTO [postId=" + postId + ", interestRate="
				+ interestRate + ", loanAmount=" + loanAmount + ", bankName="
				+ bankName + ", loanOfficer=" + loanOfficer + ", telephone="
				+ telephone + ", Email=" + email + ", loanDetails="
				+ loanDetails + "]";
	}
}

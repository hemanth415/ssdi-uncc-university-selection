package com.dto;

import java.io.Serializable;

/**
 * @author Hemchand
 * @author Hemanth : After Harini Review
 *
 */

public class LoanOffersDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3115060517602060816L;
	private int universityID;
	private String loanCountry;
	private String bankName;
	private String loanOfficerName;
	private long bankerContactNum;
	private String bankerEmailId;
	private float interestRate;
	private long loanAmount;
	private String loanDescription;
	private double installments;
	private int duration;
	private boolean prePayment;
	private String offerName;
	private String prePaymentValue;
	private int postId;
	
	/**
	 * @return the universityID
	 */
	public int getUniversityID() {
		return universityID;
	}
	/**
	 * @param universityID the universityID to set
	 */
	public void setUniversityID(int universityID) {
		this.universityID = universityID;
	}
	/**
	 * @return the loanCountry
	 */
	public String getLoanCountry() {
		return loanCountry;
	}
	/**
	 * @param loanCountry the loanCountry to set
	 */
	public void setLoanCountry(String loanCountry) {
		this.loanCountry = loanCountry;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the loanOfficerName
	 */
	public String getLoanOfficerName() {
		return loanOfficerName;
	}
	/**
	 * @param loanOfficerName the loanOfficerName to set
	 */
	public void setLoanOfficerName(String loanOfficerName) {
		this.loanOfficerName = loanOfficerName;
	}
	/**
	 * @return the bankerContactNum
	 */
	public long getBankerContactNum() {
		return bankerContactNum;
	}
	/**
	 * @param bankerContactNum the bankerContactNum to set
	 */
	public void setBankerContactNum(long bankerContactNum) {
		this.bankerContactNum = bankerContactNum;
	}
	/**
	 * @return the bankerEmailId
	 */
	public String getBankerEmailId() {
		return bankerEmailId;
	}
	/**
	 * @param bankerEmailId the bankerEmailId to set
	 */
	public void setBankerEmailId(String bankerEmailId) {
		this.bankerEmailId = bankerEmailId;
	}
	/**
	 * @return the interestRate
	 */
	public float getInterestRate() {
		return interestRate;
	}
	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	/**
	 * @return the loanAmount
	 */
	public long getLoanAmount() {
		return loanAmount;
	}
	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}
	/**
	 * @return the loanDescription
	 */
	public String getLoanDescription() {
		return loanDescription;
	}
	/**
	 * @param loanDescription the loanDescription to set
	 */
	public void setLoanDescription(String loanDescription) {
		this.loanDescription = loanDescription;
	}
	/**
	 * @return the installments
	 */
	public double getInstallments() {
		return installments;
	}
	/**
	 * @param installments the installments to set
	 */
	public void setInstallments(double installments) {
		this.installments = installments;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duraition the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * @return the prePayment
	 */
	public boolean isPrePayment() {
		return prePayment;
	}
	/**
	 * @param prePayment the prePayment to set
	 */
	public void setPrePayment(boolean prePayment) {
		this.prePayment = prePayment;
	}
	/**
	 * @return the offerName
	 */
	public String getOfferName() {
		return offerName;
	}
	/**
	 * @param offerName the offerName to set
	 */
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	/**
	 * @return the prePaymentValue
	 */
	public String getPrePaymentValue() {
		return prePaymentValue;
	}
	/**
	 * @param prePaymentValue the prePaymentValue to set
	 */
	public void setPrePaymentValue(String prePaymentValue) {
		this.prePaymentValue = prePaymentValue;
	}
	/**
	 * @return the postId
	 */
	public int getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}
}

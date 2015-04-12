package com.dto;

public class LoanOffersDTO {
	private int universityId;
	private int bankerId;
	private String offerName;
	private String features;
	private String mandatoryDocs;
	private int interestRate;
	private long maxLoanAmount;
	/**
	 * @return the universityId
	 */
	public int getUniversityId() {
		return universityId;
	}
	/**
	 * @param universityId the universityId to set
	 */
	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}
	/**
	 * @return the bankerId
	 */
	public int getBankerId() {
		return bankerId;
	}
	/**
	 * @param bankerId the bankerId to set
	 */
	public void setBankerId(int bankerId) {
		this.bankerId = bankerId;
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
	 * @return the features
	 */
	public String getFeatures() {
		return features;
	}
	/**
	 * @param features the features to set
	 */
	public void setFeatures(String features) {
		this.features = features;
	}
	/**
	 * @return the mandatoryDocs
	 */
	public String getMandatoryDocs() {
		return mandatoryDocs;
	}
	/**
	 * @param mandatoryDocs the mandatoryDocs to set
	 */
	public void setMandatoryDocs(String mandatoryDocs) {
		this.mandatoryDocs = mandatoryDocs;
	}
	/**
	 * @return the interestRate
	 */
	public int getInterestRate() {
		return interestRate;
	}
	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
	/**
	 * @return the maxLoanAmount
	 */
	public long getMaxLoanAmount() {
		return maxLoanAmount;
	}
	/**
	 * @param maxLoanAmount the maxLoanAmount to set
	 */
	public void setMaxLoanAmount(long maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}
	
}

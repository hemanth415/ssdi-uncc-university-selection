package com.dto;

/**
 * @author Hemchand
 * @author Hemanth : After Harini Review
 *
 */

public class PostLoanOffersDTO {
	private int universityId;
	private int bankerId;
	private String offerName;
	private String features;
	private String mandatoryDocs;
	private float interestRate;
	private long maxLoanAmount;
	private long minLoanAmount;
	private int maxDuration;
	private int processingFee;
	private boolean prePayments;

	/**
	 * @return the universityId
	 */
	public int getUniversityId() {
		return universityId;
	}

	/**
	 * @param universityId
	 *            the universityId to set
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
	 * @param bankerId
	 *            the bankerId to set
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
	 * @param offerName
	 *            the offerName to set
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
	 * @param features
	 *            the features to set
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
	 * @param mandatoryDocs
	 *            the mandatoryDocs to set
	 */
	public void setMandatoryDocs(String mandatoryDocs) {
		this.mandatoryDocs = mandatoryDocs;
	}

	/**
	 * @return the interestRate
	 */
	public float getInterestRate() {
		return interestRate;
	}

	/**
	 * @param interestRate
	 *            the interestRate to set
	 */
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	/**
	 * @return the maxLoanAmount
	 */
	public long getMaxLoanAmount() {
		return maxLoanAmount;
	}

	/**
	 * @param maxLoanAmount
	 *            the maxLoanAmount to set
	 */
	public void setMaxLoanAmount(long maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}

	/**
	 * @return the minLoanAmount
	 */
	public long getMinLoanAmount() {
		return minLoanAmount;
	}

	/**
	 * @param minLoanAmount the minLoanAmount to set
	 */
	public void setMinLoanAmount(long minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}

	/**
	 * @return the maxDuration
	 */
	public int getMaxDuration() {
		return maxDuration;
	}

	/**
	 * @param maxDuration the maxDuration to set
	 */
	public void setMaxDuration(int maxDuration) {
		this.maxDuration = maxDuration;
	}

	/**
	 * @return the processingFee
	 */
	public int getProcessingFee() {
		return processingFee;
	}

	/**
	 * @param processingFee the processingFee to set
	 */
	public void setProcessingFee(int processingFee) {
		this.processingFee = processingFee;
	}

	/**
	 * @return the prePayments
	 */
	public boolean isPrePayments() {
		return prePayments;
	}

	/**
	 * @param prePayments the prePayments to set
	 */
	public void setPrePayments(boolean prePayments) {
		this.prePayments = prePayments;
	}

}

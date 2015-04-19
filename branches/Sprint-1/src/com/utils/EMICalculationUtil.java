/**
 * 
 */
package com.utils;

import com.dto.LoanOffersDTO;

/**
 * @author Hemanth
 *
 */
public class EMICalculationUtil {
	
	public static void calculateInstallment(LoanOffersDTO loanOffersDTO){
		float interest = loanOffersDTO.getInterestRate()/1200; //  r% --> r/100 which is calculated every month so r/1200 
		float priciple = loanOffersDTO.getLoanAmount();
		int duration = loanOffersDTO.getDuration();
		double emi=0.0;
		double temp = Math.pow((1 + interest),duration);
		emi = (priciple * interest * temp) / (temp-1);
		loanOffersDTO.setInstallments((double) Math.round(emi * 100) / 100);
		System.out.println("EMI for the Offer Name: "+ loanOffersDTO.getOfferName() + " is " + loanOffersDTO.getInstallments());
	}
}


package com.utils;

import java.util.List;

/**
 * @author Hemanth
 *
 */
public class ValidatorUtils {
	
	public static boolean validateCountry(String country){
		return Constants.VALID_COUNTRIES.contains(country.toUpperCase());
	}
	
	public static boolean validateCountryState(String country,String state){
		List<String> states = Constants.MAP_COUNTRIES_STATES.get(country.toUpperCase());
		for(String tmpState:states){
			if(state.equalsIgnoreCase(tmpState)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean validateString(String variable){
		return (variable != null && !variable.isEmpty());
	}
	
	public static boolean validateList(List variable){
		return (variable != null && !variable.isEmpty());
	}

}
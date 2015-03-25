package com.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Constants {
	public static String SEARCH_UNIV_BY_COUNTRY_STATE = "select university_name,university_desc,address,contact_no,email_id from universities as a join location as b on a.location_id=b.location_id where country=? and state = ?";
	public static String SEARCH_UNIV_BY_NAME = "select university_name,university_desc,address,contact_no,email_id from universities where university_name = ?";
	public static ArrayList<String> VALID_COUNTRIES = new ArrayList<String>(
			Arrays.asList("US", "UNITED STATES", "AUSTRALIA", "INDIA")
			);
	public static ArrayList<String> VALID_US = new ArrayList<String>(
			Arrays.asList("NORTH CAROLINA","TEXAS","ILLINOIS")
			);
	public static ArrayList<String> VALID_AUSTRALIA = new ArrayList<String>(
			Arrays.asList("SYDNEY","MELBOURNE","BRISBANE","PERTH")
			);
	public static ArrayList<String> VALID_INDIA = new ArrayList<String>(
			Arrays.asList("ANDHRA PRADESH", "KARNATAKA", "TAMIL NADU", "NEW DELHI")
			);
	public static HashMap<String,ArrayList<String>> MAP_COUNTRIES_STATES = (HashMap<String, ArrayList<String>>) createMap();
	
	private static Map<String, ArrayList<String>> createMap() {
		HashMap<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();
        result.put("US", VALID_US);
        result.put("INDIA", VALID_INDIA);
        result.put("AUSTRALIA", VALID_AUSTRALIA);
        result.put("UNITED STATES", VALID_US);
        return result;
    }
}

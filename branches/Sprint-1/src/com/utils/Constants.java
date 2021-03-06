package com.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hemanth
 *
 */
public class Constants {
	
	public final static String SEARCH_UNIV_BY_COUNTRY_STATE = "select university_name,university_desc,address,contact_no,email_id from universities as a join location as b on a.location_id=b.location_id where university_id<>1 and UPPER(b.country)=? and UPPER(b.state) = ?";

	public final static String SEARCH_UNIV_BY_NAME = "select university_name,university_desc,address,contact_no,email_id from universities where UPPER(university_name) = ?";
	
	public static ArrayList<String> VALID_COUNTRIES = new ArrayList<String>(
			Arrays.asList("US", "UNITED STATES", "AUSTRALIA", "INDIA"));
	
	public static ArrayList<String> VALID_US = new ArrayList<String>(
			Arrays.asList("NORTH CAROLINA", "TEXAS", "ILLINOIS"));
	
	public static ArrayList<String> VALID_AUSTRALIA = new ArrayList<String>(
			Arrays.asList("SYDNEY", "MELBOURNE", "BRISBANE", "PERTH"));
	
	public static ArrayList<String> VALID_INDIA = new ArrayList<String>(
			Arrays.asList("ANDHRA PRADESH", "KARNATAKA", "TAMIL NADU",
					"NEW DELHI"));
	
	public static HashMap<String, ArrayList<String>> MAP_COUNTRIES_STATES = (HashMap<String, ArrayList<String>>) createMap();

	private static Map<String, ArrayList<String>> createMap() {
		HashMap<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();
		result.put("US", VALID_US);
		result.put("INDIA", VALID_INDIA);
		result.put("AUSTRALIA", VALID_AUSTRALIA);
		result.put("UNITED STATES", VALID_US);
		return result;
	}

	public final static String SEARCH_STUDENTS_PROFILE = "select * from students s join location l on s.location_id=l.location_id where applied_term in (";
	
	public final static String SINGLE_QUOTE = "'";
	
	public final static String COMMA = ", ";
	
	public final static String FETCH_USER_ROLE = "select user_type from login_cred where login_id=? and login_password=?";
	
	public final static String FETCH_STUDENT_DETAILS = "select * from students where email_id=?";
	
	public final static String FETCH_BANKER_DETAILS = "select * from bankers where email_id=?";
	
	public final static String INSERT_LOAN_OFFERS = "INSERT INTO loan_offers (banker_id,university_id,post_name,interest_rate,min_amount,max_amount,max_duration,post_features,mandatory_docs,prePayment,processing_percent) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	
	public final static String SEARCH_LOAN_OFFERS = "select a.banker_id,b.first_name,b.last_name,b.bank_name,b.bank_contact_no,b.bank_email_id,a.post_id,a.post_name,a.interest_rate,a.max_duration,a.post_features,a.mandatory_docs,a.prePayment from loan_offers a "
													+"join bankers b on a.banker_id = b.banker_id where university_id = ? and max_amount>=? and (min_amount<=? or min_amount=0)"
													+"and b.bank_location_id in (select location_id from location where country=?)";
	
	public final static String INSERT_TO_WISH_LIST = "INSERT INTO  wish_list (post_id, user_id) VALUES (?,?)";
	
	public final static String DELETE_FROM_WISH_LIST = "DELETE FROM  wish_list WHERE post_id=? and user_id=?";
	
	public final static String GET_STATUS_WISH_LIST = "SELECT * FROM wish_list WHERE post_id=? and user_id=?";
	
	public final static String FETCH_WISH_LIST = "SELECT * FROM wish_list WHERE user_id=?";
	
	public final static String FETCH_LOANOFFER_FOR_WISHLIST = "SELECT banker_id, interest_rate, max_amount, post_features, "
															+ "mandatory_docs "
															+ "from loan_offers where post_id=?";
	
	public final static String FETCH_BANKER_FOR_WISHLIST = "select bank_name, first_name, last_name, "
															+ "bank_contact_no, bank_email_id "
															+ "from bankers where banker_id=?";
}

package com.utils;

public class Constants {
	public static String SEARCH_UNIV_BY_COUNTRY_STATE = "select university_name,university_desc,address,contact_no,email_id from universities as a join location as b on a.location_id=b.location_id where country=? and state = ?";
	public static String SEARCH_UNIV_BY_NAME = "select university_name,university_desc,address,contact_no,email_id from universities where university_name = ?";
}

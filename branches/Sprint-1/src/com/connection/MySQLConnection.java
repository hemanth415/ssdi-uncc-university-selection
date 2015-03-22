package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Hemanth
 *
 */
public class MySQLConnection{
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/your_university_your_bank";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "admin";
	   
	   public Connection getConnection() throws Exception{
		   Connection connection = null;
		   try{
		   Class.forName("com.mysql.jdbc.Driver");
		   connection = DriverManager.getConnection(DB_URL, USER, PASS);
		   }catch(ClassNotFoundException cEx){
			   throw cEx;
		   }catch(SQLException sEx){
			   throw sEx;
		   }
		   return  connection;
	   }	   
}
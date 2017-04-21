package com.nikhilgupta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	   final static String DB_URL="jdbc:mysql://sql6.freemysqlhosting.net:3306/sql12170132";
	   final static String DB_HOST="sql12170132";
	   final static String DB_PASSWORD="jT8Q9inRAc";

	   public static Connection getConnection() throws SQLException, ClassNotFoundException {
	       Class.forName(JDBC_DRIVER);
	       Connection con=null;
	       con=DriverManager.getConnection(DB_URL,DB_HOST,DB_PASSWORD);
	       System.out.println("Connection Established");
	       return (Connection) con;
	   }
}

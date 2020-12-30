package com.barath.cnp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class ConnectionUtil {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
    	
    	final String HOST_NAME = "localhost";
    	final String SQL_PORT = "3306";
    	final String DATABASE_NAME = "mydb";
    	final String DATABASE_USERNAME = "root";
    	final String DATABASE_PASSWORD = "TryThisOne";
    	Connection conn = null;
    	
    	try{
       
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	String connectionURL = "jdbc:mysql://" + HOST_NAME + ":" + SQL_PORT + "/" + DATABASE_NAME;
        	conn = DriverManager.getConnection(connectionURL, DATABASE_USERNAME,
        		DATABASE_PASSWORD);
        	
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return conn;
        
    }    
     
    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
 
    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
        }
    }
}
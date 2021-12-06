
package com.obiokolie;

/**
 *
 * @author Obiokolie
 */


import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE MYSQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     public static Connection getConnection()throws Exception {
        /*Edit the "localhost" part with the actual IP address.  You can also use 127.0.0.1 instead of localhost.  Edit/replace the "psystem" with the name of your database*/ 
    	String url = "jdbc:mysql://localhost:3306/psystem";
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, userID, password);
    }
    
    /*Insert your other code right after this comment*/
   
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private static String serverName = "localhost";
    private static String dbName = "psystem";
    private static String portNumber = "3306";
    private static String userID = "root";
    private static String password = "";
}
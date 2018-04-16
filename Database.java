package assignment;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Database {
	
	Connection conn;
	Statement st;
	ResultSet result;
	
	//Connect to database
	
	public Database() {
		
		try {
			//Establish connect to database
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/Assignment";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			st = conn.createStatement();
			//
		}catch(Exception e) {System.out.println("Error: Failed to connect");}
		
	}
	
	public void Data() {
		

	}

	
}

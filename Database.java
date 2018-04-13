package assignment;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Database {
	
	Connection conn;
	Statement st;
	ResultSet result;
	
	//Connect to database
	
	public Database() {
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/Assignment";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			st = conn.createStatement();
			
		}catch(Exception e) {System.out.println(e);}
		
	}
	
	//take data from database
	
//	public void Data() {
//		try {
//			result = st.executeQuery("SELECT MIN(Passed) FROM nct");
//			System.out.println(result.getInt(0));
//			
//
//			
//			
//		}catch(Exception e) {}
//	}
	
}

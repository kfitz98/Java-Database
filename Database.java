package assignment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Database {
	
	//Select contents from database
	public static ArrayList<String> get() throws Exception{
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM nct");
			
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				System.out.println(result.getString("Test_Centre"));
				System.out.println(result.getString("Passed"));
				
				array.add(result.getString("Test_Centre"));
			}
			return array;
		}catch(Exception e) {System.out.println(e);}
		return null;
		
	}
	
	//Connect to database
	
	public static Connection getConnection() throws Exception{
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/Assignment";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			//System.out.println("Connected");
			return conn;
		}catch(Exception e) { System.out.println(e);}
		return null;
	}

}
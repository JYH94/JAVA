package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

	
	public static Connection getConnection() {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			Connection cn = DriverManager.getConnection(url,"root","mysql");
			
			System.out.println("** DB Connection Exception 성공 **");
			return cn;
			
		} catch (Exception e) {
			System.out.println("** DB Connection Exception => " + e.toString());
//			e.printStackTrace();
			return null;
		}
		
		
		
	}
}

package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	public static Connection getConnection() {
		
		// IO 관련오류들은 모두 예외처리가 필수다.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		     // => allowPublicKeyRetrieval=true : local DB open 하지 않아도 connection 허용
	         // => localhost ->  =동일값(ip주소) @127.0.0.1
			Connection cn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("** DB Connection 성공 **");
			return cn;
		} catch (Exception e) {
			System.out.println("** DB Connection Exception => "+ e.toString());
			return null;
		} // try
		
	} // getConnection
	
} // class

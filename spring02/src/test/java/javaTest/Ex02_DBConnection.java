package javaTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class Ex02_DBConnection {
	
	// 1) Test 조건에 어긋난다 : static , void X
	// => 따로 테스트 메서드를 만들어서 안에서 호출하는 방식으로 처리
	public static Connection getConnection() {

		// ** Error Message
		// => 드라이버 오류 : java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver1
		// => portNO 오류 : Communications link failure
		// => DBName 오류 : java.sql.SQLSyntaxErrorException: Unknown database 'mydb1'
		// => 계정,PW 오류 : java.sql.SQLException: Access denied for user
		// 'root1'@'localhost' (using password: YES)

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 리터럴값만 바뀜
			String url = "jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			// => allowPublicKeyRetrieval=true : local DB open 하지 않아도 connection 허용
			// => localhost -> 동일값(ip주소) @127.0.0.1
			// => mydb : db명 입력 -> ? 뒤부터는 파라미터
			Connection cn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("** DB Connection 성공 **");
			return cn;

		} catch (Exception e) {
			System.out.println("** DB Connection Exception => " + e.toString());
			return null;
		} // try
	} // getConnection
	
	@Test
	public void connectionTest() {
//		System.out.println("**DB_Connection =>" + getConnection());
		assertNotNull(getConnection());
		
	}
	
}

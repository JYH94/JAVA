package jdbc01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sound.midi.SysexMessage;

// ** 순서
// 1) JDBC API 속에서 필요한 객체들을 전역변수로 정의
// 2) CRUD 기능을 처리하는 메서드 정의
// 3) main에서 메서드 사용
public class DBStart {

	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	// ** StudentList 를 콘솔로 찍기
	// => Mysql Command 실행순서
	// -> Login -> DB선택 -> sql구문 실행 -> 결과 출력
	// => 위 과정을 JDBC 로 한다면 ?
	// -> Connection 객체생성 -> sql구문 : Statement 또는 PreparedStatement
	// -> 결과 : ResultSet
	public static void selectList() {

		sql = "SELECT * FROM student";
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			// ** 결과출력
			// => 결과 존재 확인
			// => ResultSet 객체는 이를 위한 메서드 제공
			// => next() : 다음에 Data가 존재하면 true, 현재Data를 제공
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("	** Student List **");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			if (rs.next()) {
				// => selectList 의 결과가 존재한다는 의미
				do {
					System.out.print(rs.getInt(1) + " ");
					System.out.print(rs.getString("name") + " ");
					System.out.print(rs.getInt(3) + " ");
					System.out.print(rs.getInt(4) + " ");
					System.out.print(rs.getString("info") + " ");
					System.out.print(rs.getDouble(6) + "\n");

				} while (rs.next());
			} else {
				// => selectList 결과가 1건도 없음을 의미한다.
				System.out.println("** selectList 결과가 1건도 없음 **");
			}

		} catch (Exception e) {
			System.out.println("** selectList Exception => " + e.toString());
		} // try

	}// selectList


	
	// ** 조별 List1
	// 단, Statement 활용 : 매개변수를 활용한 조건문 추가
	public static void joList(int jno) {

		sql = "select * from student where jno = " + jno;
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("	 조별 List => "+ jno +" 조");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			if (rs.next()) {
				// => selectList 의 결과가 존재한다는 의미
				do {
					System.out.print(rs.getInt(1) + " ");
					System.out.print(rs.getString("name") + " ");
					System.out.print(rs.getInt(3) + " ");
					System.out.print(rs.getInt(4) + " ");
					System.out.print(rs.getString("info") + " ");
					System.out.print(rs.getDouble(6) + "\n");
					System.out.println();

				} while (rs.next());
			} else {
				// => selectList 결과가 1건도 없음을 의미한다.
				System.out.println("** selectList 결과가 1건도 없음 **");
			}
		} catch (Exception e) {
			System.out.println("** selectList Exception => " + e.toString());
		}

	} // joList
	
	
	
	// ** 조별 List2
	// 단, PreparedStatement 활용해서 
		public static void joListPS(int jno) {

			sql = "select * from student where jno=?";
//			sql = "select * from student";
			try {
				//st = cn.createStatement();
				//rs = st.executeQuery(sql);
				pst = cn.prepareStatement(sql);
				pst.setInt(1, jno);
				rs = pst.executeQuery();

				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("	 조별 List => " + jno + " 조");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				if (rs.next()) {
					// => selectList 의 결과가 존재한다는 의미
					do {
						System.out.print(rs.getInt(1) + " ");
						System.out.print(rs.getString("name") + " ");
						System.out.print(rs.getInt(3) + " ");
						System.out.print(rs.getInt(4) + " ");
						System.out.print(rs.getString("info") + " ");
						System.out.print(rs.getDouble(6) + "\n");
						System.out.println();
					} while (rs.next());
				} else {
					// => selectList 결과가 1건도 없음을 의미한다.
					System.out.println("** selectList 결과가 1건도 없음 **");
				}
			} catch (Exception e) {
				System.out.println("** selectList Exception => " + e.toString());
			}

		} // joList
	
	
		
		
		
		// ** insert
		// => 입력에 필요한 컬럼을 모두 매개변수로 전달 받아야한다.
		//	  많으면 처리 불편 => 객체화 해서 해결가능
		//	  -> 엔티티(=Table) -> Java Class 로 객체화
		// 	  -> ~DTO, VO, Entity(JPA) 라고 한다.
		// => sql 구분을 완성하기 위해 문자열 연산을 작성해야 한다. 
		//    insert into student(name,age,jno,info) values('홍길동',22,9,'관리자입니다')
		//    "insert into student(name,age,jno,info) values('" + name + "'," ----
		//    중간중간 변수를 넣는과정이 매우 복잡해 지기 때문에 다른 방법을 택해야 한다.
		// => 이 점을 보완하기 위해서 제공된 객체가 PreparedStatement
		//	  변수의 위치에 ?(바인딩변수) 를 사용 할 수 있게 해준다.
		//    insert into student(name,age,jno,info) values(?,?,?,?) 
		//    ? 에 대응값은 JavaCode 로 처리 ( PreparedStatement 제공 메서드 )
		
		public static void insert(String name, int age, int jno, String info) {
			
			sql = "insert into student(name,age,jno,info) values(?,?,?,?)";
			
			try {
				pst = cn.prepareStatement(sql);
				
				pst.setString(1, name);
				pst.setInt(2, age);
				pst.setInt(3, jno);
				pst.setString(4, info);

				int cnt = pst.executeUpdate(); // insert, update, delete
				if(cnt >= 1) System.out.println("**insert 성공 =>" + cnt); 
				else System.out.println("입력성공 하지만 데이터 변함 없음");
				
				// 위에서 출력하는 메서드들과 다르게 이건 인서트 하는 메서드
				// DML 이기 때문에 executeUpdate 사용 
			} catch (Exception e) {
				System.out.println("** insert Exception => " + e.toString());
			} // try_catch
			
		}

	
	
	
	public static void main(String[] args) {
		// 1) Connection 확인
		// => toString() 은 생략가능
		// 	  즉, 출력문에서 인스턴스명을 사용하면 toString() 메서드를 호출하게 된다.
//		System.out.println("** Connection 확인 => " + cn.toString());
		System.out.println("** Connection 확인 => " + cn);

		// 2) Student List 출력
//		selectList();

		// 3) 조별 리스트 출력
//		joList(3);
		
		// 4) 조별 리스트 출력 (PreparedStatement 활용)
//		joListPS(3);
		
		// 5) Student 테이블에 insert 하기
//		insert("이순신",99,10,"거북선");
		
	} // main

} // class

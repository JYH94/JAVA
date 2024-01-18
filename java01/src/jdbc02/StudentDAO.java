package jdbc02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc01.DBConnection;

//** DAO(Data Access Object)
//=> SQL 구문 처리
//=> CRUD 구현 
// 	 Create(Insert), Read(selectList, selectOne), Update, Detete

//** DBStart 에서의 메서드들과 ~~~DAO 에서의 메서드 들의 차이
//=> DAO에서는 결과를 직접 처리하지않고, 요청자에게 제공해주는 역할을 한다.
//	 즉, 메서드 역할별로 처리결과를 return 해야 한다.
// 	 그러므로 특히 select 의 결과를 잘 전달하기 위해 결과를 객체화 해야 한다.

public class StudentDAO {
	// ** 전역변수 정의
	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	// **Join Test
	// => sno, name, age , jno, jname, project, captain ,조장이름 출력하기
	// => joDTO 작성, joinList() 메서드작성 (Controller, Service, DAO )
	
	
	
	// ** selectList

	// Arraylist 와 LinkedList 차이
	// Arraylist 는 첫 주소를 저장해서 같은타입의 데이터를 연속 나열시킨 데이터 (=배열)

	// LinkedList 는 데이터를 엮어놓고 해당데이터가 다음데이터의 주소를 갖고있다.
	// 그러므로, 다른데이터가 들어오게되면 갖고있는 다음데이터의 주소만 바꿔주면 되기 때문에
	// ArrayList에 비해 입력과 수정이 용이하다

	// 컬렉션
	// 1) List : 순서처리가 가능하도록 나열된 데이터
	// 2) Map : 순서가 없고 키와 밸류로 구성되어있다.
	// 3) Set : 순서가 없지만, 중복을 허용하지 않는다
	public List<StudentDTO> selectList() {
		sql = "select * from student";
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		// 슈퍼 변수에 후손객체를 생성하게 되면 해당 객체는 슈퍼의 메서드만을 사용하는 결과
		// 그러므로, 뒤에 ArrayList를 LinkedList로 바꾸게 된다해도 슈퍼메서드만을 사용하는건
		// 마찬가지라서 문제가 생기지 않는다는 장점을 갖는다.

		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			// => 결과의 존재여부
			// => 존재 : list 에 담기
			// => 존재X : 종료 (결과 없음을 알 수 있도록 NULL 리턴해주자)
			if (rs.next()) {
				// list에 담는 과정
				do {
					StudentDTO dto = new StudentDTO();
					dto.setSno(rs.getInt(1));
					dto.setName(rs.getString(2));
					dto.setAge(rs.getInt(3));
					dto.setJno(rs.getInt(4));
					dto.setInfo(rs.getString(5));
					dto.setPoint(rs.getDouble(6));

//					StudentDTO dto = new StudentDTO(rs.getInt(1),rs.getString(2) ~~~);
					// 이런식으로 넣는방법도 가능하다
					list.add(dto);
				} while (rs.next());

				return list;
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println("** selectList Exception => " + e.toString());
			return null;
		}

	}

	// ** selectOne
	public StudentDTO selectOne(int sno) {

		sql = "SELECT * from student where sno = ?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, sno);

			rs = pst.executeQuery();


			if (rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setSno(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setJno(rs.getInt(4));
				dto.setInfo(rs.getString(5));
				dto.setPoint(rs.getDouble(6));
				
				return dto;
			} else {
				System.out.println("구문 요류는 없지만 뽑아올 데이트 X");
				return null;
			}

		} catch (Exception e) {
			System.out.println("셀렉트원 오류발생");
			return null;
		}
	}
	
	
	// => 비교 Test
	// => 참조자료형 매개변수 ( Call By Reference )
	//	  기본자료형 매개변수 ( Call by value ) 
	public void selectOne(StudentDTO dto) {

		sql = "SELECT * from student where sno = ?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dto.getSno());
			rs = pst.executeQuery();


			if (rs.next()) {
				
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setJno(rs.getInt(4));
				dto.setInfo(rs.getString(5));
				dto.setPoint(rs.getDouble(6));
				
			} else {
				System.out.println("구문 요류는 없지만 뽑아올 데이트 X");
			}

		} catch (Exception e) {
			System.out.println("Select 오류발생 :" );
		}
	}
	
	

	// ** insert
	public int insert(StudentDTO dto) {

		sql = "INSERT INTO student values(?,?,?,?,?,?)";

		try {
			pst = cn.prepareStatement(sql);

			pst.setInt(1, dto.getSno());
			pst.setString(2, dto.getName());
			pst.setInt(3, dto.getAge());
			pst.setInt(4, dto.getJno());
			pst.setString(5, dto.getInfo());
			pst.setDouble(6, dto.getPoint());

			int cnt = pst.executeUpdate();
			if (cnt >= 1) {
				System.out.println("데이터 입력 성공");
				return cnt;
			} else {
				System.out.println("오류는 없지만, 넣을 데이터가 없음");
				return 0;
			}

		} catch (Exception e) {
			System.out.println("인서트 오류발생");
			return 0;
		}
	}

	// ** update
	public int update(StudentDTO dto) {
		
//		sql = "update student set(sno,age,jno,info,point) = (?, ?, ?, ?, ?) where name = ?";
		sql = "update student set sno = ?,age = ?, jno = ?, info = ?, point = ? where name = ?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dto.getSno());
			pst.setInt(2, dto.getAge());
			pst.setInt(3, dto.getJno());
			pst.setString(4, dto.getInfo());
			pst.setDouble(5, dto.getPoint());
			pst.setString(6, dto.getName());
			
			int cnt = pst.executeUpdate();
			
			if (cnt >= 1) {
				System.out.println("데이터 입력 성공");
				return cnt;
			} else {
				System.out.println("오류는 없지만, 넣을 데이터가 없음");
				return 0;
			}

		} catch (Exception e) {
			System.out.println("인서트 오류발생");
			return 0;
		}
	}

	// ** delete
	public int delete(int sno) {
		
		sql = "DELETE FROM student where sno = ?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, sno);

			int cnt = pst.executeUpdate();
			return cnt;
//			if (cnt >= 1)
//				System.out.println("데이터 삭제 성공");
//			else
//				System.out.println("오류는 없지만, 삭제할 데이터가 없음");

		} catch (Exception e) {
			System.out.println("딜리트 오류발생");
		}
		return 0;
	} // delete
	
	
	
	


} // class

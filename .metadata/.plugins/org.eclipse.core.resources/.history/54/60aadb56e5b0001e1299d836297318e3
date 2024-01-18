package jdbc02;

import java.util.ArrayList;
import java.util.List;

//** Controller
//=> 요청 : 요청분석 -> 담당 Service -> Service 는 DAO 
//=> 결과 : DAO -> Service -> Controller
//=> View : Controller -> View 담당 (Java:Console // Web:JSP, Html.., React) 


public class StudentController {
	
	//** 전역변수 정의
	StudentService service = new StudentService();
	
	
	//** View 의 역할 메서드 정의
	//=> selectList
	//=> 요청이 들어오면 요청에 해당하는 Service의 메서드를 호출
	//	-> 처리결과를 View에 전달해서 출력하도록 함.
	public void printList(List<StudentDTO> list) {
		System.out.println("			** Student List **");
		//=> 출력 전 자료존재여부 확인
		if(list != null) {
			//** list 출력
			for( StudentDTO s : list ) {
				System.out.println(s);
				// 여기서 s.toString() 하는게 아니라
				// toString() 메서드가 우리가 임의로 작성한 메서드가 아니라
				// Java의 메서드다
				// 문자열을 변수에 저장해서 출력문에 변수명만 적어줘서 문자열이 출력되는걸 생각해라
				// 그것도 자바에서 toString 메서드를 실행해주는거야
				// 이것도 마찬가지로 int면 int / String이면 String 변수 출력하듯이
				// 출력되는거야
			}
		} else {
			System.out.println("** selectList 결과가 1건도 없음 **");
		}
	}
	
	
	public void insert(int n) {
		if(n >= 1) {
			System.out.println("Insert 성공");
		} else {
			System.out.println("구문 오류는 없지만, 넣을 데이트 X");
		}
	}
	
	public void update(int n) {
		if(n >= 1) {
			System.out.println("Update 성공");
		} else {
			System.out.println("구문 오류는 없지만, 업데이트할 데이트 X");
		}
	}
	public void delete(int n) {
		if(n >= 1) {
			System.out.println("Delete 성공");
		} else {
			System.out.println("구문 오류는 없지만, 딜리트 할 데이트 X");
		}
	}
	
	public void printDetail (StudentDTO dto) {
		System.out.println("		 	** StudentOne List **");
		if (dto != null) {
			System.out.println(dto);
		} else {
			System.out.println("** selectOne 결과가 1건도 없음");
		}
	} // printDetail
	
	
//	public void joinList(JoDTO jto) {
//		System.out.println("		 	** join List **");
//		if (jto != null) {
//			System.out.println(dto);
//		} else {
//			System.out.println("** selectOne 결과가 1건도 없음");
//		}
//	}
//	
//	
//	
	public static void main(String[] args) {
		
		StudentController sc = new StudentController();
		// **StudentList select All
//		 sc.printList(sc.service.selectList());
		
		//===========================================
		
		// **Student select One(매개변수가 int sno 인 경우)
//		sc.printDetail(sc.service.selectOne(1));
		
		// ===========================================
		
		// **Student select One(매개변수가 StudentDTO 인 경우)
//		StudentDTO dto = new StudentDTO();
//		System.out.println(dto);
//		dto.setSno(1);
//		// StudentDTO 객체를 만들고, Sno만 지정해준 상태로 Service.selectOne2 메서드에
//		// 해당 객체를 전달 ( Service.selectOne2 메서드를 참고하자 )
//		// Sno가 15인 객체의 데이터 전체를 뽑아서 , 전달해준 객체에게 Sno를 제외한 나머지
//		// 컬럼을 Set 시켜주고 ~ 그 객체를 읽어주면 내가 원하는 데이터 결과 발생 
//		sc.service.selectOne(dto);
//		sc.printDetail(dto);
		// 원칙은 메서드명이 같을 수 없지만, 매개변수가 다른경우에는 오버로딩 되어서
		// 메서드명이 같아도 정의만 다르게 사용 가능하다.
		
		// ===========================================
		
		// **Student insert
		// 	 우리는 각 컬럼의 값을 매개변수로 전달해줘야 하는데, 그걸 받아 줄 객체가 없기 때문에
		// 	 전달하는과정에서 매개변수로 객체를 생성함과 동시에 컬럼값을 전달해줬다.
//		sc.insert(sc.service.insert(new StudentDTO(20,"이순신",22,13,"장군",500.00)));
		
		// ===========================================
		
		// **Student update
//		sc.update(sc.service.update(new StudentDTO(40,"이순신",50,20,"장장군군",400.00)));
		
		// ===========================================
		
		// ** Student delete
		//    특정 sno 를 전달해주면 그 sno를 가진 레코드를 삭제하도록 작성
//		sc.delete(sc.service.delete(20));
		
		
		
		
	} // main
} // class

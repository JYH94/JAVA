package mapperInterface;

import java.util.List;

import com.ncs.spring02.domain.MemberDTO;

import pageTest.SearchCriteria;

public interface MemberMapper {
	//** 전역변수 정의
	//@Autowired
	//MemberDAO dao;
	//MemberDAO dao = new MemberDAO();
		
	
	// ** Mybatis 적용
	// => mapper 구현객체는 스프링이 실행시에 자동으로 만들어 주입해줌.
	// => 그러므로 개발자는 interface 와 xml만 구현, Service와 연결해주면 됨.
	
	//** Mybatis 적용
	//=> CRUD 처리를 Mapper 를 이용
	//=> DAO 대신 Mapper interface ->  ~Mapper.xml

	//** Mybatis interface 방식으로 적용
	//=> MemberDAO 대신 MemberMapper 사용
	//=> MemberMapper 의 인스턴스를 스프링이 생성해주고 이를 주입받아 실행함
	// (스프링이 생성해주는 동일한 타입의 클래스는 JUnit Test 로 확인가능, 추후 실습) 
	//=> 단, 설정화일에 <mybatis-spring:scan base-package="mapperInterface"/> 반드시 추가해야함
	//   MemberDAO의 Sql구문 처리를 mapperInterface 사용으로 MemberMapper 가 역할을 대신함

	//=> SQL 구문 : xml 로작성 -> 이 화일을 Mapper 라 함 
	//=> Mapper 작성규칙
	//   -> mapperInterface 와 패키지명, 화일명이 동일해야함
	
	public List<MemberDTO> mSearchList(SearchCriteria cri);
	public int mSearchRowsCount(SearchCriteria cri);
	
	public List<MemberDTO> mPageList(SearchCriteria cri) ;
	public int mTotalRowsCount(SearchCriteria cri) ;
	
	
		public List<MemberDTO> mCheckList(SearchCriteria cri);
		public int mCheckRowsCount(SearchCriteria cri);
	
		//** selectList
		public List<MemberDTO> selectList();
		
		//** selectOne
		public MemberDTO selectOne(String id);
		
		//** insert
		public int insert(MemberDTO dto);
		
		//** update
		public int update(MemberDTO dto);
		
		//** Password_Update
		public int pwUpdate(MemberDTO dto);
		
		//** delete
		public int delete(String id);

		public List<MemberDTO> selectJoList(String jno);
		
//		** selectJoList
//		public List<MemberDTO> selectJoList(String jno);
	
	
}

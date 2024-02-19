package javaTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

// ** Book class
// => 멤버필드를 3개(author, title, price) 정의, 이들을 모두 초기화하는 생성자 만들기
// => 접근범위는 default ..?


class Book {
	
	String author;
	String title;
	int price;
	
	Book(String author,String title,int price) {
		this.author = author;
		this.title = title;
		this.price = price;
	}
	
	public boolean isBook(boolean b) {
		return b;
	}
}

// ** 테스트 레벨 4단계
// => 단위테스트 -> 통합테스트 -> 시스템테스트 -> 인수테스트

// ** 테스트 주도 개발 (Test-Driven Development , TDD)
// => JUnit 활용
// Java 개발시 가장 많이 이용되는 단위테스트 프레임
// 오픈 소스 형태로 개발되며 계속 업그레이드 되고 있음.
// JUnit4 부터 에너테이션 적용 ( Java 가 5 부터 언어적 개선이 이루어짐에 따른 변화임 )

// ** @ 종류
// => @Before - @Test - @After
// -> 하나의 클래스에서 @ 들을 반복사용하면 오류는 안나지만, 앞쪽 @이 실행됨
// => @ 적용 테스트 메서드 : non static, void 로 정의 해야 함.

// ** org.junit.Assert 가 지원하는 다양한 Test용 Method
// 1) assertEquals(a,b) : a와 b의 값(Value) 이 같은지 확인
// 2) assertSame(a,b) : 객체 a와b가 같은 객체임(같은 주소) 을 확인
// 3) assertTrue(a) : a가 참인지 확인
// 4) assertNotNull(a) : a객체가 Null 이 아님을 확인
// 5) assertArrayEquals(a,b) : 배열 a와b가 일치함을 확인

// => 자동 import 가 안되는경우
//  -> 프로젝트 우클릭 -> Build Path -> Configure Build Path.. 
//       -> Libraries -> Add Library  -> JUnit5
//  -> @Test: import org.junit.Test 확인

// => pom.xml
//  -> junit version : 4.12 로 수정
//  -> dependency 추가 ( Spring MVC Mybatis Test )
public class Ex01_BookTest {
	
	// 1) assertEquals(a,b) : a와 b의 값(Value) 이 같은지 확인
	public void equalsTest() {
		Book b1 = new Book("엄미현","죄 와 벌" , 9900);
//		assertEquals(b1.author,"톨스토이");
//		assertEquals(b1.author,"엄미현");
		// => 값의 일치성 확인 -> true: green 라인 / false: red 라인
	}
	
	// 2) assertSame(a,b) : 객체 a와b가 같은 객체임(같은 주소) 을 확인
	
	public void sameTest() {
		Book b2 = new Book("엄미현","죄 와 벌" , 9900);
		Book b3 = new Book("엄미현","죄 와 벌" , 9900);
		Book b4 = b2;
		assertSame(b2,b3); // false
//		assertSame(b2,b4); // true
	}
	
	// 3) assertTrue(a) : a가 참인지 확인
	
	
	public void trueTest() {
		Book b1 = new Book("엄미현","죄 와 벌" , 9900);
//		assertTrue(b1.isBook(false)); // false
		assertTrue(b1.isBook(true)); // true
		
	}
	
	
	// 4) assertNotNull(a) : a객체가 Null 이 아님을 확인
	
	public void nullTest() {
		//Book b1;
		// => 인스턴스를 정의만 하고 생성은 하지않음
	    //    지역변수는 초기화 하지 않으며 오류, 사용시 오류발생
		Book b1 = null;
		Book b2 = new Book("엄미현","죄 와 벌" , 9900);
//		assertTrue(b1.isBook(false)); // false
		assertNotNull(b1); // false
//		assertNotNull(b2); // true
		
	}
	// 5) assertArrayEquals(a,b) : 배열 a와b가 일치함을 확인
	@Test
	public void ArrayEquals() {
		String[] a1 = {"가","나","다" };
		String[] a2 = {"가","나","다" };
		String[] a3 = {"라","마","바" };
		String[] a4 = a1;
		String[] a5 = {"다","나","가" };
		
		
//		assertArrayEquals(a1,a2); // true
//		assertArrayEquals(a1,a3); // false
//		assertArrayEquals(a1,a4); // true
//		assertArrayEquals(a1,a5); // false
		// 1. 같은 주소를 가진경우에도 true, 배열의 내용이 같을 때도 true 인것으로 보아
		// 	  주소를 비교하는게 아닌 값을 비교한다.
		// 2. 배열 내 요소들의 값은 같지만 , 순서가 다른경우에는 false
		
	      //5.2) 두배열의 순서는 다르고, 값은 모두 동일
	      
	      //5.3) 모두 다른경우
		
		Book b1 = new Book("엄미현","111" , 9900);
		Book b2 = new Book("엄미현","222" , 9900);
		Book b3 = new Book("엄미현","333" , 9900);
		Book[] arr1 = {b1,b2,b3};
		Book[] arr5 = {b1,b2,b3};
		
		Book c1 = new Book("엄미현","444" , 9900);
		Book c2 = new Book("엄미현","555" , 9900);
		Book c3 = new Book("엄미현","666" , 9900);
		Book[] arr2 = {c1,c2,c3};
		
		Book d1 = new Book("엄미현","111" , 9900);
		Book d2 = new Book("엄미현","222" , 9900);
		Book d3 = new Book("엄미현","333" , 9900);
		Book[] arr3 = {d1,d2,d3};
		
		Book[] arr4 = arr1;
		
		
		
//		assertArrayEquals(arr1, arr2); // false
//		assertArrayEquals(arr1, arr3); // false 
//		assertArrayEquals(arr1, arr4); // true
		assertArrayEquals(arr1, arr5); // true
//		객체가 들어간 배열의 경우 같은 주소를 가진경우에만 True
	}
	
	
}	

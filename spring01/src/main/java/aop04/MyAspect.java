package aop04;

import org.aspectj.lang.JoinPoint;

//** 횡적(공통)관심사항 ( cross concerns => Aspect ) 구현
//=> Boy, Girl : 핵심 관심사항 (core concerns) 만 구현하면 됨.
//=> 횡적(공통)관심사항 과 핵심관심사항 의 연결 방법 xml, @ 방식

//** xml 방식의 공통적 관심 사항 구현 2.
//=> pointcut : 매개변수, return 값 있음
//=> 개별 advice 메서드를 구현 
//   Before, After_returning, After_throwing, After 

// ** 용어정리
// Target: 핵심사항(Core concerns) 가 구현된 객체 : Boy, Girl
// JoinPoint: 클라이언트가 호출하는 모든 비즈니스 메서드    
//          ( 공통관심사항이 적용될수있는 지점, ex:메소드 호출시, 객체생성시 등 )
// Pointcut: JoinPoint 중 실제 공통적 관심사항이 적용될 대상 : doStudying()  
// Advice : 공통관심사항(Cross-Cutting) 구현 코드 + 적용시점
//        : 시점별 메서드들 ( myBefore() .... )
//        : 적용시점 (핵심로직 실행 전, 후, 정상 종료 후, 비정상 종료 후 등 )
// Aspect : Advice + Pointcut

//** JoinPoint  
//=> 핵심적 관심사항으로 들어가는 모든 데이터 (before를 통해) 사항을
//  가지고 있으며 처리할 수 있도록 해줌

//1) 인자
//=> JoinPoint의 getArgs() 메서드
// 핵심관심사항의 인자(매개변수) 의 목록을 배열의 형태로 제공함.
// Before  메서드 에서 사용가능함.
//2) return 값 처리
//=> myAfter_returning 메서드에 매개변수로 전달되어 사용 가능.

public class MyAspect {

	// ** Before
	// 1) 핵심적 관심사항의 매개변수 처리가능
	// => 핵심적 관심사항을 실행할 필요가 없으므로 JoinPoint Type 을 사용함
	public void myBefore(JoinPoint joinpoint) {
		System.out.println("프로젝트 과제를 합니다 => Before");
		// => pointcut의 인자값 확인가능
		Object[] args = joinpoint.getArgs();
		for (Object arg : args) {
			System.out.println("myBefore의 pointcut 인자값 : " + arg);
		}
	}

	// ** After_returning : 핵심적 관심사항(기능)의 정상종료
	// => 핵심적 관심사항 정상 종료후 결과 return
	// => 이 결과를 매개변수로 전달 받으며 이에 대한 처리가 가능
	// => 전달받을 매개변수 : xml에서 mapping -> returning="result"

	// Test 1. 전달된 Return 값 사용가능함
	// Test 2. class 의 main 실행시에는 전달된 return 값 출력됨 확인
	public void myAfter_returning(Object result) {
		System.out.println("~~ 200 OK: 회원가입, 글등록이 잘 됩니다 => 핵심적 관심사항의 정상정료");
		System.out.println("* myAfter_returning의 pointcut return값 : " + result);
		result += "return Value Change";
		// => result 는 현 메서드의 지역변수 이므로 pointcut 의 return에는 영향을 미치지 않는다.
	}

	// ** After_throwing : 핵심적 관심사항(기능)의 비정상종료
	// => 핵심적 관심사항 실행도중 예외발생시 예외메시지 return
	// => 매개변수로 예외 메시지 전달받으면 이에 대한 처리 가능
	// => 전달받을 매개변수 : xml에서 mapping -> throwing="e"
	public void myAfter_throwing(Exception e) {
		// ** 핵심적 관심사항의 비정상종료 : After_throwing
		// => 발생된 예외를 Throwable로 처리(처리&종료) 했으므로 main까지 전달되지않음 (확인후 Test)
		// => main으로 전달하려면 예외발생시켜주면됨.
		// throw new Exception(e) ; // Exception 은 Checked -> try~catch 처리 해야함
		System.out.println("** 밤새워 수정 합니다 zz => 핵심적 관심사항의 비정상종료");
		System.out.println("* myAfter_throwing이 전달받은 Exception Message => "+ e.toString());
	}

	// ** After : 정상/비정상 관계없이 무조건 실행
	public void myAfter() {
		System.out.println("** finally : 무조건 제출합니다 ~~ => After");
	}

//	public void myAround( ProceedingJoinPoint joinPoint ) {
//		
//		System.out.println("프로젝트 과제를 합니다 => Before");
//		try {
//	        // ** 핵심기능 수행 (pointcut 전달)
//	        // => Around 메서드의 매개변수(ProceedingJoinPoint Type) 를 통해 전달받아 수행
//			joinPoint.proceed();
//	        // => Throwable 로 예외처리를 해야함
//	        //    Throwable - Exception - RuntimeException (UnChecked), IOException (Checked)
//	        //              - Error
//			
//			// ** 핵심적 관심사항의 정상종료 : After_ruturning
//			System.out.println("~~ 200 OK: 회원가입, 글등록이 잘 됩니다 => 핵심적 관심사항의 정상정료");
//			
//		} catch (Throwable e) {
//	        // ** 핵심적 관심사항의 비정상종료 : After_throwing
//	        // => 발생된 예외를 Throwable로 처리(처리&종료) 했으므로 main까지 전달되지않음 (확인후 Test)
//	        // => main으로 전달하려면 예외발생시켜주면됨.
//	        // throw new Exception(e) ;  // Exception 은 Checked -> try~catch 처리 해야함
//			System.out.println("** 밤새워 수정 합니다 zz => 핵심적 관심사항의 비정상종료");
//			throw new RuntimeException(e); // Unchecked
//		}finally {
//			System.out.println("** finally : 무조건 제출합니다 ~~ => After");
//		}
//				
//	}

}

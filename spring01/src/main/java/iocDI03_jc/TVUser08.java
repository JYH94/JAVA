package iocDI03_jc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

//** Java Bean Configuration class를 이용한 DI
//=> Bean 컨테이너 : AnnotationConfigApplicationContext 사용
//                매개변수로 Java_config_class 를 사용 (JavaConfig01.class)           
//=> Test01 : 스피커 없는 TV

interface TV {
	void powerOn();

	void powerOff();

	void volumeUp();

	void volumeDown();
}

class SsTVi implements TV {

	public SsTVi() {
		System.out.println("~~ SsTvi 기본생성자 ~~ ");
	}

	public void powerOff() {
		System.out.println("~~ SsTVi powerOff ~~");
	}

	public void powerOn() {
		System.out.println("~~ SsTVi powerOn ~~");
	}

	public void volumeDown() {
		System.out.println("~~ SsTVi volumeDown ~~");
	}

	public void volumeUp() {
		System.out.println("~~ SsTVi volumeUp ~~");
	}
}

class LgTVi implements TV {

	public LgTVi() {
		System.out.println("~~ LgTvi 기본생성자 ~~ ");
	}

	public void powerOff() {
		System.out.println("~~ LgTVi powerOff ~~");
	}

	public void powerOn() {
		System.out.println("~~ LgTVi powerOn ~~");
	}

	public void volumeDown() {
		System.out.println("~~ LgTVi volumeDown ~~");
	}

	public void volumeUp() {
		System.out.println("~~ LgTVi volumeUp ~~");
	}
}

public class TVUser08 {

	public static void main(String[] args) {

		// 1. BeanFactory(스프링 컨테이너) 생성
		// => AnnotationConfigApplicationContext 사용
		// 매개변수로 Java_Config_class 를 사용 (JavaConfig01.class)
		// -> 주의사항 : "" 없이 화일명 적용, 같은 package에 있으므로 package명 생략
		// -> 참고 : 스프링 프로젝트의 .class 화일 위치
		// C:\MTest\myWork\spring01\target\classes\iocDI03_jc

		
		AbstractApplicationContext sc = new 
				AnnotationConfigApplicationContext(JavaConfig01.class);
		// => 설정화일(xml구문_요구사항 목록) 을 매개변수로 전달
		// => GenericXmlApplicationContext("app02.xml");
		// xml 문을 "src/main/resources" 에 두면 패키지는 생략가능

		// 2. 필요한 객체를 전달받고 서비스 실행
		// => 어노테이션 없다면 : NoSuchBeanDefinitionException 발생
		// => 어노테이션 중복시 : ConflictingBeanDefinitionException 발생
		// => 어노테이션(컴포넌트)를 지정해주면 객체 생성 자체는 무조건 되고,
		// 그 후에 해당하는 어노테이션 id를 찾게된다.
		// 매칭되는 id가 없다해도 생성자체는 되는 모습을 볼 수 있다.
		TV tv = (TV) sc.getBean("tv");
		if (tv != null) {
			tv.powerOn();
			tv.volumeDown();
			tv.volumeUp();
			tv.powerOff();
		} else
			System.out.println("** TV를 선택하지 않았습니다. **");
		System.out.println();
		System.out.println("** Program 정상 종료 **");

		sc.close();
	} // main

} // class

package iocDI01_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


//** 스프링이 제공하는 BeanFactory
//=> 스프링 컨테이너
//=> AbstractApplicationContext 와 GenericXmlApplicationContext 계층도 
//=> Object -> DefaultResourceLoader (C) -> AbstractApplicationContext (A) 
//       -> GenericApplicationContext (C) -> GenericXmlApplicationContext (C) 

//public abstract class AbstractApplicationContext extends DefaultResourceLoader
//    implements ConfigurableApplicationContext, DisposableBean {....

//public class GenericXmlApplicationContext extends GenericApplicationContext {...

//=> 컨테이너는 xml (설정화일), @, JavaCode (JavaConfig) 등의 
//   전달사항을 통해 요구하는 클래스를 생성, 보관, 제공

//** xml (설정화일)


public class TVUser02 {

	public static void main(String[] args) {
		// 1. BeanFactory(스프링 컨테이너) 생성
		AbstractApplicationContext sc = new
				GenericXmlApplicationContext("iocDI01_xml/app02.xml");
	    // => 설정화일(xml구문_요구사항 목록) 을 매개변수로 전달
	    // => GenericXmlApplicationContext("app02.xml");
	    //    xml 문을 "src/main/resources"  에 두면 패키지는 생략가능 
		
		
		// 2. 필요한 객체를 전달받고 서비스 실행
		TV tv = (TV)sc.getBean("tv");
		if ( tv != null ) {
			tv.powerOn();
			tv.volumeDown();
			tv.volumeUp();
			tv.powerOff();
		} else System.out.println("** TV를 선택하지 않았습니다. **");
		System.out.println();
		
		
	    // 3. singleton(싱글톤) Test
	    // => 스프링 프레임웤의 모든 작업은 싱글톤을 기본으로함.
	    // => 싱글톤 (한개의 인스턴스만 허용 하는것) 적용 Test
	    // => 설정화일의 scope 속성 에 "prototype"_ss / "singleton"_lg (default 는 싱글톤)
	    // => 생성자 실행횟수와 아래의 주소값 확인해보기
	    //    SsTVi 2개, LgTVi(prototype) 2개 씩 인스턴스 작성 후 확인   
		// app02.xml 에서 scope 속성을 통해 Lgtv(tv) 에는 프로토 타입지정
		// app02.xml 에서 scope 속성을 통해 Sstv(tvs) 에는 싱글톤 타입지정(디폴트값)
		TV tv1 = (TV)sc.getBean("tv");
		TV tv2 = (TV)sc.getBean("tv");
		// 객체 생성을 사용자가 직접하지 않고, BeanFactory를 통해 생성하는 모습
		// getBean 메서드에 app02.xml <bean>에서 지정해준 id를 전달해줘서 객체생성
		System.out.println("** singleton(싱글톤) Test **");
		System.out.println("** tv_Prototype => " + tv);
		System.out.println("** tv1_Prototype => " + tv1);
		System.out.println("** tv2_Prototype => " + tv2);
		System.out.println();
		// 주소가 다른 결과 발생 : 다른 객체를 생성한다는걸 알 수 있다.
		
		TV tvs1 = (TV)sc.getBean("tvs");
		TV tvs2 = (TV)sc.getBean("tvs");
		System.out.println("** tvs1_Singleton => " + tvs1);
		System.out.println("** tvs2_Singleton => " + tvs2);
		// 주소가 같은 결과 발생
		
		
		sc.close();
		
	} //main

} //class

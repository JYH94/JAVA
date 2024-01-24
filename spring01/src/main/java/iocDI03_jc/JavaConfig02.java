package iocDI03_jc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//** Java Bean Configuration class를 이용한 DI
//=> Test02 : 스피커 1개 사용 TV 
// -> 생성자를 이용한 주입,
// -> JC에서 xml 병행사용

//** JC 에서 xml 병행 사용하기 
//=> @ImportResource("iocDI03_jc/app09.xml")
//=> AiTVs 생성은 xml 로 


@ImportResource("iocDI03_jc/app09.xml") // xml 파일 사용하기위해
@Configuration
public class JavaConfig02 {
	//1) 고전적 방법 (직접 new : 소스 재컴파일)
	@Bean
	// => Spring 컨테이너에 의해 해당메서드가 실행되어 생성된 인스턴스를
	//	  컨테이너로 return 된다.
	public TV sstv() { return new SsTVs(); }
	   
	//2) IOC/DI: 생성자 주입
	@Bean
	public TV lgtv() { 
//		return new LgTVs( new Speaker() ,"blue" ,9988000 ); 
		return new LgTVs( sp() ,"blue" ,9988000 ); 
	}
	
	// 얘는 TVUser09 에서 직접적으로 호출해서 사용하는게 아니라
	// 클래스 내에서 사용하기 대문에 @Bean 이 필요없다
	
	// aitv 에 @Autowired 테스트해보기 위해
	// Speaker 객체를 생성해줬다.
	public Speaker sp() {
		return new Speaker();
	}
	
	// 3) IOC/DI: JC 에서 xml 병행 사용
	// => jc 에서 생성 후 Speaker 는 @Autowired 해보자
	// 기존 결과 : aitv에 @Autowired 를 통해 자동주입해보려고 했지만,
	// 			스피커 객체가 없어서 오류발생
	// 수정 결과 : 위쪽 Speaker sp() 에 @Bean 을 붙여 해결!
	@Bean
	public TV aitv() { return new AiTVs(); }
	
	
	// 얘는 xml로 생성할거야
	
	
}

package controllerF;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//** 서비스 컨트롤러들의 메서드명의 일관성(강제성)을 위해 작성
//=> 모든 서비스 컨트롤러들은 반드시 구현해야함.

public interface Ex04_Controller {
	
	public String doUser(HttpServletRequest request, HttpServletResponse response);
	// 여기서 아무것도 행동이 정의되어 있지 않은 이유는 인터페이스 이기 때문이다.
	// 구체화된 행동들은 하위 클래스에 정의 되어 있다.
	// ex) mlist, mdetail 등
	
} //Controller

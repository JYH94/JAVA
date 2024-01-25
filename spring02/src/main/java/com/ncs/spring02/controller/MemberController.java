package com.ncs.spring02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.ApplicationScope;

import com.ncs.spring02.domain.MemberDTO;
import com.ncs.spring02.service.MemberService;


//** IOC/DI 적용 ( @Component 의 세분화 ) 
// => 스프링 프레임워크에서는 클래스들을 기능별로 분류하기위해 @ 을 추가함.
// =>  @Controller
//	->사용자 요청을 제어하는 Controller 클래스
//	->DispatcherServlet이 해당 객체를 Controller객체로 인식하게 해줌.
//	   = interface Controller 의 구현할 필요가 없어진다.
//	     이로인해, handleRequest() Override 의무도 없어진다
//    = 메서드명, 매개변수, return타입 에 자유로워 진다.(ModelAndView or String or void)
//	-> 클래스와 메서드 단위 매핑이 가능한 @RequestMapping 가능해진다.
//	-> 그러므로, 하나의 컨트롤러 클래스에 여러개의 매핑메서드의 구현이 가능해진다.
//	-> 그래서 주로 테이블(엔티티)단위로 작성 (MemberController.java 에 구현예정)


//=>  @Service : 비즈니스로직을 담당하는 Service 클래스
//=>  @Repository : DB 연동을 담당하는 DAO 클래스
//      DB 연동과정에서 발생하는 예외를 변환 해주는 기능 추가


@Controller
@RequestMapping(value="/member")
// 요청이 들어오면 요청사항 중 /member이 포함된 애들은 MemberController로
// 들어오고 ~ 그 뒤의 요청은 밑에 메서드로 판단하자
// ex) login 의 경우 member/loginForm으로 가라는 요청을 
//	   Home.jsp에서 받았다.
//     1차적으로 /member 요청이 컨트롤러로 오고
//	   2차로 /loginForm 을 찾게된다.
public class MemberController {

	
	
	@Autowired(required = false)
	MemberService service;

	
// ** Login Form 출력 
//	=> Version 01 : return String
//	public String loginForm(Model model) { // 
//		return "member/loginForm";
//	} //mList
	
//	=> Version 02 : return void
//	=> viewName이 생략 : 요청명이랑 똑같은 viewName을 찾아준다.
//		/WEB-INF/views/member/loginForm.jsp 완성됨(servlet-context.xml 확인)
	@RequestMapping( value = {"/loginForm"}, method = RequestMethod.GET )
	public void loginForm() { } //loginForm
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpSession session, Model model, MemberDTO dto) {
		// => 매핑메서드의 인자객체와 동일한 컬럼명의 값은 자동으로 dto에 할당 -> 		
		// String id = request.getParameter("id");
		// String password = request.getParameter("password");
		// dto.setId(id);
		// dto.setPassword(password);
		// 우리가 그 동안 해왔던 위 코드들을 스프링은 자동으로 dto에 넣어준다.
		
	    // 1. 요청분석
	    // => requst 로 전달되는 id, password 처리: 
	    //    매서드 매개변수로 MemberDTO 를 정의해주면 자동 처리
	    //   ( Parameter name 과 일치하는 setter 를 찾아 값을 할당해줌 )
	    // => 전달된 password 보관
	    String password = dto.getPassword();
	    // 우리가 입력한 값이 dto에 자동저장 -> dto에서 패스워드를 가져오면 = 우리가 입력한값
	    String uri = "redirect:/home"; // 성공시 uri
	    //String uri = "redirect:/"; 
	    // 처음에 servlet-context.xml 에서 / , /home를 정의해서 두개 다 가능하다
	    
	    // 2. 서비스 & 결과 처리
	    // => id 확인 
	    // => 존재하면 Password 확인
	    // => 성공: id, name은 session에 보관, home 으로
	    // => 실패: 재로그인 유도
	    dto = service.selectOne(dto.getId());
	    if ( dto != null && dto.getPassword().equals(password) ) {
	    	// 성공
	    	session.setAttribute("loginId", dto.getId());
	    	session.setAttribute("loginName", dto.getName());
	    } else {
	    	// 실패
	    	uri = "member/loginForm";
	    	model.addAttribute("message", "~~ id 또는 password 오류 !! 다시하세요 ~");
	    }
		
		return uri;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, Model model) {
		
		session.invalidate();
		model.addAttribute("message", "~~ 로그아웃 성공 ~~");
		return "redirect:/home";
	}
	
	@RequestMapping( value = {"/joinForm"}, method = RequestMethod.GET )
	public void joinForm() { } //loginForm
	
	@RequestMapping( value = {"/join"}, method = RequestMethod.POST )
	public String join(Model model, MemberDTO dto) { 
		// 1. 요청분석
		// => Spring 전 : 한글처리 , request 값 -> dto 에 set
		// => Spring 후 : 한글은 filter 처리, request 처리는 매개변수로 자동화
		
		String uri = "member/loginForm"; // 성공시
		
		if(service.insert(dto) > 0) {
			model.addAttribute("jmessage", "가입성공 ! 로그인 후 이용하세요");
		} else {
			uri = "member/joinForm";
			model.addAttribute("message", "가입실패 !");
		}
		
		return uri;
		
		// 2. 서비스 & 결과 처리
	} //join
	
	// ** Member List
	@RequestMapping( value = {"/memberList"}, method = RequestMethod.GET )
	public void mlist(Model model) { 
		model.addAttribute("banana", service.selectList());
	} //mList
	
	// ** Member Detail
	// => 단일 Parameter 의 경우 @RequestParam("...") 활용
	//	  String jCode = request.getParameter("jCode") 과 동일
	//	  하지만, detail 요청에 파라미터를 줘서 구분하는 과정에서 
	//    내정보창은 요청명 /detail , 정보수정창은 요청명 /detail?jCode=U 인 상황이라면
	//    내 정보창은 요청명에 파라미터가 없기 때문에 400(Bad request) 오류가 난다.
	//    해결 하기 위해서는 요청에 파라미터(빈값이라도)를 추가해야 한다. /detail?jCode=
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(HttpSession session, Model model, @RequestParam("jCode") String jCode) {
		
	    // 1. 요청분석
	    // => id: session 에서 꺼내오기
	    // => detail 또는 수정 Page 출력을 위한 요청인지 jCode 로 구별 
		String id = (String)session.getAttribute("loginId");
		String uri = "member/memberDetail"; // detail 기준
		
//		if("U".equals(request.getParameter("jCode"))) {
//			uri = "member/updateForm";
//		}
		if("U".equals(jCode)) {
			uri = "member/updateForm";
		}
		
		// 2. 서비스 & 결과 처리
		model.addAttribute("apple" ,service.selectOne(id));
		return uri;
	} //Detail
	
	@RequestMapping(value = "/update")
	public String update(HttpSession session ,MemberDTO dto , Model model) {
		
		// 1. 요청분석
		// => 성공 : memberDetail , 실패 : updateForm
		// => 두 경우 모두 dto 가 필요하다
		String uri = "member/memberDetail";
		
		model.addAttribute("apple",dto);
		// 이 과정이 필요없다고 생각 할 수 있는데
		// 정보수정에 실패 했을 때, 실패 메세지 출력과 동시에
		// 내가 가진 정보가 없어서
		// 출력할 정보가 없다고 뜨는 상황이 발생하는걸 막기 위함이다
		
		if(service.update(dto) > 0) {
			model.addAttribute("message","정보수정 성공 !!");
			// => name 을 수정할수도 있으므로 loginName 도 수정
			session.setAttribute("loginName",dto.getName());
			
		} else {
			uri = "member/updateForm";
			model.addAttribute("message","정보수정 실패 !!");
		}
		return uri;
	}
	
	
	//** Delete
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete( HttpSession session, Model model) {
		
	    // 1. 요청분석
	    // => id: session 에서 꺼내오기
		// => 삭제 + session 처리도 해줘야 한다(invalidate)
		// => 성공시 홈으로
		String id = (String)session.getAttribute("loginId");
		String uri = "redirect:/home"; 
		
		// 2. 서비스 & 결과 처리
		if(service.delete(id) > 0 ) {
			session.invalidate();
			// 메세지 출력하고 싶지만 redirect 하면
			// 모델 날라가고, 세션도 만료시키니까 어디다가 넣어야 할까?
		} else {
			// 마찬가지
		}
		
		return uri;
	} //Detail
	
	
	
	

} // class

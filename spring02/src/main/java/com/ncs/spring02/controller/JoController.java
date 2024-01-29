package com.ncs.spring02.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncs.spring02.domain.JoDTO;
import com.ncs.spring02.service.JoService;
import com.ncs.spring02.service.MemberService;

import lombok.AllArgsConstructor;
@Controller 
@RequestMapping(value = "/jo")
@AllArgsConstructor
// => 모든 멤버변수를 초기화하는 생성자 자동 추가 & 사용
//	  그러므로 @Autowired 는 생략가능
public class JoController {
	
//	@Autowired(required = false)
	JoService service;
//	@Autowired(required = false)
	MemberService mService;
	
	@RequestMapping( value = {"/joInsert"}, method = RequestMethod.GET )
	public void joinForm() { } //loginForm
	
	
	@RequestMapping( value = {"/joList"}, method = RequestMethod.GET )
	public void jolist(Model model) { 
		model.addAttribute("banana", service.selectList());
	} //mList
	
	@RequestMapping( value = {"/joUpdate"}, method = RequestMethod.GET )
	public void joUpdate(Model model, @RequestParam("jno")String jno) { 
		model.addAttribute("apple", service.selectOne(Integer.parseInt(jno)));
	} //mList
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(HttpSession session, Model model, 
							@RequestParam("jno") int jno) {
		// @RequestParam 들어온 요청이 detail?jno= ~ 이기 때문에
		// 해당 요청의 파라미터를 매개변수로 받아올수있게 해주는 기능
		
	    // 1. 요청분석
	    // => id: session 에서 꺼내오기
	    // => detail 또는 수정 Page 출력을 위한 요청인지 jCode 로 구별 
		String uri = "jo/joDetail"; // detail 기준
		
//		if("U".equals(request.getParameter("jno"))) {
//			uri = "member/updateForm";
//		}
		// @RequestParam 을 이용하면 위 주석과 같은 조건을 걸어줄 필요가 없어진다.
		
		// 2. 서비스 & 결과 처리
		model.addAttribute("apple" ,service.selectOne(jno));
		model.addAttribute("test2" ,mService.selectList(jno));
		// 오버로딩의 방법
		
		model.addAttribute("test", mService.selectJoList(jno));
		return uri;
	} //Detail
	
	@RequestMapping(value = "/joUpdate" ,method = RequestMethod.POST)
	public String update(JoDTO dto , Model model) {
		
		String uri = "jo/joList";
		model.addAttribute("apple",dto);
		
		if(service.update(dto) > 0) {
			model.addAttribute("banana", service.selectList());
			model.addAttribute("message","조 정보수정 성공 !!");
		} else {
			uri = "jo/joUpdateForm";
			model.addAttribute("message","조 정보수정 오류 !! 다시하세요~");
		}
		return uri;
	}
	
	//** Delete
	@RequestMapping(value = "/joDelete", method = RequestMethod.GET)
	public String delete( HttpSession session, Model model, RedirectAttributes rttr, 
							@RequestParam("jno") int jno) {
		
	    // 1. 요청분석
	    // => id: session 에서 꺼내오기
		// => 삭제 + session 처리도 해줘야 한다(invalidate)
		// => 성공시 홈으로
		String uri = "redirect:/home"; 
		
		// 2. 서비스 & 결과 처리
		if(service.delete(jno) > 0 ) {
			// 메세지 출력하고 싶지만 redirect 하면
			// 모델 날라가고.. session에 저장시킨다면 사용 후에 해당 메세지를
			// 삭제시키지 않으면 해당페이지에서 계속 출력되기 때문에 문제가 된다.
			// = session에 저장 -> redirct 되어진 요청 처리시에
			//	 request에 옮기고, session 속 메세지를 삭제해야한다.
			// 위 번거로운 과정을 한번에 처리해주는 API = RedirectAttributes
			rttr.addFlashAttribute("dMessage", "조 삭제 성공 ~");
			session.invalidate();
		} else {
			rttr.addFlashAttribute("dMessage", "조 삭제 실패 ~");
			// 마찬가지
		}
		
		return uri;
	} //Detail
	
	@RequestMapping(value = "/joInsert", method = RequestMethod.POST)
	public String insert(Model model, JoDTO dto ) { 
		// 1. 요청분석
		// => Spring 전 : 한글처리 , request 값 -> dto 에 set
		// => Spring 후 : 한글은 filter 처리, request 처리는 매개변수로 자동화
		
		String uri = "jo/joList"; // 성공시
		
		if(service.insert(dto) > 0) {
			model.addAttribute("banana", service.selectList());
			model.addAttribute("jmessage", "조 추가 성공 !");
		} else {
			uri = "jo/joInsert";
			model.addAttribute("jmessage", "조 추가 실패 !");
		}
		
		return uri;
		
		// 2. 서비스 & 결과 처리
	} //join
}

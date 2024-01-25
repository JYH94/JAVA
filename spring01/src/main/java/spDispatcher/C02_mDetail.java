package spDispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import service.MemberService;

public class C02_mDetail implements Controller{

	@Autowired
	MemberService service;
	// IOC/DI 적용, 자동주입 -> 어딘가에서 이미 생성되어 있어야 한다(@ or xml or jc)
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();

		mv.addObject("apple", service.selectOne("juh94") );
		mv.setViewName("member/memberDetail");
		return mv;
	}

}
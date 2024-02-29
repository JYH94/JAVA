package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Jo;
import com.example.demo.service.JoService;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = "/jo")
// 모든 맴버변수를 초기화하는 생성자를 자동추가, 사용
// 그러므로 @Autowired는 생략 가능
@AllArgsConstructor
public class JoController {
	
	JoService service;
	MemberService serviceM;

	// joList
	@GetMapping("/joList")
	public void jList(Model model) {
		model.addAttribute("apple", service.selectJoList());
	} // joList

	// joDetail
	@GetMapping("/joDetail")
	public String jDetail(Model model, @RequestParam("jCode") String jCode,
							Jo entity) {
		String uri = "/jo/joDetail";
		model.addAttribute("apple", service.selectJoDetail(entity.getJno()));

		if ("U".equals(jCode)) {
			uri = "jo/joUpdate";
		}

		if ("D".equals(jCode)) {
			model.addAttribute("banana", serviceM.findByJno( entity.getJno()));
		}
		return uri;
	} // joDetail

	// insertForm
	@GetMapping("/joInsert")
	public void joinForm() {
	} // insertForm

	// JoInsert
	@GetMapping("/insert")
	public String join(Model model, Jo entity, RedirectAttributes rttr) {
		// 1 요청 분석
		// 이전 : 한글처리, request 값 -> dto에 set
		// 스프링 : 한글은 filter, request 처리는 parameter
		String uri = "redirect:joList";

		// 2 Service
		try {
			service.save(entity);
			model.addAttribute("banana", service.selectJoList());
			rttr.addFlashAttribute("message", " 조 추가 성공 ");
		} catch (Exception e) {
			uri = "jo/joInsert";
			rttr.addFlashAttribute("message", " 조 추가 실패 ");
		}

		return uri;
	} // JoInsert

	@GetMapping("/update")
	public String update(Model model, Jo entity) {

		String uri = "jo/joDetail";

		// 2 Service
		try {
			model.addAttribute("apple", service.save(entity));
			model.addAttribute("message", " 조 정보수정 성공 ");
		} catch (Exception e) {
			uri = "jo/joUpdate";
			model.addAttribute("message", " 조 정보수정 실패 ");
		}
		return uri;
	}

	// joUpdate
	@GetMapping("/joUpdate")
	public void updatePage(Model model, Jo entity) {
		// 1 요청 분석entity
		// 성공 : memberDetail
		// 실패 : updateForm
		// 출력하려면 dto 객체의 값("apple")이 필요하므로 보관
		model.addAttribute("apple", service.selectJoDetail(entity.getJno()));
	} // joUpdate

	// joDelete
	@GetMapping("/joDelete")
	public String datail(@RequestParam("jno") int jno, Model model, RedirectAttributes rttr) {
		String uri = "redirect:joList";

		// 2 Service 처리
		try {
			service.delete(jno);
			model.addAttribute("banana", service.selectJoList());
			rttr.addFlashAttribute("message", " 삭제 성공 ");
		} catch (Exception e) {
			rttr.addFlashAttribute("message", " 삭제 실패 ");
		}
		return uri;
	} // joDelete

} // class
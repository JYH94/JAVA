package com.example.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.GuestbookDTO;
import com.example.demo.domain.PageRequestDTO;
import com.example.demo.domain.PageResultDTO;
import com.example.demo.entity.Guestbook;
import com.example.demo.entity.Testkey;
import com.example.demo.entity.TestkeyId;
import com.example.demo.service.GuestbookService;
import com.example.demo.service.TestkeyService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {

	GuestbookService service;
	TestkeyService tservice;

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ** JPA 복합키 실습 (@IdClass 방법)
	@GetMapping("/tinsert")
	public String tinsert() {
		Testkey entity = Testkey.builder().id("green").no(1).name("김그린").count(1) // JPA save 에서는 MySql에서 정의한 default 1
																					// 적용안됨.
				.build();
		try {
			tservice.save(entity);
			System.out.println("** Testkey SAVE => " + entity);
		} catch (Exception e) {
			System.out.println("** SAVE Exception => " + e.toString());
		}
		return "redirect:home";
	}

	// => Update
	@GetMapping("/tupdate")
	public String tupdate() {
		// => Test Data 작성
		String id = "green";
		int no = 1;
		int count = 10;
		try {
			tservice.updateCount(id, no, count);
			System.out.println("** Testkey Update count값 누적=> " + id + no + ", " + count);
		} catch (Exception e) {
			System.out.println("** UPDATE Exception => " + e.toString());
		}
		return "redirect:home";
	}

	// => DUPLICATE KEY UPDATE (장바구니 응용)
	// 없으면 Save 있으면 Update
	@GetMapping("/tdupupdate")
	public String tdupupdate() {
		// => Test Data 작성
		String id = "banana";
		int no = 2;
		String name = "바나나";
		int count = 1;
		try {
			tservice.dupUpdateCount(id, no, name, count);
			System.out.println("** Testkey Update count값 누적=> " + id + no + ", " + count);
		} catch (Exception e) {
			System.out.println("** DupUpdate Exception => " + e.toString());
		}
		return "redirect:home";
	}

	// ** default 메서드 활용 update
	@GetMapping("/tcalcCount")
	public String tcalcCount() {
		// => Test Data 작성
		String id = "green";
		int no = 1;
		int count = 10;
		try {
			tservice.calcCount(id, no, count);
			System.out.println("** calcCount count+no+100 => " + id + no + ", " + count);
		} catch (Exception e) {
			System.out.println("** calcCount Exception => " + e.toString());
		}
		return "redirect:home";
	}

	@GetMapping("/testlist")
	public String testlist() {

		List<Testkey> list = tservice.selectList();
		for (Testkey t : list) {
			System.out.println(t);
		}
		return "redirect:home";
	}

	@GetMapping("/tdetail")
	// => 퀴리스트링으로 Test : /tdetail?id=apple&no=1
	public String tdetail(TestkeyId testid) {
		System.out.println("tdetail => " + tservice.selectOne(testid));
		return "redirect:home";
	}

	@GetMapping("/tdelete")
	// => 퀴리스트링으로 Test : /tdelete?id=green&no=1
	public String tdelete(TestkeyId testid) {
		try {
			tservice.delete(testid);
			System.out.println("** tdelete 삭제성공 **");
		} catch (Exception e) {
			System.out.println("** tdelete Exception => " + e.toString());
		}
		return "redirect:home";
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// @GetMapping(value={"/", "/home"})
	// => void : 요청명.jsp 를 viewName 으로 처리함 (home.jsp)
	// 그러므로 "/" 요청은 .jsp 를 viewName 으로 찾게됨(주의)
	// => Boot 의 매핑메서드 에서 "/" 요청은 적용안됨(무시됨)
	// WebMvcConfig 의 addViewControllers 메서드로 해결
	@GetMapping("/home")
	public void home(Locale locale, Model model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
	} // home

	@GetMapping("/axtestform")
	public String axTestForm() {
		return "axTest/axTestForm";
	}

	@GetMapping(value = "/ginsert")
	public String gInsert() {
		GuestbookDTO dto = GuestbookDTO.builder().title("JPA Insert Test").content("~~ 입력이 술술 잘 됩니다 ~~").writer("test")
				.build();

		System.out.println("** guest Insert => " + service.register(dto));
		return "redirect:home";
	}

	@GetMapping("/glist")
	public String gList() {
		List<Guestbook> list = service.selectList();

		for (Guestbook g : list) {
			System.out.print(g);
			System.out.println("regdate => " + g.getRegDate() + " / modDate => " + g.getModDate());
		}

		return "redirect:home";
	}

	@GetMapping("/gdetail")
	// => 쿼리 스트링으로 Test : /gdetail?gno=2
	public String gDetail(Long gno) {
		System.out.println("**gDetail => " + service.selectOne(gno));

		return "redirect:home";
	}

	@GetMapping("/gupdate")
	public String gUpdate() {
		GuestbookDTO dto = GuestbookDTO.builder().gno(5L).title("JPA Update Test").content(" ~~ 수정이 술술 잘 됩니다 ~~")
				.writer("juh94").build();

		System.out.println("** guest Update => " + service.register(dto));

		return "redirect:home";
	}

	@GetMapping("/gdelete")
	// => 쿼리 스트링으로 Test : /gdelete?gno=6
	public String gDelete(Long gno) {
		try {
			service.delete(gno);
			System.out.println("** gDelete 성공  => " + gno);
		} catch (Exception e) {
			System.out.println("** gDelete Exception => " + e.toString());
			// => 자료가 없으면 org.springframework.dao.EmptyResultDataAccessException 발생확인
		}

		return "redirect:home";
	}

	// ** JPA Pageing & Sort
	@GetMapping("/gpage")
	public String gpage() {
		PageRequestDTO requestDTO = PageRequestDTO.builder().page(2).size(5).build();
		// => 출력할 pageNo , Page 당 출력할 row 갯수

		PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.pageList(requestDTO);
		System.out.println("** Page List => " + requestDTO.getPage());

		for (GuestbookDTO g : resultDTO.getDtoList()) {
			System.out.println(g);
		}
		return "redirect:home";
	}
}

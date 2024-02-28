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
import com.example.demo.service.GuestbookService;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class HomeController {
	
	
	GuestbookService service;
	
    //@GetMapping(value={"/", "/home"})
    // => void : 요청명.jsp 를 viewName 으로 처리함 (home.jsp)
    //           그러므로 "/" 요청은 .jsp 를 viewName 으로 찾게됨(주의) 
    // => Boot 의 매핑메서드 에서 "/" 요청은 적용안됨(무시됨) 
    //    WebMvcConfig 의 addViewControllers 메서드로 해결
	@GetMapping("/home")
	public void home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
	} //home
	
	@GetMapping("/axtestform")
	public String axTestForm() {
		return "axTest/axTestForm";
	}
	
	@GetMapping(value="/ginsert")
	public String gInsert() {
		GuestbookDTO dto = GuestbookDTO.builder()
							.title("JPA Insert Test")
							.content("~~ 입력이 술술 잘 됩니다 ~~")
							.writer("test")
							.build();
		
		System.out.println("** guest Insert => " + service.register(dto));
		return "redirect:home";
	}
	
	@GetMapping("/glist")
	public String gList() {
		List<Guestbook> list = service.selectList();
		
		for(Guestbook g : list) {
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
		GuestbookDTO dto = GuestbookDTO.builder()
				.gno(5L)
				.title("JPA Update Test")
				.content(" ~~ 수정이 술술 잘 됩니다 ~~")
				.writer("juh94")
				.build();
		
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
		PageRequestDTO requestDTO =  PageRequestDTO.builder()
									.page(2).size(5).build();
		// => 출력할 pageNo , Page 당 출력할 row 갯수
		
		PageResultDTO<GuestbookDTO, Guestbook> resultDTO =
				service.pageList(requestDTO);
		System.out.println("** Page List => " + requestDTO.getPage());
		
			for(GuestbookDTO g: resultDTO.getDtoList() ) {
				System.out.println(g);
			}
		return "redirect:home";
	}
}

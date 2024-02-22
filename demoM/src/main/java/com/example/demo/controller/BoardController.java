package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.BoardDTO;
import com.example.demo.service.BoardService;

import lombok.AllArgsConstructor;
import pageTest.PageMaker;
import pageTest.SearchCriteria;

@Controller
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {
	
	BoardService service;
	
	@GetMapping("/bCheckList")
	public String bCheckList(Model model, SearchCriteria cri, PageMaker pageMaker) {
		
		
		String uri = "board/bPageList";
		// 1) Criteria 처리
		cri.setSnoEno();
		
		// 2) Service
	    // => check 의 값을 선택하지 않은경우 check 값을 null 로 확실하게 해줘야함.
	    //    mapper 에서 명확하게 구분할수 있도록해야 정확한 저리가능
		if (cri.getCheck() != null && cri.getCheck().length < 1) {
			cri.setCheck(null);
			// 체크박스에서 어떤것도 선택하지 않았는데
			
		}
		model.addAttribute("banana", service.bCheckList(cri));
		
		// 3) View처리 : PageMaker 이용
		pageMaker.setCri(cri);
		pageMaker.setTotalRowsCount(service.bCheckRowsCount(cri));
		model.addAttribute("pageMaker", pageMaker);
		
		return uri;
	} //bPageList
	
	
	//** Board_Paging
	// => ver01 : Criteria 를 사용
	// => ver02 : SearchCriteria(Criteria 상속) 사용(검색기능추가)
	@GetMapping("/bPageList")
	public void bPageList(Model model,HttpServletRequest request, SearchCriteria cri, PageMaker pageMaker) {
							
		// 1) Criteria 처리
		// => ver01 : currPage, rowsPerPage 값들은 Parameter 로 전달되어 자동으로 cri에 set
		// => ver02 : ver01 + searchType, keyword 도 동일하게 cri에 set
		cri.setSnoEno();
		
		
		String mappingName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        pageMaker.setMappingName(mappingName);
		// 2) Service
		// => 출력 대상 Rows 를 select 
		// => ver01, 02 모두 같은 Service메서드 사용,
		// 	  mapper interface 에서 사용하는 sql 구문만 교체
		//    즉, BoardMapper.xml 에 새로운 sql 구문 2개 추가
		//		 BoardMapper.java interface 수정
		model.addAttribute("banana", service.bPageList(cri));
		
		// 3) View처리 : PageMaker 이용
		// => cri, totalRowsCount (Read from DB)
		pageMaker.setCri(cri);
		pageMaker.setTotalRowsCount(service.totalRowsCount(cri));
		model.addAttribute("pageMaker", pageMaker);
		
	} //bPageList
	
	
	
	//** Reply Insert
	@GetMapping("/replyInsert")
	public void replyInsert(BoardDTO dto) {
		// => 답글처리를위해 부모글의 root, step, indent 를 인자로 전달받으면,
		//    이 인자에 담겨진 값은 requestScope 과 동일 
		// => 그러므로 response 전송 전까지는 서버(Jsp)에서 사용가능
		//    단, 객체명의 첫문자를 소문자로 해서 접근가능 ( ${boardDTO.~~} )
	}
	
	// => 메서드명과 요청명이 위의 메서드와 동일하지만,
	//    Post 요청이고 인자가 다르기때문에 허용됨.
	@PostMapping("/replyInsert")
	public String replyInsert(Model model, BoardDTO dto, RedirectAttributes rttr) {
		// ** 답글등록
		// => 성공시: boardList 에서 입력완료 확인
		// => 실패시: replyInsert 재입력유도
		String uri = "redirect:boardList";
		
		// => dto 값 확인
		//	-> id, title, content : 사용가능
		//	-> 부모글의 root : 사용가능
		//	-> 부모글의 step, indent : 1씩 증가
		// => Sql 처리
		//	-> replyInsert, step 의 Update
		dto.setStep(dto.getStep()+1);
		dto.setIndent(dto.getIndent()+1);
		if ( service.rinsert(dto) > 0 ) {
			rttr.addFlashAttribute("message", " ~~ 답글등록 성공 ~~");
		}else {
			uri = "board/replyInsert";
			model.addAttribute("message", " ~~ 답글등록 실패!! 다시 하세요 ~~");
		}
		return uri;
	} //replyInsert
	
	
	//** Board List
	@GetMapping("/boardList")
	public void boardList(Model model) {
		model.addAttribute("banana", service.selectList());
	} //boardList
	
	// ** Board Detail
	// => 글요청 처리중, 글을 읽기 전
	// => 조회수 증가
	//	  -> loginID 와 board 의 id 가 다른 경우	
	@GetMapping("/detail")
	public String boardDetail(HttpSession session, Model model, 
							  @RequestParam("jCode") String jCode,
							  @RequestParam("seq") int seq) {
		String uri = "board/boardDetail";
		
		// => 조회수 증가
		// -> selectOne 의 결과를 보관
		// -> update 요청이 아니고, loginID 와 글쓴이 의 id 가 다른경우 
		BoardDTO dto = service.selectOne(seq);
		
		if ("U".equals(jCode)) uri = "board/boardUpdate";
		else if ( !dto.getId().equals((String)session.getAttribute("loginID")) ) {
			// => 조회수 증가 조건 만족
			dto.setCnt(dto.getCnt()+1);
			service.update(dto);
		}
		model.addAttribute("apple", dto);
		
		return uri;
	} //boardDetail
	
	// ** 새글등록: Insert 
	@GetMapping(value="/boardInsert")
	public void boardInsert() {
		// viewName 생략 -> 요청명이 viewName 이 됨
	}
	// => Insert Service 처리: POST
	
	@PostMapping(value="/insert")
	public String binsert(BoardDTO dto, Model model, RedirectAttributes rttr) {
		// 1. 요청분석 & Service
		// => 성공: boardList
		// => 실패: 재입력 유도 (입력폼 으로, board/boardInsert.jsp)
		String uri="redirect:boardList"; // 성공
		
		// 2. Service 처리
		if ( service.insert(dto) > 0 ) {
			rttr.addFlashAttribute("message", "~~ 새글등록 성공 !! ~~");
		}else {
			model.addAttribute("message", "~~ 새글등록 실패!! 다시 하세요 ~~");
			uri="board/boardInsert";
		}
		
		// 3. View 
		return uri;
	} // insert
	
	// ** Board Update
	// => 성공: boardDetail
	// => 실패: boardUpdate
	@PostMapping(value="/update")
	public String bupdate(BoardDTO dto, Model model) {
		
		// => 처리결과에 따른 화면 출력을 위해서 dto 의 값을 Attribute에 보관
		model.addAttribute("apple", dto);
		String uri="board/boardDetail";
		
		// => Service 처리
		if ( service.update(dto) > 0 ) {
			model.addAttribute("message", "~~ 글 수정 성공 ~~");
		}else {
			model.addAttribute("message", "~~ 글 수정 실패 !! 다시 하세요 ~~");
			uri="board/boardUpdate";
		}
		return uri;
	} //update
	
	// ** Board Delete
	@GetMapping(value="/delete")
	public String bdelete(BoardDTO dto, RedirectAttributes rttr) {
		
		String uri = "redirect:boardList";
		if ( service.delete(dto) > 0 ) {
			 rttr.addFlashAttribute("message", "~~ 글삭제 성공 !! ~~") ;	
		}else {
			 rttr.addFlashAttribute("message", "~~ 글삭제 실패 !! ~~");
		}
		return uri;
	} // delete
	
} //class

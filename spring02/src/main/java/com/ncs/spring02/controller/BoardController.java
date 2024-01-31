package com.ncs.spring02.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncs.spring02.domain.BoardDTO;
import com.ncs.spring02.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {

	BoardService service;

	// ** Reply Insert
	@GetMapping("/replyInsert")
	public void replyInsert(BoardDTO dto) {
		// => 답글처리를위해 부모글의 root, step, indent 를 인자로 전달받으면,
		// 이 인자에 담겨진 값은 requestScope 과 동일
		// => 그러므로 response 전송 전까지는 서버(Jsp)에서 사용가능
		// 단, 객체명의 첫문자를 소문자로 해서 접근가능 ( ${boardDTO.~~} )
	}

	// => 메서드명과 요청명이 위의 메서드와 동일하지만,
	// Post 요청이고 인자가 다르기때문에 허용됨.
	@PostMapping("/replyInsert")
	public String replyInsert(Model model, BoardDTO dto, RedirectAttributes rttr) {
		// ** 답글등록
		// => 성공시: boardList 에서 입력완료 확인
		// => 실패시: replyInsert 재입력유도
		String uri = "redirect:boardList";

		// => dto 값 확인
		// -> id, title, content : 사용가능
		// -> 부모글의 root : 사용가능
		// -> 부모글의 step, indent : 1씩 증가
		// => Sql 처리
		// -> replyInsert, step 의 Update
		dto.setStep(dto.getStep() + 1);
		dto.setIndent(dto.getIndent() + 1);
		if (service.rinsert(dto) > 0) {
			rttr.addFlashAttribute("message", " ~~ 답글등록 성공 ~~");
		} else {
			uri = "board/replyInsert";
			model.addAttribute("message", " ~~ 답글등록 실패!! 다시 하세요 ~~");
		}
		return uri;
	} // replyInsert

	// ** Board List
	@GetMapping("/boardList")
	public void boardList(Model model) {
		model.addAttribute("banana", service.selectList());
	} // boardList

	// ** Board Detail
	// => 글요청 처리중, 글을 읽기 전
	// => 조회수 증가
	// -> loginID 와 board 의 id 가 다른 경우
	@GetMapping("/detail")
	public String boardDetail(HttpSession session, Model model, @RequestParam("jCode") String jCode,
			@RequestParam("seq") int seq) {
		String uri = "board/boardDetail";

		// => 조회수 증가
		// -> selectOne 의 결과를 보관
		// -> update 요청이 아니고, loginID 와 글쓴이 의 id 가 다른경우
		BoardDTO dto = service.selectOne(seq);

		if ("U".equals(jCode))
			uri = "board/boardUpdate";
		else if (!dto.getId().equals((String) session.getAttribute("loginID"))) {
			// => 조회수 증가 조건 만족
			dto.setCnt(dto.getCnt() + 1);
			service.update(dto);
		}
		model.addAttribute("apple", dto);

		return uri;
	} // boardDetail

	// ** 새글등록: Insert
	@GetMapping(value = "/boardInsert")
	public void boardInsert(Model model) {
		// viewName 생략 -> 요청명이 viewName 이 됨
	}

	// => Insert Service 처리: POST
	@PostMapping(value = "/insert")
	public String binsert(BoardDTO dto, Model model, RedirectAttributes rttr) {
		// 1. 요청분석 & Service
		// => 성공: boardList
		// => 실패: 재입력 유도 (입력폼 으로, board/boardInsert.jsp)
		String uri = "redirect:boardList"; // 성공

		// 2. Service 처리
		if (service.insert(dto) > 0) {
			rttr.addFlashAttribute("message", "~~ 새글등록 성공 !! ~~");
		} else {
			model.addAttribute("message", "~~ 새글등록 실패!! 다시 하세요 ~~");
			uri = "board/boardInsert";
		}

		// 3. View
		return uri;
	} // insert

	// ** Board Update
	// => 성공: boardDetail
	// => 실패: boardUpdate
	@PostMapping(value = "/update")
	public String bupdate(BoardDTO dto, Model model) {

		// => 처리결과에 따른 화면 출력을 위해서 dto 의 값을 Attribute에 보관
		model.addAttribute("apple", dto);
		String uri = "board/boardDetail";

		// => Service 처리
		if (service.update(dto) > 0) {
			model.addAttribute("message", "~~ 글 수정 성공 ~~");
		} else {
			model.addAttribute("message", "~~ 글 수정 실패 !! 다시 하세요 ~~");
			uri = "board/boardUpdate";
		}
		return uri;
	} // update

	// ** Board Delete
	// => seq로 삭제
	// => 하지만 답글 추가 후 : 원글과 답글 구별해서 지워야 한다.
	// -> 원글 : 원글 삭제시 답글도 지워져야 하기 때문에
	// root 가 동일한 where root = ?
	// -> 답글 : 답글만 지우기 때문에 where seq = ?
	@GetMapping(value = "/delete")
	public String bdelete(BoardDTO dto, RedirectAttributes rttr) {

		String uri = "redirect:boardList";
		if (service.delete(dto) > 0) {
			rttr.addFlashAttribute("message", "~~ 글삭제 성공 !! ~~");
		} else {
			rttr.addFlashAttribute("message", "~~ 글삭제 실패 !! ~~");
		}
		return uri;
	} // delete

} // class

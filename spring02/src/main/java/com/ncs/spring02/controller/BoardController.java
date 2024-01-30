package com.ncs.spring02.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ncs.spring02.domain.BoardDTO;
import com.ncs.spring02.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor // service 에 autowired 할 필요없어짐
@RequestMapping("/board")
public class BoardController {

	BoardService service;

	// Reply Insert @GetMapping("/replyInsert") public void replyInsert(BoardDTO
	// dto) { // 답글처리를 위해 부모글의 root, step, indent를 인자로 전달받으면, // 이 인자에 담겨진 값은
	// requestScope와 동일 // 그러므로 response 전송 전까지는 서버(Jsp)에서 사용가능 // 단, 객체명의 첫알파벳문자를
	// 소문자로 해서 접근가능( ${boardDTO.--} ) }

	// ** Board List
	@GetMapping("/boardList")
	public void boardList(Model model) {
		model.addAttribute("banana", service.selectList());
	} // boardList

	@GetMapping("/boardInsert")
	public void boardForm(Model model, BoardDTO dto) {
	} // boardList

	@PostMapping("/insert")
	public String boardInsert(Model model, BoardDTO dto) {
		String uri = "redirect:/board/boardList";

		return uri;
	}

	// ** Board Detail
	// => 글요청 처리중, 글을 읽기 전
	// => 조회수 증가
	// -> loginId 와 board의 아이디가 다른경우
	@GetMapping("/detail")
	public String boardDetail(Model model,
				@RequestParam("seq") int seq,BoardDTO dto,
				@RequestParam("check")String check,HttpSession session) {

		String uri = "board/boardDetail";

		dto = service.selectOne(seq);
		if(check.equals("O")) {
			dto.setCnt(dto.getCnt()+1);
			service.update(dto);
		}
		session.setAttribute("apple", dto);
		// 조회수는 올렸는데 새로고침 할때마다 조회수가 올라가는 문제
		
		return uri;
	}

	@GetMapping("/boardUpdate")
	public void boardUpdateForm(Model model, @RequestParam("seq") int seq) {
		model.addAttribute("apple", service.selectOne(seq));
	}

	@PostMapping("/update")
	public String Update(BoardDTO dto, Model model,@RequestParam("cnt")int cnt) {

		String uri = "board/boardUpdate";

		if (service.update(dto) > 0) {
			uri = "board/boardList";
			model.addAttribute("apple", service.update(dto));
		} 
		
		model.addAttribute("banana", service.selectList());

		return uri;
	}

	@GetMapping("/delete")
	public String boardDelete(@RequestParam("seq") int seq, Model model) {
		String uri = "board/boardUpdate";

		if (service.delete(seq) > 0) {
			uri = "board/boardList";
			model.addAttribute("banana", service.selectList());
		}

		return uri;

	}
	
	//=> 메서드명과 요청명이 위의 메서드와 동일하지만,
    //     Post 요청이고 인자가 다르기 때문에 허용됨.
    @PostMapping("/replyInsert")
    public String replyInsert(Model model, BoardDTO dto, RedirectAttributes rttr) {
        //** 답글등록
        //=> 성공시: boardList에서 입력완료 확인
        //=> 실패시: replyInsert 재입력유도
        String uri = "redirect:boardList";
        
        //=> dto 값 확인
        // -> id, title, content : 사용가능
        // -> 부모글의 root : 사용가능
        // -> 부모글의 step, indent : 1씩 증가
        //=> Sql 처리
        //    -> replyInsert, step의 Update
        dto.setStep(dto.getStep()+1);
        dto.setIndent(dto.getIndent()+1);
        if(service.rinsert(dto)>0) {
            rttr.addFlashAttribute("message"," ~~ 답글 등록 성공 ~~ ");
        }else {
            uri="board/replyInsert";
            model.addAttribute("message"," !!! 답글 등록 실패 !!!");
        }
        return uri;
    }//replyInsert
	
	

}

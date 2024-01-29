package com.ncs.spring02.controller;

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
	
	//** Board List
	@GetMapping("/boardList")
	public void boardList(Model model) {
		model.addAttribute("banana", service.selectList());
	} //boardList
	
	@GetMapping("/boardInsert")
	public void boardForm(Model model, BoardDTO dto) {
	} //boardList
	
	
	@PostMapping("/insert")
	public String boardInsert(Model model, BoardDTO dto) {
		String uri = "redirect:/board/boardList";
		
		if(dto.getTitle() != null && dto.getContent() != null && service.insert(dto) > 0) {
			model.addAttribute("banana", service.selectList());
		} else {
			uri = "board/boardInsert";
			model.addAttribute("message", "필수 입력");
		}
		
		return uri;
	}
	
	@GetMapping("/detail")
	public String boardDetail(Model model, @RequestParam("jCode")String jCode,
									@RequestParam("seq")int seq) {
		
		String uri = "board/boardDetail";
		
		if ( "U".equals(jCode) ) {
			uri = "board/boardUpdate";
		}
		model.addAttribute("apple", service.selectOne(seq));
		
		return uri;
	}
	
	@PostMapping("/update")
	public String boardUpdate(BoardDTO dto, Model model) {
		String uri = "board/boardList";
		
		
		if(dto.getTitle() != null && dto.getContent() != null) {
			model.addAttribute("apple",service.update(dto));
			model.addAttribute("banana", service.selectList());
		} else {
			uri = "board/boardUpdate";
			model.addAttribute("message", "다시 입력하세요");
		}
		
		return uri;
	}
	
	@GetMapping("/delete")
	public String boardDelete(BoardDTO dto, Model model) {
		String uri = "redirect:/board/boardList";
		
		if(service.delete(dto.getSeq()) > 0) {
			model.addAttribute("banana", service.selectList());
		}
		return uri;
		
	}
	
}

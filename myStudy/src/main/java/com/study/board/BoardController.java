package com.study.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.study.member.Member;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public String boardForm(Model model, Member user) {
		return "/board/board";
	}
	
	@GetMapping("/writeBoard")
	public String boardWriteForm(Model model, Member user) {
		return "/board/writeBoard";
	}
	
	@PostMapping("/writeBoard")
	public String writeBoard(Board board,@SessionAttribute("user") Member user) throws Exception {
		board.setMemId(user.getMemId());
		System.out.println(user);
		System.out.println(board);
		boardService.writeBoard(board);
		
		return "redirect:/board/board";
	}
}

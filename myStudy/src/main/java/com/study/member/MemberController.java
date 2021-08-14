package com.study.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String home(Model model) {
		return "index";
	}
	
	@PostMapping("/login")
	public String login(Member member) throws Exception {
		Member user = memberService.login(member);
		System.out.println(user);
		return "redirect:/";
	}
	
	@GetMapping("/member/register")
	public String registerForm() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String registerSubmit(Member member) throws Exception {
		memberService.joinMember(member);
		return "redirect:/";
	}
}

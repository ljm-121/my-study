package com.study.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
/* @RequestMapping("/member") */
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping("/submitLogin")
	public String submitLogin(Model model, Member member) throws Exception {
		
		Member user = memberService.login(member);

		if(user == null) {
			model.addAttribute("error", "로그인 정보가 일치하지 않습니다.");
			return "index";
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String registerForm() {
		return "/member/register";
	}
	
	@PostMapping("/register")
	public String registerSubmit(Member member) throws Exception {
		memberService.joinMember(member);
		return "redirect:/";
	}
}

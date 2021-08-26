package com.study.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.member.form.MemberForm;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String login(Model model, HttpServletRequest req, Member member, RedirectAttributes redirectAttributes) throws Exception {
		
		HttpSession session = req.getSession();
		Member user = memberService.login(member);

		if(user == null) {
			session.setAttribute("user", null);
			redirectAttributes.addFlashAttribute("error", "로그인 정보가 일치하지 않습니다.");
			return "redirect:/member/login";
		}
		
		session.setAttribute("user", user);
		
		return "/board/board";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) throws Exception {
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/join")
	public String joinForm() {
		return "/member/join";
	}
	
	@PostMapping("/join")
	public String join(@Valid MemberForm member, Errors errors, Model model) throws Exception {
		if (errors.hasErrors()) {
            model.addAttribute(member);
            return "/member/join";
        }

		memberService.joinMember(member);
		return "redirect:/";
	}
}

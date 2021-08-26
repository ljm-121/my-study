package com.study.member.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class MemberForm {
    
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9]{4,8}$", message = "아이디는 영문 대/소문자와 숫자로 4~8자로 구성")
	private String memUserid;
	
	@NotBlank
	@Length(min = 10, max = 20)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[0-9])(?=.*[#?!@$%^&*-]).{10,20}$")
	private String memPassword;
	
	@NotBlank
	@Pattern(regexp = "[가-힣]{2,5}")
	private String memUsername;
	
	@NotBlank
	private String memSex;
	
	@NotBlank
	private String memEmail;
}

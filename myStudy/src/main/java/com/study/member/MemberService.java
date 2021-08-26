package com.study.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.member.form.MemberForm;
import com.study.util.PasswordEncoding;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public Member login(Member member) throws Exception {

		member.setMemPassword(PasswordEncoding.SHA512Pass(member.getMemPassword()));
		return memberMapper.login(member);
	}

	public void joinMember(MemberForm member) throws Exception {
		
		member.setMemPassword(PasswordEncoding.SHA512Pass(member.getMemPassword()));
		memberMapper.joinMember(member);
	}

}

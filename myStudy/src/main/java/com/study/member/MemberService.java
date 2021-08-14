package com.study.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public Member login(Member member) throws Exception {
		return memberMapper.login(member);
	}

	public void joinMember(Member member) throws Exception {
		memberMapper.joinMember();
	}

}

package com.study.member;

import org.apache.ibatis.annotations.Mapper;

import com.study.member.form.MemberForm;

@Mapper
public interface MemberMapper {

	Member login(Member member) throws Exception;

	void joinMember(MemberForm member) throws Exception;
}

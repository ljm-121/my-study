package com.study.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	Member login(Member member) throws Exception;

	void joinMember() throws Exception;
}

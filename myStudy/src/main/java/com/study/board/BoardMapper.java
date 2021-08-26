package com.study.board;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

	void writeBoard(Board board) throws Exception;

}

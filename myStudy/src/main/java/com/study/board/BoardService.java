package com.study.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	public void writeBoard(Board board) throws Exception {
		boardMapper.writeBoard(board);
	}
}

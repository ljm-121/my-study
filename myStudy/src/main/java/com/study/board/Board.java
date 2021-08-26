package com.study.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
	
	private String boardId;
	private String memId;
	private String boardTitle;
	private String boardDate;
	private String boardContent;
	private String boardUse;
}

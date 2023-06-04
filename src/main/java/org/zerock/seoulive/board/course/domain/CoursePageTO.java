package org.zerock.seoulive.board.course.domain;

import lombok.Data;

@Data
public class CoursePageTO {
	
	private Integer currPage = 1; 			// 현재 페이지 번호
	private Integer amount = 6;				// 한 페이지당 게시물 개수
	
	private Integer pagesPerPage = 5;		// 한 페이지당 보여 줄 페이지 목록의 길이
	
	private String searchType = "title";
	private String keyword = "";
	
}	// end class

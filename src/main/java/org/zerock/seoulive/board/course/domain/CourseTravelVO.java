package org.zerock.seoulive.board.course.domain;

import lombok.Value;

@Value
public class CourseTravelVO {
	
	private Integer seq;
	private Integer boardSeq;
	private Integer travelSeq;
	private Integer uploadSeq;
	private String travelId;
	private String userReview;
	private String category;
	private String title;
	private String content;
	private String address;
	
	
	
}	// end class

package org.zerock.seoulive.board.course.domain;

import java.util.Date;

import lombok.Value;

@Value
public class CourseVO {
	private Integer seq;
	private String writer;
	private String title;
	private String review;
	private Integer total;
	private Date writeDate;
	private Date modifyDate;
	private Date durationStart;
	private Date DurationEnd;
	
	public CourseDTO toDTO() {
		CourseDTO dto = new CourseDTO();
		dto.setSeq(seq);
		dto.setWriteDate(writeDate);
		dto.setReview(review);
		dto.setDurationStart(durationStart);
		dto.setDurationEnd(DurationEnd);
		
		return dto;
		
	}	// end toDTO
	
}	// end class

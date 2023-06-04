package org.zerock.seoulive.board.course.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CourseWriteDTO {
	private String writer;
	private String title;
	private String review;
	private Date durationStart;
	private Date durationEnd;
}	// end class

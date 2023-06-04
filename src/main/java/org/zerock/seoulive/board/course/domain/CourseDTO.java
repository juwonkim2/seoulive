package org.zerock.seoulive.board.course.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class CourseDTO {
	
	private Integer seq;
	private String writer;
	private String title;
	private String review;
	private Integer total;
	private Date writeDate;
	private Date modifyDate;
	private Date durationStart;
	private Date DurationEnd;
	private List<CourseTravelVO> listVO;
}	// end class

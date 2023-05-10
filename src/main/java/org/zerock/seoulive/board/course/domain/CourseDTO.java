package org.zerock.seoulive.board.course.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CourseDTO {
    private Integer seq;
    private String WRITER;
    private String TITLE;
    private String REVIEW;
    private Integer TOTAL;
    private Date WRITE_DATE;
    private Date MODIFY_DATE;
    private Date DURATION_START;
    private Date DURATION_END;

} // end class



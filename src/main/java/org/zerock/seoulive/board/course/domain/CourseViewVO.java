package org.zerock.seoulive.board.course.domain;

import lombok.Value;

import java.util.Date;

@Value
public class CourseViewVO {
    private Integer SEQ;
    private String WRITER;
    private String TITLE;
    private String REVIEW;
    private Integer TOTAL;
    private Date WRITE_DATE;
    private Date MODIFY_DATE;
    private Date DURATION_START;
    private Date DURATION_END;
    
    public CourseViewDTO toDTO() {
        CourseViewDTO dto = new CourseViewDTO();

        dto.setSeq(SEQ);
        dto.setWRITER(WRITER);
        dto.setTITLE(TITLE);
        dto.setREVIEW(REVIEW);
        dto.setDURATION_START(DURATION_START);
        dto.setDURATION_END(DURATION_END);

        return dto;
    }

} // end class

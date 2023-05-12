package org.zerock.seoulive.board.course.domain;

import lombok.Value;

import java.util.Date;

@Value
public class commVO {
    private Integer SEQ;
    private String WRITER;
    private String CONTENT;
    private Date WRITE_DATE;
    private Date MODIFY_DATE;
    private String BOARD_NAME;
    private Integer POST_SEQ;
} //end class

package org.zerock.seoulive.board.course.domain;

import lombok.Value;

@Value
public class courseTravelVO {
    private Integer SEQ; //tbl_course_travel의 번호
    private Integer BOARD_SEQ; //tbl_course의 번호
    private Integer TRAVEL_SEQ; //tbl_travel 번호
    private Integer UPLOAD_SEQ; //첨부파일 번호
    private String LINK; //첨부파일 경로
    private String USER_REVIEW; //여행지 당 리뷰
} //end class

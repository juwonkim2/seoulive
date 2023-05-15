package org.zerock.seoulive.board.course.domain;

import lombok.Data;

@Data
public class courseTravelDTO {
    private Integer SEQ; //글 번호
    private Integer BOARD_SEQ; //게시판 번호
    private Integer TRAVEL_SEQ; //여행지 글 번호
    private Integer UPLOAD_SEQ; //첨부파일 번호
    private String LINK; //첨부파일 경로
    private String USER_REVIEW; //여행지 당 리뷰
} //end class

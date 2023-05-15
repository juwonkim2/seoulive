package org.zerock.seoulive.board.course.domain;

import lombok.Data;

import java.util.Date;

@Data
public class courseDTO {

    private Integer SEQ; //게시글 번호
    private String WRITER; //작성자(닉네임)
    private String TITLE; //제목
    private String REVIEW; //총 리뷰
    private Integer TOTAL; //조회수
    private Date WRITE_DATE; //작성일
    private Date MODIFY_DATE; //수정일
    private Date DURATION_START; //DAY1
    private Date DURATION_END; //DAY끝
} //end class

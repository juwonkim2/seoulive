package org.zerock.seoulive.board.course.domain;

import lombok.Value;

import java.util.Date;

@Value
public class courseVO {

    private Integer SEQ; //게시글 번호
    private String WRITER; //작성자(닉네임)
    private String TITLE; //제목
    private String REVIEW; //총 리뷰
    private Integer TOTAL; //조회수
    private Date WRITE_DATE; //작성일
    private Date MODIFY_DATE; //수정일
    private Date DURATION_START; //DAY1
    private Date DURATION_END; //DAY끝


    public courseDTO toDTO() {
        courseDTO dto = new courseDTO();

        dto.setSEQ(SEQ);
        dto.setWRITER(WRITER);
        dto.setTITLE(TITLE);
        dto.setREVIEW(REVIEW);
//        dto.setDURATION_START(DURATION_START);
//        dto.setDURATION_END(DURATION_END);

        return null;
    }

} //end class

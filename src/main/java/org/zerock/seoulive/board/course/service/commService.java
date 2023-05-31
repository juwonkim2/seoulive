package org.zerock.seoulive.board.course.service;

import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.Criteria;
import org.zerock.seoulive.board.course.domain.commDTO;
import org.zerock.seoulive.board.course.domain.commVO;
import org.zerock.seoulive.board.course.domain.memberVO;

import java.util.List;


public interface commService {
    public List<commVO> list(Integer seq) throws Exception;

    public void write(commDTO dto) throws Exception; //등록

    public Integer modify(commDTO dto) throws Exception; //수정

    public Integer delete(Integer seq) throws Exception; //삭제


//    public List<memberVO> getUserpic(Integer seq);

}

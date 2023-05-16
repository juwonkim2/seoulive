package org.zerock.seoulive.board.course.service;

import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.commDTO;
import org.zerock.seoulive.board.course.domain.commVO;
import org.zerock.seoulive.board.course.exception.ServiceException;

import java.util.List;

@Service
public interface courseCommService {

    //    =====================course_comment =========================

    public abstract commVO getListcourseComm(Integer seq) throws ServiceException; //전체보기
    public abstract boolean updateCourseComm(commVO vo) throws ServiceException;
    public abstract boolean modifyCourseComm(commDTO comm) throws ServiceException; //수정
    public abstract boolean removeCourseComm(Integer seq) throws ServiceException; //삭제
}

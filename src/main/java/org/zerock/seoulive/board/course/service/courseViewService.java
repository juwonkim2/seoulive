package org.zerock.seoulive.board.course.service;

import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.*;
import org.zerock.seoulive.board.course.exception.ServiceException;

import java.util.List;

@Service("courseViewService")
public interface courseViewService {
    //특정 게시물 상세조회select(여행지 목록 클릭)
    //특정 게시물 삭제delete
    //댓글 등록update
    //댓글 조회select
    //댓글 삭제
    //댓글 개수 반환

    public abstract courseVO get(Integer seq) throws ServiceException;
    public abstract boolean modify(courseDTO course) throws ServiceException;
    public abstract boolean remove(Integer seq) throws ServiceException;
    public abstract List<courseVO> getList() throws ServiceException; //전체목록

//    ================== course_travel ===============

    public abstract List<courseTravelVO> courseTravelGetList(Integer seq) throws ServiceException;
    public abstract boolean modifyCoTravel(courseTravelDTO courseTravel) throws ServiceException;
    public abstract boolean removeCoTravel(Integer seq) throws ServiceException;



} //end interface

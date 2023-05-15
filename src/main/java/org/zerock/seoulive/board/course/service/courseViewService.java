package org.zerock.seoulive.board.course.service;

import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.courseVO;
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

    public abstract courseVO get(int seq) throws ServiceException; //여행지 가져오기
    public abstract boolean modify(courseVO course) throws ServiceException;
    public abstract boolean remove(int seq) throws ServiceException;
    public abstract List<courseVO> getList() throws ServiceException;
} //end interface

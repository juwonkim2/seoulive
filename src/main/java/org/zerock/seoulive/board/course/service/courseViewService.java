package org.zerock.seoulive.board.course.service;

import org.zerock.seoulive.board.course.exception.DAOException;
import org.zerock.seoulive.board.course.exception.ServiceException;

public interface courseViewService {
    //특정 게시물 상세조회select(여행지 목록 클릭)
    //특정 게시물 삭제delete
    //댓글 등록update
    //댓글 조회select
    //댓글 삭제
    //댓글 개수 반환

//    public abstract List<travelBoardVO> getViewSelect(Criteria cre) throws ServiceException;

    public abstract Boolean viewDelete(Integer seq) throws ServiceException;
   public abstract Boolean commRigster() throws ServiceException;
   public abstract Boolean commSelect() throws ServiceException;
   public abstract Boolean commDelete() throws ServiceException;
    public abstract Integer getTotal() throws DAOException;



} //end interface

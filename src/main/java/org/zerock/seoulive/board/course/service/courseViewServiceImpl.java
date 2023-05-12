package org.zerock.seoulive.board.course.service;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.seoulive.board.course.exception.DAOException;
import org.zerock.seoulive.board.course.exception.ServiceException;

@Log4j2
@NoArgsConstructor

@Service("courseService")
public class courseViewServiceImpl implements courseViewService{
    //특정 게시물 상세조회select(여행지 목록 클릭)
    //특정 게시물 삭제delete
    //댓글 등록update
    //댓글 조회select
    //댓글 삭제
    //댓글 개수 반환
    //맵api




    @Override
    public Boolean viewDelete(Integer seq) throws ServiceException {
        log.trace("viewDelete() invoked");

        return null;
    }

    @Override
    public Boolean commRigster() throws ServiceException{
        log.trace("commRigster() invoked");
        return null;
    }
    @Override
    public Boolean commSelect() throws ServiceException{
        log.trace("commSelect() invoked");
        return null;
    }
    @Override
    public Boolean commDelete() throws ServiceException{
        log.trace("commDelete() invoked");
        return null;
    }
    @Override
    public Integer getTotal() throws DAOException {
        log.trace("getTotal() invoked");
        return null;
    }




} //end intercate

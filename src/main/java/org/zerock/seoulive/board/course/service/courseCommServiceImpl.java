package org.zerock.seoulive.board.course.service;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.commDTO;
import org.zerock.seoulive.board.course.domain.commVO;
import org.zerock.seoulive.board.course.exception.ServiceException;
import org.zerock.seoulive.board.course.mapper.commentMapper;

import java.util.List;
@Log4j2
@NoArgsConstructor

@Service
public class courseCommServiceImpl implements courseCommService{

    @Setter(onMethod_ = @Autowired)
    private commentMapper mapper;

    @Override
    public commVO getListcourseComm(Integer seq) throws ServiceException {
        log.trace("getListcourseComm() invoked");

        return mapper.commRead(seq);
    }

    @Override
    public boolean updateCourseComm(commVO comm) throws ServiceException {
        log.trace("updateCourseComm() invoked");

        return mapper.commInsert(comm) ==1;
    } //update

    @Override
    public boolean modifyCourseComm(commDTO comm) throws ServiceException {
        log.trace("modifyCourseComm() invoked");
//        int result =  mapper.commUpdate(comm);
        return mapper.commUpdate(comm)==1;
    }


    @Override
    public boolean removeCourseComm(Integer seq) throws ServiceException {
        log.trace("removeCourseComm() invoked");

        return mapper.commDelete(seq)==1;
    }


} //end class

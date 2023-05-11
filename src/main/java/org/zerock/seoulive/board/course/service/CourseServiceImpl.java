package org.zerock.seoulive.board.course.service;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.CourseVO;
import org.zerock.seoulive.board.course.exception.ServiceException;
import org.zerock.seoulive.board.course.persistence.CourseDAO;

import java.util.List;

@Log4j2
@NoArgsConstructor

@Service("CourseService")
public class CourseServiceImpl implements CourseService {

    @Setter(onMethod_= {@Autowired})
    private CourseDAO dao;

    @Override
    public List<CourseVO> getList() throws ServiceException {
        log.trace("getList() invoked.");

        try {
            return this.dao.list();
        } catch(Exception e){
            throw new ServiceException(e);
        } // try-catch
    }
} // end class

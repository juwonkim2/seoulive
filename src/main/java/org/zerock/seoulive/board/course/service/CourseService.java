package org.zerock.seoulive.board.course.service;

import org.zerock.seoulive.board.course.domain.CourseVO;
import org.zerock.seoulive.board.course.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CourseService {

    public abstract List<CourseVO> getList() throws ServiceException;

} // end interface

package org.zerock.seoulive.board.course.persistence;

import org.zerock.seoulive.board.course.domain.CourseVO;
import org.zerock.seoulive.board.course.exception.DAOException;

import java.util.List;

public interface CourseDAO {

    public abstract List<CourseVO> list() throws DAOException;

    public abstract void write();

    public abstract void update();

    public abstract void delete();

    public abstract void readCount();

    public abstract CourseVO retrieve();

    public abstract List<CourseVO> search();

    public abstract CourseVO replyui();

    public abstract void makeReply();

    public abstract void reply();

    public abstract int totalCount();

    public abstract void page();

} // end class

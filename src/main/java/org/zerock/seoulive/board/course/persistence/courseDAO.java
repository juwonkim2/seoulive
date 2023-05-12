package org.zerock.seoulive.board.course.persistence;

import org.zerock.seoulive.board.course.domain.commDTO;
import org.zerock.seoulive.board.course.domain.courseVO;
import org.zerock.seoulive.board.course.exception.DAOException;
import org.zerock.seoulive.board.course.exception.ServiceException;

public interface courseDAO {
    public abstract courseVO selectComm(commDTO commdto) throws DAOException;
} //end interface

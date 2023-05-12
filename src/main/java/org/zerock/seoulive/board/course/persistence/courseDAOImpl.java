package org.zerock.seoulive.board.course.persistence;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import org.zerock.seoulive.board.course.domain.commDTO;
import org.zerock.seoulive.board.course.domain.courseVO;
import org.zerock.seoulive.board.course.exception.DAOException;

@Log4j2
@AllArgsConstructor

@Repository
public class courseDAOImpl implements courseDAO{

    private SqlSessionFactory sqlSessionFactory;
    @Override
    public courseVO selectComm(commDTO commdto) throws DAOException {
        log.trace("selectComm({}) invoked", commdto);

        SqlSession sqlSession = this.sqlSessionFactory.openSession();



        return null;
    }


} //end class

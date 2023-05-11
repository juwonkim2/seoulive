package org.zerock.seoulive.board.course.persistence;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;
import org.zerock.seoulive.board.course.domain.CourseVO;
import org.zerock.seoulive.board.course.exception.DAOException;

import java.util.List;

@Log4j2
@AllArgsConstructor

@Repository("CourseDAO")
public class CourseDAOImpl implements CourseDAO, InitializingBean {

    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<CourseVO> list() throws DAOException {
        log.trace("list() invoked.");


        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        try(sqlSession) {

            String namespace = "org.zerock.myapp.persistence.UserDAO";
            String sqlId = "selectUser";
            String sql = namespace+"."+sqlId;

            return sqlSession.selectOne(sql, dto);
        } catch(Exception e) {
            throw new DAOException(e);
        } // try-with-resources


        return null;
    }

    @Override
    public void write() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void readCount() {

    }

    @Override
    public CourseVO retrieve() {
        return null;
    }

    @Override
    public List<CourseVO> search() {
        return null;
    }

    @Override
    public CourseVO replyui() {
        return null;
    }

    @Override
    public void makeReply() {

    }

    @Override
    public void reply() {

    }

    @Override
    public int totalCount() {
        return 0;
    }

    @Override
    public void page() {

    }

//    ----------------------
    @Override
    public void afterPropertiesSet() throws Exception {

    }

} // end class

package org.zerock.seoulive.board.course.mapper;


import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.zerock.seoulive.board.course.domain.courseVO;

import java.util.List;

@Repository
public interface courseViewMapper {

//    @Select("select * from tbl_course where seq > 0")
    public List<courseVO> getList();

    public courseVO read(int seq);

    public int delete(int seq);

    public int update(courseVO course);
} //end interface

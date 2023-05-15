package org.zerock.seoulive.board.course.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.zerock.seoulive.board.course.domain.courseDTO;
import org.zerock.seoulive.board.course.domain.courseVO;

import java.util.List;
@Mapper
@Repository
public interface courseViewMapper {

//    @Select("select * from tbl_course where seq > 0")
    public List<courseVO> getList();

    public courseVO read(int seq);

    public int delete(int seq);

    public int update(courseDTO course);
} //end interface

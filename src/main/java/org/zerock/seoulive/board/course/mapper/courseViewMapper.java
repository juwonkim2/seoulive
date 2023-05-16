package org.zerock.seoulive.board.course.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.zerock.seoulive.board.course.domain.courseDTO;
import org.zerock.seoulive.board.course.domain.courseTravelDTO;
import org.zerock.seoulive.board.course.domain.courseTravelVO;
import org.zerock.seoulive.board.course.domain.courseVO;

import java.util.List;
@Mapper
@Repository
public interface courseViewMapper {

//    @Select("select * from tbl_course where seq > 0")
    public List<courseVO> getList();

    public courseVO read(Integer seq_course);

    public Integer delete(Integer seq_course);

    public Integer update(courseDTO course);

//    =============== course_travel ===================

    public List<courseTravelVO> courseTravelGetList(Integer seq_courseTravel);

    public Integer courseTravelDelete(Integer seq_courseTravel);

    public Integer CourseTravelUpdate(courseTravelDTO courseTravel);



} //end interface

package org.zerock.seoulive.board.course.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.zerock.seoulive.board.course.domain.CourseViewDTO;
import org.zerock.seoulive.board.course.domain.CourseTravelDTO;
import org.zerock.seoulive.board.course.domain.CourseTravelVO;
import org.zerock.seoulive.board.course.domain.CourseViewVO;

import java.util.List;
@Mapper
public interface courseViewMapper {

//    @Select("select * from tbl_course where seq > 0")
    public List<CourseViewVO> getList();

    public CourseViewVO read(Integer seq);

    public Integer delete(Integer seq);

    public Integer update(CourseViewDTO course);

//    =============== course_travel ===================

    public List<CourseTravelVO> getTravelList(Integer seq);

    public Integer courseTravelDelete(Integer seq);

    public Integer CourseTravelUpdate(CourseTravelDTO courseTravel);



} //end interface

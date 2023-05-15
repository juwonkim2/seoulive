package org.zerock.seoulive.board.course.mapper;


import org.springframework.stereotype.Repository;
import org.zerock.seoulive.board.course.domain.courseVO;

import java.util.List;

@Repository
public interface courseViewMapper {

    int totalCount(); //조회수
    courseVO getList(); //여행지 가져오기
} //end interface

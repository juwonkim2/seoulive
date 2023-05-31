package org.zerock.seoulive.board.course.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zerock.seoulive.board.course.domain.Criteria;
import org.zerock.seoulive.board.course.domain.commDTO;
import org.zerock.seoulive.board.course.domain.commVO;

import java.util.List;

@Mapper
public interface commentMapper {

    public Integer commRegit(commDTO dto);
    public List<commVO> commList(Integer seq); //목록
    public Integer commTotal(Integer seq); //개수

    public Integer commDelete(Integer seq);

    public Integer commUpdate(commDTO dto);

    public commDTO commUpdateOne(Integer seq); //댓글 한 개 정보 수정

  
}

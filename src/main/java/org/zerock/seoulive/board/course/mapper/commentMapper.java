package org.zerock.seoulive.board.course.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.seoulive.board.course.domain.commVO;

@Mapper
public interface commentMapper {
    public int insert(commVO vo);

    public commVO read(Integer seq); //특정 댓글 읽기

    public int delete(Integer seq);

    public int update(commVO content);
}

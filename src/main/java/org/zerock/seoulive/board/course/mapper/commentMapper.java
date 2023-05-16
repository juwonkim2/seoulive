package org.zerock.seoulive.board.course.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.zerock.seoulive.board.course.domain.commDTO;
import org.zerock.seoulive.board.course.domain.commVO;

@Mapper
@Repository
public interface commentMapper {
    public int commInsert(commVO vo);

    public commVO commRead(Integer seq); //특정 댓글 읽기

    public Integer commDelete(Integer seq);

    public Integer commUpdate(commDTO content);
}

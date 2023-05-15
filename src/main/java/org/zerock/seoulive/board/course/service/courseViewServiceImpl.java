package org.zerock.seoulive.board.course.service;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.courseDTO;
import org.zerock.seoulive.board.course.domain.courseVO;
import org.zerock.seoulive.board.course.exception.ServiceException;
import org.zerock.seoulive.board.course.mapper.courseViewMapper;

import java.util.List;

@Log4j2
@NoArgsConstructor

//@RequiredArgsConstructor
@Service("courseViewService")

//특정 게시물 상세조회select(여행지 목록 클릭)
//특정 게시물 삭제delete
//댓글 등록update
//댓글 조회select
//댓글 삭제
//댓글 개수 반환
//맵api


public class courseViewServiceImpl implements courseViewService{
    @Setter(onMethod_ = @Autowired )
    private courseViewMapper mapper;

    @Override
    public courseVO get(Integer seq) throws ServiceException {
        log.info("get invoked >>>");

        return mapper.read(seq);
    }

    @Override
    public boolean modify(courseDTO course) throws ServiceException {
        log.info("modify invoked >>>");

        return mapper.update(course) ==1;
    }

    @Override
    public boolean remove(Integer seq) throws ServiceException {
        log.info("remove invoked >>>");

        return mapper.delete(seq) ==1;
    }

    @Override
    public List<courseVO> getList() throws ServiceException {

        log.info("getList invoked >>> ");

        return mapper.getList();
    }







} //end intercate

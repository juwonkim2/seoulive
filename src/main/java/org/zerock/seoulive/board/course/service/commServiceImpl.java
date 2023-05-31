package org.zerock.seoulive.board.course.service;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.Criteria;
import org.zerock.seoulive.board.course.domain.commDTO;
import org.zerock.seoulive.board.course.domain.commVO;
import org.zerock.seoulive.board.course.domain.memberVO;
import org.zerock.seoulive.board.course.mapper.MemberMapper;
import org.zerock.seoulive.board.course.mapper.commentMapper;

import java.util.List;
@Log4j2
@NoArgsConstructor
@Service
public class commServiceImpl implements commService{

    @Setter(onMethod_ = @Autowired)
    private commentMapper mapper;

    @Setter(onMethod_ = @Autowired) private MemberMapper memMapper;


    @Override
    public List<commVO> list(Integer seq) throws Exception {
        log.trace(" >>> list({}) invoked");

        return this.mapper.commList(seq);
    }

    @Override
    public void write(commDTO dto) throws Exception {
        log.info("write() invoked");

        this.mapper.commRegit(dto);
    }

    @Override
    public Integer modify(commDTO dto) throws Exception {
        log.info("modify() invoked");

        return this.mapper.commUpdate(dto);
    }

    @Override
    public Integer delete(Integer seq) throws Exception {
        log.info("delete() invoked");

        return this.mapper.commDelete(seq);
    }



//    @Override
//    public List<memberVO> getUserpic(String profile_img) {
//
//        return this.memMapper.getUserPic(profile_img);
//    }

}

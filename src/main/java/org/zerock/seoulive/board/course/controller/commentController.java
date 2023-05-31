package org.zerock.seoulive.board.course.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zerock.seoulive.board.course.domain.Criteria;
import org.zerock.seoulive.board.course.domain.commDTO;
import org.zerock.seoulive.board.course.domain.commVO;
import org.zerock.seoulive.board.course.mapper.commentMapper;
import org.zerock.seoulive.board.course.service.commService;

import javax.print.attribute.standard.Media;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@RequestMapping("/board/comment")
@Log4j2

@Controller
@AllArgsConstructor
public class commentController {
    @Autowired private commService service;
    @Autowired
    private commDTO dto;
    @Autowired private commentMapper mapper;


    //등록
    @PostMapping(value="/write")
    public String create(@RequestParam("WRITER") String WRITER,
                         @RequestParam("CONTENT") String CONTENT,
                         @RequestParam("POST_SEQ") Integer POST_SEQ
                         ) throws Exception {
        log.trace("create({}) invoked", dto);

        commDTO dto = new commDTO();
        dto.setWriter(WRITER);
        dto.setContent(CONTENT);
        dto.setPost_seq(POST_SEQ);
        service.write(dto);

        return "redirect:/board/course/get?seq=" + dto.getPOST_SEQ();

    }


    @PostMapping(path = "/delete")
    public ResponseEntity<String> commDelete(Integer seq) throws Exception {
        service.delete(seq);

        return ResponseEntity.ok("");
    }

    //수정
    @PostMapping("/update")
    public void modify(commDTO dto) throws Exception {
        service.modify(dto);
    }

}

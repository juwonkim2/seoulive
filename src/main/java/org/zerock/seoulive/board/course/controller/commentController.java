package org.zerock.seoulive.board.course.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
import org.zerock.seoulive.board.course.service.commService;

import javax.print.attribute.standard.Media;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@RequestMapping("/board/comment")
@Log4j2

@Controller
@AllArgsConstructor
public class commentController {
    @Autowired private commService service;
    @Autowired private commDTO dto;


    //등록
    @PostMapping(value="/write")
    public String create(
                         @RequestParam("post_seq") Integer post_seq,
                         @RequestParam("content") String content) throws Exception {
        log.trace("create() invoked");

      commDTO commentdto = new commDTO();
      commentdto.setContent(content);
      commentdto.setPost_seq(post_seq);

      service.write(commentdto);

      return "redirect:/board/course/get?seq=" + post_seq;

    }


    //특정 게시물 댓글 목록
//    @GetMapping(value= "/getCommentList")
//
//    public List<commDTO> getCommentList(
//           @RequestParam("seq") Integer seq
//            ,Model model) throws Exception {
//        log.trace("getList() invoked");
//
//
//        commDTO commdto = new commDTO();
//        commdto.setSEQ(seq);
//
//        return service.list(commdto);
//
//    }

    //삭제
    @GetMapping(params = {"seq"},
    produces = {
            MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> remove(@PathVariable("seq")Integer seq) throws Exception {
        log.info("remove() invoked");

        return service.delete(seq) ==1
                ?new ResponseEntity<>("success", HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //수정
    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
    value="/{seq}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> modify(
            @RequestBody commVO vo,
            @PathVariable("seq") Integer seq
    ) throws Exception {
        vo.setSEQ(seq);

        log.info("seq: {}", seq);
        log.info("modify: {}", vo);

        return service.modify(vo) ==1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

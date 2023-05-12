package org.zerock.seoulive.board.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.seoulive.board.course.exception.ServiceException;



@Controller
@RequestMapping("/board/course")
public class courseViewController {
    //특정 게시물 상세조회select
    //특정 게시물 삭제delete
    //맵api
    //댓글 등록update
    //댓글 조회select

    @GetMapping("/courseView")
    void view() {
        ;;
    } //특정 게시물 삭제



} //end class

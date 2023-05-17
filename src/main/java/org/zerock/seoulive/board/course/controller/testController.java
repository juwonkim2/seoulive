package org.zerock.seoulive.board.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {

    @GetMapping("/")
    public String test1() {
        return "board/test";
//        test1 패키징작업
    }
}

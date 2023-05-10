package org.zerock.seoulive.board.free.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

    @RequestMapping("/")
    public String test1() {
        return "board/boardtest";
//        test1 패키징작업
    }
}

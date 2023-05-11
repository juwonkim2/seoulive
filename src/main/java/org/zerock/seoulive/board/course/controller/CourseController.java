package org.zerock.seoulive.board.course.controller;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.seoulive.board.course.exception.ControllerException;

@Log4j2
@NoArgsConstructor

@RequestMapping("/board/course")
@Controller
public class CourseController {

    // 1. 게시판 목록 조회
    @GetMapping("/list")
    void list() throws ControllerException {
        log.trace("list() invoked.");

        try {

        } catch(Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // list


    // 2. 새로운 게시물 등록
    @PostMapping(path="/register", params= {"title", "content", "writer"})
    String register(RedirectAttributes rttrs) throws ControllerException {
        log.trace("register() invoked.");

        try {


            return "redirect:/board/course/list";
        } catch(Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // register

    @GetMapping(path="/register")
    void register() {	// 단순 등록화면 요청
        log.trace("register() invoked.");

    } // register


    // 3. 특정 게시물 상세조회
    @GetMapping(path={"/get", "/modify"}, params="bno")
    void get(@RequestParam("seq") Integer seq, Model model) throws ControllerException {
        log.trace("get() invoked.");

        try {


        } catch(Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // get


    // 4. 특정 게시물 업데이트(UPDATE)
    @PostMapping(path="/modify")
    String modify(RedirectAttributes rttrs) throws ControllerException {
        log.trace("modify() invoked.");

        try {



            return "redirect:/board/course/list";
        } catch(Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // modify


    // 5. 특정 게시물 삭제(DELETE)
    @PostMapping(path="/remove")
    String remove(@RequestParam("seq") Integer seq,
                  Integer currPage,
                  RedirectAttributes rttrs) throws ControllerException {
        log.trace("remove() invoked.");

        try {



            return "redirect:/board/course/list";
        } catch(Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // remove

} // end class

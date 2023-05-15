package org.zerock.seoulive.board.course.controller;

import lombok.AllArgsConstructor;
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
import org.zerock.seoulive.board.course.domain.courseVO;
import org.zerock.seoulive.board.course.exception.ControllerException;
import org.zerock.seoulive.board.course.exception.ServiceException;
import org.zerock.seoulive.board.course.service.courseViewService;

import java.util.List;


@Log4j2
@AllArgsConstructor

@Controller
@RequestMapping("/board/course")
public class courseViewController {
    //특정 게시물 상세조회select
    //특정 게시물 삭제delete
    //맵api
    //댓글 등록update
    //댓글 조회select

    private courseViewService service;

    @GetMapping("/list")
    public void list(Model model) throws ServiceException { //여행지목록
        log.info("list({}) invoked >>>", model);

        model.addAttribute("list", service.getList());
    }

    @GetMapping("/get")
    public void get(@RequestParam("seq") int seq, Model model) throws ServiceException {
        log.info("/get");

        model.addAttribute("board", service.get(seq));
    }

    @PostMapping("/modify")
    public String modify(courseVO course, RedirectAttributes rttrs) throws ServiceException {
        log.info("modify() invoked");

        if(service.modify(course)) {
            rttrs.addFlashAttribute("result success");
        }
            return "redirect:/board/course/list";
        }


    @PostMapping("/remove")
    public String remove(@RequestParam("seq") int seq, RedirectAttributes rttrs) throws ServiceException {
        log.info("remove() inovked");
        if(service.remove(seq)) {
            rttrs.addFlashAttribute("result success");
        }
        return "redirect:/board/course/list";
    }


} //end class

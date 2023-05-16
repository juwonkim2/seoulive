package org.zerock.seoulive.board.course.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.seoulive.board.course.domain.courseDTO;
import org.zerock.seoulive.board.course.domain.courseTravelDTO;
import org.zerock.seoulive.board.course.domain.courseTravelVO;
import org.zerock.seoulive.board.course.domain.courseVO;
import org.zerock.seoulive.board.course.exception.ControllerException;
import org.zerock.seoulive.board.course.exception.ServiceException;
import org.zerock.seoulive.board.course.service.courseViewService;

import java.util.List;
import java.util.Objects;


@Log4j2
@NoArgsConstructor

@Controller
@RequestMapping("/board/course")
public class courseViewController {
    //특정 게시물 상세조회select
    //특정 게시물 삭제delete
    //맵api
    //댓글 등록update
    //댓글 조회select

    @Setter(onMethod_ = @Autowired)
    private courseViewService service;

    //전체 list목록 반환
    @GetMapping("/list")
    public void list(Model model) throws ControllerException { //여행지목록
        log.info("list({}) invoked >>>", model);

        try{
            List<courseVO> list = this.service.getList();
            model.addAttribute("__LIST__", list);
        } catch (Exception e) {
            throw new ControllerException(e);
        }

    }

    //상세조회
    @GetMapping(path = "/get", params = {"seq_course", "board_seq"})
    public void get(@RequestParam("seq_course") Integer seq_course, Integer board_seq, Model model) throws Exception {
       log.trace("get() invoked");

       try {
           courseVO vo = this.service.get(seq_course);
           List<courseTravelVO> tr_vo = this.service.courseTravelGetList(board_seq);

           model.addAttribute("__BOARD__", vo);
           model.addAttribute("__COURSETRAVELBOARD__", tr_vo);


       } catch (Exception e) {
           throw new ControllerException(e);
       }
    }

    //수정하기
    @PostMapping("/modify")
    public String modify(courseDTO dto,courseTravelDTO coursedto, RedirectAttributes rttrs) throws Exception {
        log.trace("modify({}) invoked", dto);

        try {
            Objects.requireNonNull(dto);
            assert coursedto != null;

            if (this.service.modify(dto)) {
                rttrs.addAttribute("result", "true");
                rttrs.addAttribute("seq", dto.getSEQ());

                rttrs.addAttribute("seq_courseTravel", coursedto.getSEQ());
            }
            return "redirect:/course/list";
        } catch (Exception e) {
            throw new ControllerException(e);
        }
    }


    @PostMapping("/remove")
    public String remove(@RequestParam("seq_course") Integer seq_course, RedirectAttributes rttrs) throws Exception {
        log.trace("remove({}) inovked", seq_course);

        try{
            if(this.service.remove(seq_course)) {
                rttrs.addAttribute("result", "true");
                rttrs.addAttribute("seq", seq_course);
            }
            return "redirect:/board/course/list";
        } catch (Exception e) {
            throw new ControllerException(e);
        }
    }


    //    =============== course_travel =================

//    @GetMapping(path = "/get", params = {"seq_courseTravel"})
//    public void getCoTravel(@RequestParam("seq_courseTravel") Integer seq_courseTravel, Model model) throws Exception {
//        log.trace("get() invoked");
//
//        try {
//            courseTravelVO vo = this.service.getCoTravel(seq_courseTravel);
//
//            model.addAttribute("__COURSETRAVELBOARD__", vo);
//        } catch (Exception e) {
//            throw new ControllerException(e);
//        }
//    }


} //end class

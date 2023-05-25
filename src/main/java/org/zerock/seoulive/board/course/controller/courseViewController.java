package org.zerock.seoulive.board.course.controller;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.seoulive.board.course.domain.*;
import org.zerock.seoulive.board.course.exception.ControllerException;
import org.zerock.seoulive.board.course.service.commService;
import org.zerock.seoulive.board.course.service.courseViewService;

import java.util.List;
import java.util.Map;
import java.util.Objects;


@Log4j2
@NoArgsConstructor

@Controller
@RequestMapping("/board/course")
public class courseViewController {
    //특정 게시물 상세조회select
    //특정 게시물 삭제delete
    //맵api


    @Setter(onMethod_ = @Autowired)
    private courseViewService service;
    @Setter(onMethod_ = @Autowired)
    private commService commservice;

    //전체 list목록 반환
    @GetMapping("/list")
    public String list(Model model) throws ControllerException { //여행지목록
        log.info("list({}) invoked >>>", model);

        try{
            List<courseVO> list = this.service.getList();
            model.addAttribute("__LIST__", list);

            return "/board/course/list";
        } catch (Exception e) {
            throw new ControllerException(e);
        }

    }

    //상세조회
    @GetMapping(path ={ "/get", "/modify"}, params = {"seq"})
    public void get(@RequestParam(value ="seq") Integer seq,
//                      @RequestParam(value="board_name") String board_name,
                      Model model) throws Exception {
       log.trace("get() invoked");

       try {

               List<courseVO> vo = this.service.get(seq);
               List<courseTravelVO> tr_vo = this.service.courseTravelGetList(seq);

               Integer total = commservice.getTotal(seq);
               log.info("댓글 갯수: {}", total);

               model.addAttribute("__BOARD__", vo);
               model.addAttribute("__COURSETRAVELBOARD__", tr_vo);
//               model.addAttribute("__COMMENT_LIST__", commList);
               model.addAttribute("__COMMENT_TOTAL__",total);

//               return "forward:/board/course/get";

       } catch (Exception e) {
           throw new ControllerException(e);
       }
    }

    //수정하기
    @PostMapping (path = "/modify", params = {"seq"})
    public String modify(@RequestParam(value="seq") Integer seq,
                       courseDTO dto,courseTravelDTO coursedto,
                       Integer currPage,RedirectAttributes rttrs) throws Exception {
        log.trace("modify({}) invoked", dto);


        try {
            Objects.requireNonNull(dto);
            assert coursedto != null;

            rttrs.addAttribute("currPage", currPage);

            if (this.service.modify(dto)) {
                rttrs.addAttribute("result", "success");
                rttrs.addAttribute("seq", dto.getSeq());
                }
            return "redirect:/course/list";
        } catch (Exception e) {
            throw new ControllerException(e);
        }
    }


    @PostMapping("/remove")
    public String remove(@RequestParam("seq")
                             Integer currPage, Integer seq, RedirectAttributes rttrs) throws Exception {
        log.trace("remove({}) inovked", seq);

        try{
            if(this.service.remove(seq)) {
                rttrs.addAttribute("currPage", currPage);
                rttrs.addAttribute("result", "success");
                rttrs.addAttribute("seq", seq);
            }
            return "redirect:/board/course/list";
        } catch (Exception e) {
            throw new ControllerException(e);
        }
    }


    //    =============== comment =================



} //end class

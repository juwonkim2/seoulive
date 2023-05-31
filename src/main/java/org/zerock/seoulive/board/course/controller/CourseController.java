package org.zerock.seoulive.board.course.controller;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.seoulive.board.course.domain.*;
import org.zerock.seoulive.board.course.exception.ControllerException;
import org.zerock.seoulive.board.course.service.CourseService;
import org.zerock.seoulive.board.course.service.commService;
import org.zerock.seoulive.board.travel.domain.TravelDTO;
import org.zerock.seoulive.member.join.service.UserService;

import java.security.Principal;
import java.util.*;


@Log4j2
@NoArgsConstructor

@RequestMapping("/board/course")
@Controller
public class CourseController {
	
	@Setter(onMethod_=@Autowired)
	private CourseService service;

	@Setter(onMethod_=@Autowired) private commService commservice;
	@Setter(onMethod_=@Autowired) private UserService userService;

	// 1. 게시판 목록 조회
//	@GetMapping("/list")
//	void list(CoursePageTO page, Model model) throws ControllerException {
//		log.trace("list({}, {}) invoked.", page, model);
//		
//		try {
//			List<CourseDTO> list = this.service.getList(page);
//			
//			for (int i = 0; i<list.size(); i++) {
//				list.get(i).setListVO(this.service.getTravelList(list.get(i)));
//			} // for
//			model.addAttribute("__LIST__", list);
//			
//			CoursePageDTO pageDTO = new CoursePageDTO(page, this.service.getTotal());
//			model.addAttribute("pageMaker", pageDTO);
//		} catch(Exception e) {
//			throw new ControllerException(e);
//		} // try-catch
//	} // list
	
	// 2. 검색 후 게시판 목록 조회
	@GetMapping(path="/list")
	void search(CoursePageTO page, Model model) throws ControllerException {
		log.trace("list({}, {}) invoked.", page, model);
		
		try {
			if(page.getSearchType() =="" || page.getSearchType() == null ){
				page.setSearchType("TITLE");
			}
			List<CourseDTO> list = this.service.searchCourse(page);
			
			// Request Scope 공유속성 생성
			
			
			for (int i = 0; i<list.size(); i++) {
				list.get(i).setListVO(this.service.getTravelList(list.get(i)));
			} // for
			model.addAttribute("__LIST__", list);
			
			CoursePageDTO pageDTO = new CoursePageDTO(page, this.service.getTotalSearch(page));
			model.addAttribute("pageMaker", pageDTO);

		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // search
	
	
	
	// 2. 새로운 게시물 등록
	@PostMapping(path="/register")
	String register(CourseWriteDTO dto) throws ControllerException {
		log.trace("register({}) invoked.", dto);
		
		try {
			
			this.service.register(dto);
			
			return "redirect:/board/course/list";
		} catch(Exception e) {
			e.getStackTrace();
			throw new ControllerException(e);
		} // try-catch
	} // register
	
	@PostMapping("/getSeq")
	ResponseEntity<Map<String, Integer>> getSeq(Model model) throws ControllerException {
		log.trace("getSeq() invoked.");
		
		try {
			Integer seq = this.service.getCourseSeq();
	        Map<String, Integer> response = new HashMap<>();
	        response.put("seq", seq);
	        return ResponseEntity.ok(response);
		} catch(Exception e) {
			e.getStackTrace();
			throw new ControllerException(e);
		} // try-catch
	} // getSeq
	
	@PostMapping(path="/registerTravel")
	String registerTravel(CourseWriteVO vo, Model model) throws ControllerException {
		log.trace("register({}) invoked.", vo);
		
		try {
			
			this.service.registerTravel(vo);
			
			
			return null;
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // register
	
	
	@GetMapping(path="/register")
	String register() {	// 단순 등록화면 요청
		log.trace("register() invoked.");
		
		
		return "/board/course/write";
	} // register
	
	// 작성시 여행지 검색
	@GetMapping("/travel_search")
	public String searchTravelData(String keyword, String resultId, Model model) throws ControllerException {
		
		try {
			
		    List<TravelDTO> travelData = this.service.getTravelData(keyword);
		    model.addAttribute("travelData", travelData);
		    model.addAttribute("resultId", resultId);
		    return "/board/course/searchTravelData"; 
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	}
	
	@PostMapping("/course_like")
	public void courseLike(CourseLikeDTO dto) throws ControllerException {
		log.trace("register({}) invoked.", dto);
		
		try {
			
			this.service.courseLike(dto);
			
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // register

	//상세조회
	@GetMapping(path ={ "/get", "/modify"}, params = {"seq"})
	public String get(Integer seq, Model model
					  ,Principal principal
	) throws ControllerException {
		log.trace("get() invoked");


		try {
			CourseVO vo = this.service.get(seq);
			List<CourseTravelVO> travelList = this.service.getTravelList(seq);
			List<commVO> List = this.commservice.list(seq);


//			List<memberVO> userPic = this.commservice.getUserpic(seq);

			model.addAttribute("__BOARD__", vo);
			model.addAttribute("__COURSETRAVELBOARD__", travelList);
			model.addAttribute("__COMMENT_LIST__", List);

//			model.addAttribute("__COMMENT_PIC__", userPic);

			Date startDate = vo.getDURATION_START();
			Date endDate = vo.getDURATION_END();

			// 종료일자에서 시작일자를 뺀 결과를 계산
			long durationInMillis = endDate.getTime() - startDate.getTime();
			int durationInDays = (int) (durationInMillis / (1000 * 60 * 60 * 24));
			model.addAttribute("__DAY_COUNT__", durationInDays);



			return "board/course/get";
		} catch (Exception e) {
			e.getStackTrace();
			throw new ControllerException(e);
		}
	} // get


//	@PostMapping("/comm_write")
//	public String commRegister(commDTO dto) throws ControllerException {
//		log.trace("commRegister({}) invoked.", commservice);
//
//		try {
//
//			this.commservice.write(dto);
//
//			return "redirect:/board/course/get?seq="+dto.getSeq();
//		} catch(Exception e) {
//			throw new ControllerException(e);
//		} // try-catch
//	} // commRegister
	
  //수정하기
//    @PostMapping (path = "/modify", params = {"seq"})
//    public String modify(@RequestParam(value="seq") Integer seq,
//                       courseDTO dto,courseTravelDTO coursedto,
//                       Integer currPage,RedirectAttributes rttrs) throws ControllerException {
//        log.trace("modify({}) invoked", dto);
//
//
//        try {
//            Objects.requireNonNull(dto);
//            assert coursedto != null;
//
//            rttrs.addAttribute("currPage", currPage);
//
//            if (this.service.modify(dto)) {
//                rttrs.addAttribute("result", "success");
//                rttrs.addAttribute("seq", dto.getSeq());
//                }
//            return "redirect:/course/list";
//        } catch (Exception e) {
//            throw new ControllerException(e);
//        }
//    }
	
//	@GetMapping(path="/modify")
//	void modify(Integer seq, Model model)  throws ControllerException {	// 단순 수정화면 요청
//		log.trace("modify({}) invoked.", seq);
//		
//		try {
//			
//			
//		} catch(Exception e) {
//			e.getStackTrace();
//			throw new ControllerException(e);
//		} // try-catch
//	} // modify		// get메소드로 이동함
	
	
//	// 5. 특정 게시물 삭제(DELETE)
    @PostMapping("/remove")
    public String remove(@RequestParam("seq")
                             Integer currPage, Integer seq, RedirectAttributes rttrs) throws ControllerException {
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
	
} // end class

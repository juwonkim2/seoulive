package org.zerock.seoulive.board.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.seoulive.board.course.domain.CourseDTO;
import org.zerock.seoulive.board.course.domain.CoursePageDTO;
import org.zerock.seoulive.board.course.domain.CoursePageTO;
import org.zerock.seoulive.board.course.exception.ControllerException;
import org.zerock.seoulive.board.course.service.CourseService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RequestMapping("/board/course")
@Controller
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	
	// 1. 게시판 목록 조회
	@GetMapping("/list")
	void list(CoursePageTO page, Model model) throws ControllerException {
		log.trace("list({}, {}) invoked.", page, model);
		
		try {
			List<CourseDTO> list = this.service.getList(page);
			
			for (int i = 0; i<list.size(); i++) {
				list.get(i).setListVO(this.service.getTravelList(list.get(i)));
			} // for
			model.addAttribute("__LIST__", list);
			
			CoursePageDTO pageDTO = new CoursePageDTO(page, this.service.getTotal());
			model.addAttribute("pageMaker", pageDTO);
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // list
	
	// 2. 검색 후 게시판 목록 조회
	@GetMapping("/list?*")
	void search(CoursePageTO page, Model model) throws ControllerException {
		log.trace("list({}, {}) invoked.", page, model);
		
		try {
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
	
	
	
//	// 2. 새로운 게시물 등록
//	@PostMapping(path="/register", params= {"title", "content", "writer"})
//	String register(CourseDTO dto, RedirectAttributes rttrs) throws ControllerException {
//		log.trace("register({}, {}) invoked.", dto, rttrs);
//		
//		try {
//			Objects.requireNonNull(dto);
//			
//			if(this.service.register(dto)) {
//				rttrs.addAttribute("result", "true");
//				rttrs.addAttribute("bno", dto.getSeq());
//			} // if
//			
//			return "redirect:/board/course/list";
//		} catch(Exception e) {
//			throw new ControllerException(e);
//		} // try-catch
//	} // register
//	
//	@GetMapping(path="/register")
//	void register() {	// 단순 등록화면 요청
//		log.trace("register() invoked.");
//		
//	} // register
//	
//	
//	// 3. 특정 게시물 상세조회
//	@GetMapping(path={"/get", "/modify"}, params="seq")
//	void get(@RequestParam("seq") Integer seq, Model model) throws ControllerException {
//		log.trace("get() invoked.");
//		
//		try {
//			CourseVO vo = this.service.get(seq);
//			
//			model.addAttribute("__BOARD__", vo);
//		} catch(Exception e) {
//			throw new ControllerException(e);
//		} // try-catch
//	} // get
//	
//	
//	// 4. 특정 게시물 업데이트(UPDATE)
//	@PostMapping(path="/modify")
//	String modify(CourseDTO dto, RedirectAttributes rttrs) throws ControllerException {
//		log.trace("modify({}) invoked.", dto);
//		
//		try {
//			Objects.requireNonNull(dto);
//			
//			if(this.service.modify(dto)) {
//				rttrs.addAttribute("result", "true");
//				rttrs.addAttribute("bno", dto.getSeq());
//			} // if
//			
//			return "redirect:/board/course/list";
//		} catch(Exception e) {
//			throw new ControllerException(e);
//		} // try-catch
//	} // modify
//	
////	@GetMapping(path="/modify", params="bno")
////	void modify(Integer bno, Model model) {	// 단순 수정화면 요청
////		log.trace("modify() invoked.");
////		
////	} // modify		// get메소드로 이동함
//	
//	
//	// 5. 특정 게시물 삭제(DELETE)
//	@PostMapping(path="/remove")
//	String remove(@RequestParam("seq") Integer seq, RedirectAttributes rttrs) throws ControllerException {
//		log.trace("remove({}) invoked.", seq);
//		
//		try {
//			if(this.service.remove(seq)) {
//				rttrs.addAttribute("result", "true");
//				rttrs.addAttribute("seq", seq);
//			} // if
//			
//			return "redirect:/board/course/list";
//		} catch(Exception e) {
//			throw new ControllerException(e);
//		} // try-catch
//	} // remove
	
} // end class

package org.zerock.seoulive.board.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.seoulive.board.course.service.CourseService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/board/course")
@Controller

public class CourseController {
	
	@Setter(onMethod_= {@Autowired})
	private CourseService courseService;
	
	
	
}	// end class

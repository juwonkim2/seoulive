package org.zerock.seoulive.board.course.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.zerock.seoulive.board.course.domain.CourseDTO;
import org.zerock.seoulive.board.course.domain.CoursePageTO;
import org.zerock.seoulive.board.course.domain.CourseVO;
import org.zerock.seoulive.board.course.domain.CourseWriteDTO;
import org.zerock.seoulive.board.course.mapper.CourseMapper;
import org.zerock.seoulive.exception.ServiceException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

public class CourseServiceImpl 
	implements 
		CourseService,
		InitializingBean,
		DisposableBean{
	
	@Setter(onMethod_= {@Autowired})
	private CourseMapper mapper;
	
	// 코스게시판의 게시물들을 보여주는 서비스 메소드 
	@Override
	public List<CourseDTO> searchCourseBulletinsList(CoursePageTO page) throws ServiceException {
		System.out.println(this.toString());
		log.info("searchCourseBulletinsList({}) invoked.",page);
		List<CourseDTO> result = this.mapper.courseBulletinsList(page);
		log.info("List<CourseDTO> result : {}",result);
		return result;
	}	// end searchCourseBulletinsList;

	// 코스게시판의 특정 게시물을 읽어들리는 서비스 메소드 
	@Override
	public CourseVO getReadCourseBulletins(Integer seq) throws ServiceException {
		System.out.println(this.toString());
		log.info("getReadCourseButtetins({}) invoked.",seq);
		CourseVO result = this.mapper.readCourseBulletins(seq);
		log.info("CourseVO result : {}",result);
		return result;
	}	// end getReadCourseBulletins
	
	// 코스게시판의 게시물을 등록시키는 서비스 메소드 
	@Override
	public void registerInsertCourseBulletins(CourseWriteDTO dto) throws ServiceException {
		System.out.println(this.toString());
		log.info("registerInsertCourseButtetins({}) invoked.",dto);
		this.mapper.insertCourseBulletins(dto);
		log.info("{}의 registerInsertCoureBulletins operate",this.toString().getClass().getName());
	}	// end registerInsertCourseBulletins
	
	@Override
	public void afterPropertiesSet() throws Exception {
		log.trace("afterPropertiesSet() invoked.");
		Objects.requireNonNull(this.mapper);
		log.info("this.mapper : {}",this.mapper);
	}	//	afterPropertiesSet

	@Override
	public void destroy() throws Exception {
		log.trace("destroy() invoked.");
		
	}	// destroy

	

}

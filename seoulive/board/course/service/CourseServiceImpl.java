package org.zerock.seoulive.board.course.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.CoursePageTO;
import org.zerock.seoulive.board.course.domain.CourseTravelVO;
import org.zerock.seoulive.board.course.domain.CourseVO;
import org.zerock.seoulive.board.course.exception.ServiceException;
import org.zerock.seoulive.board.course.persistence.CourseDAO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service("courseService")
public class CourseServiceImpl 
	implements 
		CourseService,
		InitializingBean,
		DisposableBean {

	@Setter(onMethod_= {@Autowired})
	private CourseDAO dao;		// 영속성 계층의 DAO 빈 주입받음
	
	
	
	// 1. 게시판 목록을 얻어 반환해주는 기능 수행
	@Override
	public List<CourseVO> getList(CoursePageTO page) throws ServiceException {
		log.trace("getList() invoked.");
		
		try {
			return this.dao.courseList(page);
		} catch(Exception e){
			throw new ServiceException(e);
		} // try-catch
	} // getList

	// 2. 총 게시물 개수 반환
	@Override
	public Integer getTotal() throws ServiceException {
		log.trace("getTotal() invoked.");
		
		return this.dao.getTotalAmount();
	} // getTotal

	// 3. 코스게시물이 가지고 있는 여행지 목록 반환
	@Override
	public List<CourseTravelVO> getTravelList(CourseVO vo) throws ServiceException {
		log.trace("getTravelList() invoked.");
		
		return this.dao.selectTravelList(vo);
	}
		
	// 4. 검색 후 리스트 반환
	@Override
    public List<CourseVO> searchCourse(CoursePageTO page, String searchType, String keyword) {
        return dao.searchCourse(page.getCurrPage(), page.getAmount(), searchType, keyword);
    }
	
	// 5. 검색 후 게시물 개수 반환
	@Override
	public Integer getTotalSearch(String searchType, String keyword) throws ServiceException {
		log.trace("getTotal() invoked.");
		
		return this.dao.getTotalSearch(searchType, keyword);
	} // getTotal
	
	
//	@Override
//	public Boolean register(CourseDTO dto) throws ServiceException {
//		log.trace("register() invoked.");
//		
//		try {
//			return ( this.dao.insert(dto) == 1 );
//		} catch(Exception e){
//			throw new ServiceException(e);
//		} // try-catch
//	} // register
//
//	@Override
//	public CourseVO get(Integer bno) throws ServiceException {
//		log.trace("get() invoked.");
//		
//		try {
//			return this.dao.select(bno);
//		} catch(Exception e){
//			throw new ServiceException(e);
//		} // try-catch
//	} // get
//
//	@Override
//	public Boolean modify(CourseDTO dto) throws ServiceException {
//		log.trace("modify() invoked.");
//		
//		try {
//			return ( this.dao.update(dto) == 1 );
//		} catch(Exception e){
//			throw new ServiceException(e);
//		} // try-catch
//	} // modify	
//	
//	@Override
//	public Boolean remove(Integer bno) throws ServiceException {
//		log.trace("remove() invoked.");
//		
//		try {
//			return ( this.dao.delete(bno) == 1 );
//		} catch(Exception e){
//			throw new ServiceException(e);
//		} // try-catch
//	} // remove
	
	
	
	
//	=======================================================================
	
	@Override
	public void afterPropertiesSet() throws Exception { // 초기화(=전처리)
		log.trace("afterPropertiesSet() invoked.");
		
		Objects.requireNonNull(this.dao);
		log.info("\t this.dao: {}", this.dao);
	} // afterPropertiesSet
	
	@Override
	public void destroy() throws Exception {		// 자원해제(=후처리)
		log.trace("destroy() invoked.");
		
	} // destroy

} // end class

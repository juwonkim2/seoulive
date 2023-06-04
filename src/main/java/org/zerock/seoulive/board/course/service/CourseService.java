package org.zerock.seoulive.board.course.service;

import java.util.List;

import org.zerock.seoulive.board.course.domain.CourseDTO;
import org.zerock.seoulive.board.course.domain.CoursePageTO;
import org.zerock.seoulive.board.course.domain.CourseVO;
import org.zerock.seoulive.board.course.domain.CourseWriteDTO;
import org.zerock.seoulive.exception.ServiceException;

public interface CourseService {
	
	// 게시판 검색 목록
	public abstract List<CourseDTO> searchCourseBulletinsList(CoursePageTO page) throws ServiceException;
	
	// 코스 게시판의 특정 게시물을 읽어드림
	public abstract CourseVO getReadCourseBulletins(Integer seq) throws ServiceException;
	
	public abstract void registerInsertCourseBulletins(CourseWriteDTO dto) throws ServiceException;
}	// end interface

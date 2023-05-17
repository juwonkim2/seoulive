package org.zerock.seoulive.board.course.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.seoulive.board.course.domain.CourseDTO;
import org.zerock.seoulive.board.course.domain.CoursePageTO;
import org.zerock.seoulive.board.course.domain.CourseTravelVO;
import org.zerock.seoulive.board.course.domain.CourseVO;

public interface CourseDAO {
	
	// 1. 과연 게시판 목록조회, C/R/U/D에 필요한 메소드는 무엇일까?
	@Select("""
			SELECT *
			FROM tbl_course
			OFFSET ( #{currPage} - 1) * #{amount} ROW
			FETCH NEXT #{amount} ROWS ONLY
			""")
	public abstract List<CourseDTO> courseList(CoursePageTO page);
	
	// 2. 게시판 전체 목록 개수
	@Select("SELECT count(seq) FROM tbl_course WHERE seq > 0")
	public abstract int getTotalAmount();
	
	// 3. 게시물 당 가지고 있는 여행지 목록
	@Select("""
			SELECT ct.*, tt.CATEGORY, tt.TITLE, tt.CONTENT, tt.ADDRESS
			FROM TBL_COURSE_TRAVEL ct JOIN TBL_TRAVEL tt 
				ON ct.TRAVEL_SEQ = tt.seq
			WHERE BOARD_SEQ = ${seq}
			""")
	public abstract List<CourseTravelVO> selectTravelList(CourseDTO dto);
	
	@Select("""
			SELECT *
			FROM tbl_course 
			WHERE ${searchType} LIKE '%' || #{keyword} || '%'
			OFFSET ( #{currPage} - 1) * #{amount} ROW
			FETCH NEXT #{amount} ROWS ONLY
			""")
	public abstract List<CourseDTO> searchCourse(Integer currPage, Integer amount, String searchType, String keyword);
	
	@Select("""
			SELECT count(seq)
			FROM tbl_course 
			WHERE ${searchType} LIKE '%' || #{keyword} || '%'
			""")
	public abstract int getTotalSearch(String searchType, String keyword);
	
//	// n. 새로운 게시물 등록
//	public abstract Integer insert(CourseDTO dto);
//	
//	// n. 특정 게시물 상세조회
//	public abstract CourseVO select(Integer bno);
//	
//	// n. 특정 게시물 삭제
//	public abstract Integer delete(Integer bno);
//	
//	// n. 특정 게시물 업데이트(갱신)
//	public abstract Integer update(CourseDTO dto);
	

	

	
} // end interface

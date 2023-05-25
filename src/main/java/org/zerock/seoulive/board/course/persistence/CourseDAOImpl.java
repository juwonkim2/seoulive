//package org.zerock.seoulive.board.course.persistence;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.zerock.seoulive.board.course.domain.*;
//import org.zerock.seoulive.board.travel.domain.TravelDTO;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//
//@Log4j2
//@AllArgsConstructor
//
//@Repository("courseDAO")
//public class CourseDAOImpl implements CourseDAO {
//
//	@Autowired
//	private SqlSessionFactory sqlSession;
//
//	@Override
//	public List<CourseTravelVO> selectTravelList(CourseDTO dto) {
//
//		return null;
//	}
//
//	@Override
//	public List<CourseTravelVO> selectTravelList2(Integer seq) {
//		return null;
//	}
//
//	@Override
//	public List<CourseDTO> searchCourse(CoursePageTO page) {
//		return null;
//	}
//
//	@Override
//	public int getTotalSearch(String searchType, String keyword) {
//		return 0;
//	}
//
//	@Override
//	public void insertCourse(CourseWriteDTO dto) {
//
//	}
//
//	@Override
//	public void insertCourseTravel(CourseWriteVO vo) {
//
//	}
//
//	@Override
//	public List<TravelDTO> getTravelData(String keyword) {
//		return null;
//	}
//
//	@Override
//	public void courseLike(CourseLikeDTO dto) {
//
//	}
//
//	@Override
//	public CourseVO read(Integer seq) {
//		return null;
//	}
//
//
//	@Override
//	public List<CourseCommVO> commList(Integer seq) {
//		return null;
//	}
//
//	@Override
//	public void commRegister(String content, Integer seq) {
//
//	}
//} // end class

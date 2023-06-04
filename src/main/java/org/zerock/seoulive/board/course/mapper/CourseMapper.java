package org.zerock.seoulive.board.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.zerock.seoulive.board.course.domain.CourseDTO;
import org.zerock.seoulive.board.course.domain.CoursePageTO;
import org.zerock.seoulive.board.course.domain.CourseVO;
import org.zerock.seoulive.board.course.domain.CourseWriteDTO;

public interface CourseMapper {
	
	// 1 코스 검색 결과 리스트 
	@Select("SELECT *"
			+ "FROM tbl_course"
			+ "WHERE ${searchType} LIKE '%' || #{keyword} || '%'"
			+ "ORDER BY seq DESC"
			+ "OFFSET ( #{currPage} -1 ) * #{amount} ROW FETCH NEXT"
			+ "#{amount} ROWS ONLY")
	public abstract List<CourseDTO> courseBulletinsList(CoursePageTO page);
	
	// 특정 코스 게시물 상세조회 
	@Select("""
			SELECT * FROM tbl_course WHERE seq = #{seq}
			""")
	public abstract CourseVO readCourseBulletins(Integer seq);
	
	@Insert("""
			INSERT INTO tbl_course 
				(writer,title,review,duration_start,duration_end)
			VALUES
				(#{writer},#{title},#{review},#{durationStart},#{durationEnd})
			""")
	public abstract void insertCourseBulletins(CourseWriteDTO dto);
}	// end class

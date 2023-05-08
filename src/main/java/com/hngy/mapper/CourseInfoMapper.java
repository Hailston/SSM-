package com.hngy.mapper;



import com.hngy.model.CourseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CourseInfoMapper {
	/*添加课程信息信息*/
	void addCourseInfo(CourseInfo courseInfo) throws Exception;

	/*按照查询条件分页查询课程信息记录*/
	List<CourseInfo> queryCourseInfo(@Param("where") String where, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize) throws Exception;

	/*按照查询条件查询所有课程信息记录*/
	List<CourseInfo> queryCourseInfoList(@Param("where") String where) throws Exception;

	/*按照查询条件的课程信息记录数*/
	int queryCourseInfoCount(@Param("where") String where) throws Exception; 

	/*根据主键查询某条课程信息记录*/
	CourseInfo getCourseInfo(String courseNumber) throws Exception;

	/*更新课程信息记录*/
	void updateCourseInfo(CourseInfo courseInfo) throws Exception;

	/*删除课程信息记录*/
	void deleteCourseInfo(String courseNumber) throws Exception;

}

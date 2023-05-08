package com.hngy.mapper;



import com.hngy.model.StudentSelectCourseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StudentSelectCourseInfoMapper {
	/*添加选课信息信息*/
	void addStudentSelectCourseInfo(StudentSelectCourseInfo studentSelectCourseInfo) throws Exception;

	/*按照查询条件分页查询选课信息记录*/
	List<StudentSelectCourseInfo> queryStudentSelectCourseInfo(@Param("where") String where, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize) throws Exception;

	/*按照查询条件查询所有选课信息记录*/
	List<StudentSelectCourseInfo> queryStudentSelectCourseInfoList(@Param("where") String where) throws Exception;

	/*按照查询条件的选课信息记录数*/
	int queryStudentSelectCourseInfoCount(@Param("where") String where) throws Exception; 

	/*根据主键查询某条选课信息记录*/
	StudentSelectCourseInfo getStudentSelectCourseInfo(int selectId) throws Exception;

	/*更新选课信息记录*/
	void updateStudentSelectCourseInfo(StudentSelectCourseInfo studentSelectCourseInfo) throws Exception;

	/*删除选课信息记录*/
	void deleteStudentSelectCourseInfo(int selectId) throws Exception;

}

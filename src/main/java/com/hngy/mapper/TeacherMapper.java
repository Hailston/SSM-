package com.hngy.mapper;



import com.hngy.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TeacherMapper {
	/*添加教师信息信息*/
	void addTeacher(Teacher teacher);

	/*按照查询条件分页查询教师信息记录*/
	List<Teacher> queryTeacher(@Param("where") String where, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize) throws Exception;

	/*按照查询条件查询所有教师信息记录*/
	List<Teacher> queryTeacherList(@Param("where") String where) throws Exception;

	/*按照查询条件的教师信息记录数*/
	int queryTeacherCount(@Param("where") String where) throws Exception; 

	/*根据主键查询某条教师信息记录*/
	Teacher getTeacher(String teacherNumber) throws Exception;

	/*更新教师信息记录*/
	void updateTeacher(Teacher teacher) throws Exception;

	/*删除教师信息记录*/
	void deleteTeacher(String teacherNumber) throws Exception;

}

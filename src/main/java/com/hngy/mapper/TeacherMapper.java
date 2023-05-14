package com.hngy.mapper;



import com.hngy.listener.TeacherData;
import com.hngy.model.Classes;
import com.hngy.model.StudentClasses;
import com.hngy.model.Teacher;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface TeacherMapper {
	/*添加教师信息信息*/
	void addTeacher(Teacher teacher);

	/*查询所有教师信息记录*/
	List<Teacher> listAll();
	Teacher selectOneByTno(@Param("tno") String tno);

	/*按照查询条件查询所有教师信息记录*/
	List<Teacher> queryTeacherList(@Param("where") String where) throws Exception;

	/*按照查询条件的教师信息记录数*/
	int queryTeacherCount(@Param("where") String where) throws Exception; 

	/*根据主键查询某条教师信息记录*/
	Teacher getTeacher(String teacherNumber) throws Exception;

	/*更新教师信息记录*/
	int updateTeacher(Teacher teacher);

	/*删除教师信息记录*/
	void deleteTeacher(String teacherNumber) throws Exception;

    void insertBatch(@Param("teachers") List<TeacherData> teachers);

    int changePassword(@Param("tno") String tno,@Param("oldPassword") String oldPassword,@Param("newPassword") String newPassword);

    List<Classes> selectCourseByCtype(@Param("tno") String tno,@Param("ctype") int ctype);


	List<StudentClasses> selectRequireCourseStudent(@Param("courseId") Integer courseId);

	int updateBatchScore(@Param("scores") List<StudentClasses> scores);
}

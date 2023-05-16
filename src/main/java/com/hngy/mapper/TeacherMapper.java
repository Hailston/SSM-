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

	void addTeacher(Teacher teacher);

	List<Teacher> listAll();

	Teacher selectOneByTno(@Param("tno") String tno);

    void insertBatch(@Param("teachers") List<TeacherData> teachers);

    int changePassword(@Param("tno") String tno,@Param("oldPassword") String oldPassword,@Param("newPassword") String newPassword);

    List<Classes> selectCourseByCtype(@Param("tno") String tno,@Param("ctype") int ctype);

	List<StudentClasses> selectRequireCourseStudent(@Param("courseId") Integer courseId);

	int updateBatchScore(@Param("scores") List<StudentClasses> scores);
}

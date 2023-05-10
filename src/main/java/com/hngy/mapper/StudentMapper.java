package com.hngy.mapper;


import java.util.List;

import com.hngy.listener.StudentData;
import com.hngy.model.Student;
import org.apache.ibatis.annotations.Param;


public interface StudentMapper {
	/*添加学生信息信息*/
	void addStudent(Student student);

	/*按照查询条件分页查询学生信息记录*/
	List<Student> listAll();

	/*按照查询条件查询所有学生信息记录*/
	List<Student> queryStudentList(@Param("where") String where) throws Exception;

	/*按照查询条件的学生信息记录数*/
	int queryStudentCount(@Param("where") String where) throws Exception; 

	/*根据主键查询某条学生信息记录*/
	Student getStudent(String studentNumber) throws Exception;

	/*更新学生信息记录*/
	void updateStudent(Student student) throws Exception;

	/*删除学生信息记录*/
	void deleteStudent(String studentNumber) throws Exception;
	int insertBatch(@Param("students") List<StudentData> studentData);
}

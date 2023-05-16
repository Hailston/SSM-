package com.hngy.mapper;


import java.util.List;

import com.hngy.listener.StudentData;
import com.hngy.model.Student;
import com.hngy.model.StudentCourseInfo;
import com.hngy.model.StudentElectiveCourse;
import org.apache.ibatis.annotations.Param;


public interface StudentMapper {

    void addStudent(Student student);


    List<Student> listAll();


    Student getStudent(@Param("sno") String sno);

    void updateStudent(Student student) throws Exception;

    int insertBatch(@Param("students") List<StudentData> studentData);

    int changePassword(@Param("sno") String sno, @Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword);

    List<StudentCourseInfo> getStudentCourse(@Param("sno") String sno, @Param("cname") String cname, @Param("ctype") Integer ctype);

    List<StudentElectiveCourse> getElectiveCourse(@Param("sno") String sno);

    int insertStudentClasses(@Param("sno") String sno,@Param("courseId") Integer courseId);
}

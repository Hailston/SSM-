package com.hngy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ClassInfoMapper {
	/*添加班级信息信息*/
	void addClassInfo(ClassInfo classInfo) throws Exception;

	/*按照查询条件分页查询班级信息记录*/
	List<ClassInfo> queryClassInfo(@Param("where") String where, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize) throws Exception;

	/*按照查询条件查询所有班级信息记录*/
	List<ClassInfo> queryClassInfoList(@Param("where") String where) throws Exception;

	/*按照查询条件的班级信息记录数*/
	int queryClassInfoCount(@Param("where") String where) throws Exception; 

	/*根据主键查询某条班级信息记录*/
	ClassInfo getClassInfo(String classNumber) throws Exception;

	/*更新班级信息记录*/
	void updateClassInfo(ClassInfo classInfo) throws Exception;

	/*删除班级信息记录*/
	void deleteClassInfo(String classNumber) throws Exception;

}

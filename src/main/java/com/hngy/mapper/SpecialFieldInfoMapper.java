package com.hngy.mapper;


import com.hngy.model.SpecialFieldInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialFieldInfoMapper {
	/*添加专业信息信息*/
	void addSpecialFieldInfo(SpecialFieldInfo specialFieldInfo) throws Exception;

	/*按照查询条件分页查询专业信息记录*/
	List<SpecialFieldInfo> querySpecialFieldInfo(@Param("where") String where, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize) throws Exception;

	/*按照查询条件查询所有专业信息记录*/
	List<SpecialFieldInfo> querySpecialFieldInfoList(@Param("where") String where) throws Exception;

	/*按照查询条件的专业信息记录数*/
	int querySpecialFieldInfoCount(@Param("where") String where) throws Exception; 

	/*根据主键查询某条专业信息记录*/
	SpecialFieldInfo getSpecialFieldInfo(String specialFieldNumber) throws Exception;

	/*更新专业信息记录*/
	void updateSpecialFieldInfo(SpecialFieldInfo specialFieldInfo) throws Exception;

	/*删除专业信息记录*/
	void deleteSpecialFieldInfo(String specialFieldNumber) throws Exception;

}

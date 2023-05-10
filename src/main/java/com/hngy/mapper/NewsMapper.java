package com.hngy.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface NewsMapper {
	/*添加新闻信息信息*/
	void addNews(News news) throws Exception;

	/*按照查询条件分页查询新闻信息记录*/
	List<News> queryNews(@Param("where") String where, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize) throws Exception;

	/*按照查询条件查询所有新闻信息记录*/
	List<News> queryNewsList(@Param("where") String where) throws Exception;

	/*按照查询条件的新闻信息记录数*/
	int queryNewsCount(@Param("where") String where) throws Exception; 

	/*根据主键查询某条新闻信息记录*/
	News getNews(int newsId) throws Exception;

	/*更新新闻信息记录*/
	void updateNews(News news) throws Exception;

	/*删除新闻信息记录*/
	void deleteNews(int newsId) throws Exception;

}

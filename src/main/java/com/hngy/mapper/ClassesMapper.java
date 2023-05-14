package com.hngy.mapper;

import com.hngy.model.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @name: ClassesMapper
 * @author: liuwenxuan
 * @date: 2023-05-11 09:40
 **/
public interface ClassesMapper {
    int addClasses(Classes classes);

    void insertBatch(@Param("classes") List<Classes> cachedDataList);

    List<Classes> listAll();

    int countStudent(@Param("courseId") Integer courseId);
}

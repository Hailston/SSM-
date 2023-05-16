package com.hngy.model;

import lombok.Data;

/**
 * @name: StudentElectiveCourse
 * @author: 杨定康
 * @date: 2023-05-15 17:33
 **/
@Data
public class StudentElectiveCourse {
    private Integer id;
    private String cname;
    private String tname;
    private String cmark;
    private Integer chooseMax;
    private Integer chooseCurNum;
}

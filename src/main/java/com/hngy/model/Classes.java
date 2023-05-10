package com.hngy.model;

import lombok.Data;

/**
 * @name: Classes
 * @author: liuwenxuan
 * @date: 2023-05-10 22:07
 **/
@Data
public class Classes {
    private Integer id;
    private Integer teacherId;
    private Integer chooseMax;
    private Integer chooseCurNu;
    private String room;
    private String courTime;
    private String cmark;
    private String cname;
}

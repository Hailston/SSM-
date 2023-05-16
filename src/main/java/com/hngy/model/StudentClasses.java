package com.hngy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @name: StudentClasses
 * @author: 杨定康
 * @date: 2023-05-10 22:09
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentClasses {
    private String sno;
    private String username;
    private Integer csId;
    private Integer cscore;
}

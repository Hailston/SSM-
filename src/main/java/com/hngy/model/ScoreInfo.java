package com.hngy.model;

import lombok.Data;

/**
 * @name ScoreInfo
 * @Author 伍允文
 * @Date 2023/5/8
 **/
@Data
public class ScoreInfo {
    private Integer scoreId;
    private String studentNumber;
    private String courseNumber;
    private Float scoreValue;
    private String  studentEvaluate;
}

package com.hngy.model;

import lombok.Data;

/**
 * @name News
 * @Author 伍允文
 * @Date 2023/5/8
 **/
@Data
public class News {
    private Integer newsId;
    private String newsTitle;
    private String newsContent;
    private String newsDate;
    private String newsPhoto;
}

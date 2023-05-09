package com.hngy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @name: ResultVO
 * @author: liuwenxuan
 * @date: 2023-05-09 22:52
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
    private Boolean success;

    public ResultVO(Integer code, String msg, Boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }
    public static ResultVO<?> ok(String msg){
        return new ResultVO<>(HttpStatus.OK.value(), msg,true);
    }
}

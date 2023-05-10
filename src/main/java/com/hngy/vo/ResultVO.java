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
    private String message;
    private T data;
    private Boolean success;

    public ResultVO(Integer code, String message, Boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }
    public static ResultVO<?> ok(String message){
        return new ResultVO<>(HttpStatus.OK.value(), message,true);
    }
}

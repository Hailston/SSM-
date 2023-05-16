package com.hngy.handle;

import com.hngy.exception.AdminException;
import com.hngy.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @name: AdminExceptionHandler
 * @author: liuwenxuan
 * @date: 2023-05-16 16:01
 **/
@RestControllerAdvice
public class AdminExceptionHandler {
    @ExceptionHandler(value = {AdminException.class})
    public ResultVO<?> handleAdminException(RuntimeException e){
        return new ResultVO<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), false);
    }
}

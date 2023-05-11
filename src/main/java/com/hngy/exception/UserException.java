package com.hngy.exception;

/**
 * @name: UserException
 * @author: liuwenxuan
 * @date: 2023-05-11 23:07
 **/
public class UserException extends RuntimeException{
    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }
}

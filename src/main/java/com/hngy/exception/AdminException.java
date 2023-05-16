package com.hngy.exception;

/**
 * @name: AdminException
 * @author: liuwenxuan
 * @date: 2023-05-16 16:02
 **/
public class AdminException extends RuntimeException{
    public AdminException() {
        super();
    }

    public AdminException(String message) {
        super(message);
    }
}

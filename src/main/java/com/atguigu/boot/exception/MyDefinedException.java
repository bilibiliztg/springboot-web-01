package com.atguigu.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN,reason = "用户数量太多")
public class MyDefinedException extends RuntimeException{

    public MyDefinedException() {
    }

    public MyDefinedException(String message) {
        super(message);
    }
}

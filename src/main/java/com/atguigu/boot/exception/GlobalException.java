package com.atguigu.boot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String myResolveException(Exception ex){
        log.info("自定义异常处理器执行。。。{}",ex);
        return  "login";
    }
}

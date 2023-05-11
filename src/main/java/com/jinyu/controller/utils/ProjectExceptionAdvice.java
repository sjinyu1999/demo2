package com.jinyu.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 作为 springmvc 的全局异常处理类
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 拦截所有异常信息
    @ExceptionHandler(Exception.class)
    public R doException(Exception e){
//        记录日志
//        通知运维
//        通知开发
        e.printStackTrace();
        return new R("服务器异常，请联系管理员！！！");
    }
}

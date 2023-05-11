package com.jinyu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseClass {
//    public static final Logger log = LoggerFactory.getLogger(BookController.class);
    private Class clazz;
    public static Logger log;
    public BaseClass() {
        clazz = this.getClass();
        log = LoggerFactory.getLogger(clazz);
    }
}

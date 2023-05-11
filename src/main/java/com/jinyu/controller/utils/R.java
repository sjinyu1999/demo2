package com.jinyu.controller.utils;

import com.jinyu.mybatisplus.entity.Book;
import lombok.Data;
@Data
public class R {
    private String code;
    private String msg;
    private Object data;

    public R() {
        this.code = "200";
        this.msg = "success";
    }
    public R(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public R(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public R(String msg) {
        this.code = "500";
        this.msg = msg;
    }

    public static R ok() {
        R r = new R();
        r.setData(null);
        r.setCode("200");
        r.setMsg("success");
        return r;
    }

    public R data(String book, Book book1) {
        R r = new R();
        r.setData(book1);
        r.setCode("200");
        r.setMsg("success");
        return r;
    }
}

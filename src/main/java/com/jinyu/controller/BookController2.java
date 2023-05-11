package com.jinyu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

// 表现层
//@RestController // @RestController = @Controller + @ResponseBody 用于返回json数据
@RequestMapping("/books")
public class BookController2 {
    @Value("${dataSource.password}")
    private String password;
    @GetMapping
    public List<Book> getAll() {
        System.out.println("password:"+password);
        System.out.println("1111111111111111111");

        return null ;
    }

    @PostMapping
    public boolean save(@RequestBody Book book) { // @RequestBody 用于接收前端传递的json数据
        if(book != null) {
            return true;
        }
        return false;
    }

    @PutMapping
    public boolean update(@RequestBody Book book) {
        System.out.println("修改成功！！！！");
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return true;
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id) { // @PathVariable 用于从url中获取参数 /books/1
        System.out.println("查询对应的id");
        return null;
    }

    @GetMapping("{current}/{size}")
    public IPage<Book> getPage(@PathVariable Integer current, @PathVariable Integer size) {
        return null;
    }
    /*@GetMapping("/books/params")
    public List<Book> getBookByParams(@RequestBody Book book) {
        System.out.println("params = " + book);
        return null;
    }*/
}

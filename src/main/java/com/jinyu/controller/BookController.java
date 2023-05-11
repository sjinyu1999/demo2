package com.jinyu.controller;

import com.jinyu.controller.utils.R;
import com.jinyu.mybatisplus.entity.Book;
import com.jinyu.mybatisplus.mapper.BookMapper;
import com.jinyu.mybatisplus.service.IBookService;
import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger; // 日志
//import org.slf4j.LoggerFactory; // 日志
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// 日志 用于记录日志
@Slf4j
// 表现层
@RestController
@RequestMapping("/books")
// 法一： 搭配 BaseClass 使用
//public class BookController extends BaseClass{
// 法二： 直接使用 log @Slf4j
public class BookController {
//    创建记录日志的对象
//    private static final Logger log = LoggerFactory.getLogger(BookController.class);
//@Value("${dataSource.password}")
//private String password;
@Autowired
private BookMapper bookMapper;
@Autowired
private IBookService bookService;
    @GetMapping
    public List<Book> getAll() {
//        System.out.println("password:"+password);
        System.out.println("hello111");
        System.out.println("hello222");
        log.info("查询所有图书1111");
        log.warn("警告");
        log.debug("调试");
        log.error("错误");
        return bookMapper.selectAll() ;
    }

    @PostMapping
//    public R save(@RequestBody Book book) throws IOException { // @RequestBody 用于接收前端传递的json数据
    public R save(@RequestBody Book book) {
        R r = new R();
        return bookService.saveBook(book);
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        R r = new R();
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        R r = new R();
        return bookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) { // @PathVariable 用于从url中获取参数 /books/1
        R r = new R();
        System.out.println("查询对应的id");
        return bookService.getBookById(id);
    }

    @GetMapping("{current}/{size}")
    public R getPage(@PathVariable Integer current, @PathVariable Integer size) {
        R r = new R();
        System.out.println("分页查询");
//        System.out.println("password:"+password);
        return bookService.getPage(current, size);
    }

    @GetMapping("/params")
//    @RequestBody 用于接收前端传递的json数据 用于表示前端传递的json数据的格式
    public R getBookByParams(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "total", required = false) Integer total,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "description", required = false) String description) {
//        根据 type name description 查询 查询后的结果进行分页
//        IPage<Book> page
//        System.out.println("password:"+password);
        return bookService.selectPageByParams(type,name,description,currentPage, pageSize);

    }
}

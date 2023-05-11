package com.jinyu.mybatisplus.service;

import com.jinyu.controller.utils.R;
import com.jinyu.mybatisplus.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jinyu
 * @since 2023-03-07
 */
public interface IBookService extends IService<Book> {
    public R selectPageByParams(String type, String name, String description, Integer currentPage, Integer pageSize);

//    save
    public R saveBook(Book book);
//    update
    public R updateBook(Book book);
//    delete
    public R deleteBook(Integer id);
//    getById
    public R getBookById(Integer id);
//    getPage
    public R getPage(Integer currentPage, Integer pageSize);

}

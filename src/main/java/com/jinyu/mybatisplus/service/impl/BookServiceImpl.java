package com.jinyu.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jinyu.controller.utils.R;
import com.jinyu.mybatisplus.entity.Book;
import com.jinyu.mybatisplus.mapper.BookMapper;
import com.jinyu.mybatisplus.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jinyu
 * @since 2023-03-07
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Transactional
       /* @Override
        public R selectPageByParams(Integer currentPage, Integer pageSize) {
            IPage<Book> page = new Page<>(currentPage, pageSize);
            QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
            IPage<Book> bookIPage = baseMapper.selectPage(page, queryWrapper);
            List<Book> records = bookIPage.getRecords();
//            拿到total
            long total = bookIPage.getTotal();
            Map map = new HashMap();
            map.put("total", total);
            map.put("records", records);
                    R r = new R();
            r.setData(map);
            r.setCode("200");
            r.setMsg("success");
            return r;
        }*/

    @Override
    public R selectPageByParams(String type, String name, String description, Integer currentPage, Integer pageSize) {
        IPage<Book> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        if (type != null && !"".equals(type)) {
            queryWrapper.like("type", type);
        }
        if (name != null && !"".equals(name)) {
            queryWrapper.like("name", name);
        }
        if (description != null && !"".equals(description)) {
            queryWrapper.like("description", description);
        }
        IPage<Book> bookIPage = baseMapper.selectPage(page, queryWrapper);
        List<Book> records = bookIPage.getRecords();
//            拿到total
        long total = bookIPage.getTotal();
        Map map = new HashMap();
        map.put("total", total);
        map.put("records", records);
        R r = new R();
        r.setData(map);
        r.setCode("200");
        r.setMsg("success");
        return r;
    }

    @Override
    public R saveBook(Book book) {
        baseMapper.insert(book); // 保存
        return R.ok();
    }

    @Override
    public R updateBook(Book book) {
//        baseMapper.updateById(book);
        baseMapper.update(book, new QueryWrapper<Book>().eq("id", book.getId()));
        return R.ok();
    }

    @Override
    public R deleteBook(Integer id) {
        baseMapper.deleteById(id);
        return R.ok();
    }

    @Override
    public R getBookById(Integer id) {
        Book book = baseMapper.selectById(id);
        return R.ok().data("book", book);
    }

    @Override
    public R getPage(Integer currentPage, Integer pageSize) {
        IPage<Book> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>(); // 条件构造器
        IPage<Book> bookIPage = baseMapper.selectPage(page, queryWrapper); // 分页查询
        List<Book> records = bookIPage.getRecords(); // 拿到数据
//            拿到total
        long total = bookIPage.getTotal();
        Map map = new HashMap();
        map.put("total", total);
        map.put("records", records);
        R r = new R();
        r.setData(map);
        r.setCode("200");
        r.setMsg("success");
        return r;
    }
}

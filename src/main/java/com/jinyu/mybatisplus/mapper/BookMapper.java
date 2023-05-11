package com.jinyu.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jinyu.mybatisplus.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jinyu
 * @since 2023-03-07
 */
@Component
public interface BookMapper extends BaseMapper<Book> {
    @Select("select * from sys_book ")
    List<Book> selectAll();


}

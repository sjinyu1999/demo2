package com.jinyu.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 用于配置 mybatis-plus 的分页插件 在 MyBatisPlus 的常规操作基础上增强了分页功能，内部是动态的拼接 SQL 语句，
// 因此需要增强对应的功能，使用 MyBatisPlus 拦截器实现
@Configuration
public class MPConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
//        1. 定义Mp拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        2. 添加具体的拦截器 用于实现分页功能
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}

package com.jinyu;

import com.alibaba.druid.pool.DruidDataSource;
import com.jinyu.config.ServerConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@MapperScan("com.jinyu.mybatisplus.mapper")
@EnableConfigurationProperties(ServerConfig.class)
public class Demo2Application {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver123");
        return ds;
    }
    public static void main(String[] args) {

        System.setProperty("spring.devtools.restart.enabled", "false");
//        System.out.println(Arrays.toString(args));
        // 用于启动 springboot 项目 传入的参数会被 springboot 框架接收
        /*String[] args2 = new String[1];
        args2[0] = "--server.port=8081"
        SpringApplication.run(Demo2Application.class, args2); */
//        可以在启动 boot 程序时断开读取外部临时配置对应的入口，也就是去掉读取外部参数的形参
//        SpringApplication.run(Demo2Application.class, args); // args: 传入的参数
        ConfigurableApplicationContext ctx = SpringApplication.run(Demo2Application.class, args);
//        通过 bean 的类型获取 bean
        ServerConfig bean = ctx.getBean(ServerConfig.class);
        System.out.println(bean);
        // 通过 bean 的名字获取 bean
        DruidDataSource ds = ctx.getBean(DruidDataSource.class);
        System.out.println(ds);
        System.out.println(ds.getDriverClassName());

//        不携带参数启动
//        SpringApplication.run(Demo2Application.class);
    }

}

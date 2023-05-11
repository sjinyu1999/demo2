//package com.jinyu.util;
//
//import com.baomidou.mybatisplus.generator.FastAutoGenerator;
//import com.baomidou.mybatisplus.generator.config.OutputFile;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//import java.util.Collections;
//
//public class MybatisPlusGen {
//    public  static void main(String[] args) {
//        FastAutoGenerator.create("jdbc:mysql://localhost:7406/sys?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8", "root", "123456")
//                .globalConfig(builder -> {
//                    builder.author("jinyu") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
//                            .outputDir("D://idea//demo2//src/main//java"); // 指定输出目录
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.jinyu.mybatisplus") // 设置父包名
//                            .moduleName("") // 设置父包模块名
//                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://idea//demo2//src/main//resources//mapper")); // 设置mapperXml生成路径
//                })
//                .strategyConfig(builder -> {
//                    builder.addInclude("sys_book","sys_config","sys_user") // 设置需要生成的表名
//                            .addTablePrefix("sys_"); // 设置过滤表前缀
//                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                .execute();
//    }
//}

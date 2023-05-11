package com.jinyu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
// properties 属性可以为当前测试用例添加临时的属性配置
//@SpringBootTest(properties = {"test.prop=123"})
//args 属性可以为当前测试用例添加临时的命令行参数
//@SpringBootTest(args={"--test.prop=456"})
// 若 properties 和 args 同时存在，则 args 会覆盖 properties
@SpringBootTest(args={"--test.prop=456"}, properties = {"test.prop=123"})
//@SpringBootTest
public class Demo2ApplicationTest {
    @Value("${test.prop}")
    private String testProp;
    @Test
    void contextLoads() {
        System.out.println(testProp);
    }

}

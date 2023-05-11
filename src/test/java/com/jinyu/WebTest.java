package com.jinyu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

// 用于测试 web 层的代码 会启动整个 SpringBoot 项目 但是不会启动服务器
//SpringBootTest(webEnvironment.WebEnvironment.NONE  是指不启动服务器
//SpringBootTest(webEnvironment.WebEnvironment.RANDOM_PORT  是指随机启动一个端口的服务器
//SpringBootTest(webEnvironment.WebEnvironment.DEFINED_PORT  是指启动一个指定端口的服务器
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc // 开启虚拟 MVC 调用
public class WebTest {
    @Test
    void contextLoads() {
        System.out.println("web test");
//        模拟调用 MVC 接口
    }
    @Test
    void testMockMvc(@Autowired MockMvc mvc) throws Exception {
//        模拟调用 MVC 接口
//        http://localhost:8092/test/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions actions = mvc.perform(builder);

//        设定预期值 与真实值进行比较，成功测试通过，失败测试不通过
//        定义本次调用的预期结果
        StatusResultMatchers status = MockMvcResultMatchers.status();
//        预计本次调用时成功的：状态码为 200
        ResultMatcher ok = status.isOk();
//        添加预计值到本次调用中
        actions.andExpect(ok);
    }
}

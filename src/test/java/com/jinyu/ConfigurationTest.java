package com.jinyu;

import com.jinyu.config.MsgConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
// 用了 @Import 注解之后，SpringBoot 就不会去扫描 @Component 注解了 但是 @Configuration 注解除外
@Import(MsgConfig.class) // 导入配置类 MsgConfig
public class ConfigurationTest {
    @Autowired
    private String msg;
    @Test
    void contextLoads() {
        System.out.println(msg);
    }
}

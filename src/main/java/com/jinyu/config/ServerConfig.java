package com.jinyu.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.util.unit.DataSize;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

// @EnableConfigurationProperties 用于启用配置文件的读取 也就是说这个类是用来读取配置文件的
// @Component 用于将这个类交给 spring 管理 也就是说这个类是一个 bean
// @EnableConfigurationProperties 会自动将这个类交给 spring 管理 所以不需要再加 @Component
//@Component
@Data
@ConfigurationProperties(prefix = "server") // 宽松绑定 不支持注解@Value引用单个属性的方式
// 开启对当前 bean 的属性注入校验
@Validated
public class ServerConfig {
    private String ipAddress;
    //    设置端口号的范围
//    @NotEmpty(message = "端口号不能为空")
    @Max(value = 8923, message = "端口号不能大于 8923")
    @Min(value = 0, message = "端口号不能小于0")
    private int port;
    private long timeout;
    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeOut;
    //    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
}

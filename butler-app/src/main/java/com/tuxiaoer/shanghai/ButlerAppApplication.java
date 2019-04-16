package com.tuxiaoer.shanghai;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/9 17:44
 * @description：前端接口
 */
@EnableDubbo
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ButlerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ButlerAppApplication.class, args);
    }

}

package com.tuxiaoer.shanghai;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/4 16:59
 * @description：Server服务
 */
@EnableDubbo
@SpringBootApplication
public class ButlerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ButlerServerApplication.class, args);
    }
}

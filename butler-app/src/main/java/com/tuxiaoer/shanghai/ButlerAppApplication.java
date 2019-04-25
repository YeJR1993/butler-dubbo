package com.tuxiaoer.shanghai;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.tuxiaoer.shanghai.common.utils.AnnotationBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/9 17:44
 * @description：前端接口
 */
@EnableDubbo
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(nameGenerator = AnnotationBeanNameGenerator.class)
public class ButlerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ButlerAppApplication.class, args);
    }

}

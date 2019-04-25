package com.tuxiaoer.shanghai.common.versioning;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/25 9:34
 * @description：版本注解
 */
@Mapping
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface ApiVersion {

    /**
     * 标识版本号
     * @return
     */
    int value();
}

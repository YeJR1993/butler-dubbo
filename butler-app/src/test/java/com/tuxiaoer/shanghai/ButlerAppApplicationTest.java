package com.tuxiaoer.shanghai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/25 15:30
 * @description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ButlerAppApplicationTest {

    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)/");

    @Test
    public void test () {
        String s = "/v1/system/user/1";
        Matcher matcher = VERSION_PREFIX_PATTERN.matcher(s);
        System.out.println(matcher.find());
    }
}

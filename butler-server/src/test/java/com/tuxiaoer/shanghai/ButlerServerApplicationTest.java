package com.tuxiaoer.shanghai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/9 14:06
 * @description：测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ButlerServerApplicationTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test() {
    }

}

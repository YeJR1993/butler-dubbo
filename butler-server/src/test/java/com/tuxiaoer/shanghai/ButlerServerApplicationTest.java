package com.tuxiaoer.shanghai;

import com.tuxiaoer.shanghai.common.utils.MongoUtil;
import com.tuxiaoer.shanghai.modules.system.dao.UserDao;
import com.tuxiaoer.shanghai.modules.system.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
    private UserDao userDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test() {
        List<User> list = userDao.getUserList(new User());
        List<String> names = MongoUtil.saveBigDataForCollection("1",list, mongoTemplate, "userList");
    }

    @Test
    public void test1() {
        List<User> users = mongoTemplate.findAll(User.class, "userList0");
        System.out.println(users.get(0));
    }

    @Test
    public void test2() {
        mongoTemplate.dropCollection("userList1");
    }



}

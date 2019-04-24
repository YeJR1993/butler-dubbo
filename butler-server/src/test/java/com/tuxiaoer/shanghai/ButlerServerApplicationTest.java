package com.tuxiaoer.shanghai;

import com.tuxiaoer.shanghai.modules.system.dao.UserDao;
import com.tuxiaoer.shanghai.modules.system.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        User user = userDao.getUserByName(new User("admin"));
        mongoTemplate.save(user, "user-admin");
        System.out.println(user);
    }

    @Test
    public void test1() {
        userDao.getUserList(new User());
    }

    @Test
    public void test2() {
        Query query = new Query();
        User user = mongoTemplate.findOne(query, User.class, "user-admin");
        System.out.println(user);
    }

    @Test
    public void test3() {
        Query query = new Query(Criteria.where("username").is("admin"));
        mongoTemplate.remove(query, User.class, "user-admin");
    }

}

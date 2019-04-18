package com.tuxiaoer.shanghai.modules.system.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.tuxiaoer.shanghai.modules.common.utils.PageInfo;
import com.tuxiaoer.shanghai.modules.system.dao.UserDao;
import com.tuxiaoer.shanghai.modules.system.entity.User;
import com.tuxiaoer.shanghai.modules.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/4 17:44
 * @description：系统用户服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUserId(User user) {
        return userDao.getUserById(user);
    }

    @Override
    public User getUserByName(User user) {
        return userDao.getUserByName(user);
    }

    @Override
    public List<User> getUserList(User user) {
        return userDao.getUserList(user);
    }

    @Override
    public PageInfo<User> getUserListByPage(User user, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(userDao.getUserList(user));
    }

    @Override
    public Integer insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public Integer upUserByUserId(User user) {
        return userDao.upUserById(user);
    }

    @Override
    public Integer delUserByUserId(User user) {
        return  userDao.delUserById(user);
    }

    @Override
    public Integer delUserRoleByUserId(User user) {
        return userDao.delUserRoleById(user);
    }

    @Override
    public Integer insertUserRole(User user) {
        return userDao.insertUserRole(user);
    }

}

package com.tuxiaoer.shanghai.modules.system.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tuxiaoer.shanghai.modules.common.utils.PageInfo;
import com.tuxiaoer.shanghai.modules.system.entity.User;
import com.tuxiaoer.shanghai.modules.system.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/9 17:43
 * @description：用户接口
 */
@RestController
@RequestMapping(value = "/system/user")
public class UserController {

    @Reference
    private UserService userService;

    /**
     * 分页查询
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping
    public PageInfo<User> getUserListByPage(User user,
                                         @RequestParam(defaultValue = "1") Integer pageNum,
                                         @RequestParam(defaultValue = "10") Integer pageSize) {
        return userService.getUserListByPage(user, pageNum, pageSize);
    }

    /**
     * 通过Id获取用户
     * @param user
     * @return
     */
    @GetMapping(value = "/{id}")
    public User getUserById (User user) {
        return userService.getUserByUserId(user);
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping
    public Integer saveUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PutMapping
    public Integer updateUser(@RequestBody User user) {
        return  userService.upUserByUserId(user);
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Integer deleteUser(User user) {
        return userService.delUserByUserId(user);
    }

}

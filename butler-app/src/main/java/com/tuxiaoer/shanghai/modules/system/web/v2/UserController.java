package com.tuxiaoer.shanghai.modules.system.web.v2;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tuxiaoer.shanghai.common.utils.Result;
import com.tuxiaoer.shanghai.common.versioning.ApiVersion;
import com.tuxiaoer.shanghai.modules.system.entity.User;
import com.tuxiaoer.shanghai.modules.system.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/9 17:43
 * @description：用户接口
 */

@RestController
@ApiVersion(value = 2)
@RequestMapping(value = "/{version}/system/user")
public class UserController {

    @Reference
    private UserService userService;


    /**
     * 通过Id获取用户
     * @param id
     * @return
     */

    @GetMapping(value = "/{id}")
    public Result<User> getUserById1 (@PathVariable Long id) {
        return userService.getUserByUserId(new User(3L));
    }


}

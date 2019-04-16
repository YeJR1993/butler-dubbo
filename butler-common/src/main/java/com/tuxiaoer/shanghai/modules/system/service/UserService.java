package com.tuxiaoer.shanghai.modules.system.service;

import com.tuxiaoer.shanghai.modules.common.utils.PageInfo;
import com.tuxiaoer.shanghai.modules.system.entity.User;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/4 9:45
 * @descideaription：系统用户Service接口
 */
public interface UserService {

    /**
     * 通过用户名获取用户信息
     * @param user
     * @return
     */
    User getUserByUserId(User user);

    /**
     * （分页）查询用户列表
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<User> getUserListByPage(User user, Integer pageNum, Integer pageSize);

    /**
     * 保存用户
     * @param user
     * @return
     */
    Integer saveUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    Integer upUserByUserId(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    Integer delUserByUserId(User user);

    /**
     * 删除该用户的角色关系
     * @param user
     * @return
     */
    Integer delUserRoleByUserId(User user);

    /**
     * 保存用户角色关系
     * @param user
     * @return
     */
    Integer insertUserRole(User user);

}

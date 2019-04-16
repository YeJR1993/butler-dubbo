package com.tuxiaoer.shanghai.modules.system.service;

import com.tuxiaoer.shanghai.modules.common.utils.PageInfo;
import com.tuxiaoer.shanghai.modules.system.entity.Role;

import java.util.List;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/16 10:17
 * @description：角色service
 */
public interface RoleService {

    /**
     * 通过角色Id获取角色
     * @param role
     * @return
     */
    Role getRoleByRoleId(Role role);

    /**
     * 分页查询角色列表
     * @param role
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Role> getRoleListByPage(Role role, Integer pageNum, Integer pageSize);

    /**
     * 查询所有角色
     * @param role
     * @return
     */
    List<Role> getAllRoleList(Role role);

    /**
     * 查询用户的所有角色
     * @param userId
     * @return
     */
    List<Role> getUserAllRole(Integer userId);

    /**
     * 保存角色
     * @param role
     * @return
     */
    Integer insertRole(Role role);

    /**
     * 更新角色信息
     * @param role
     * @return
     */
    Integer upRoleById(Role role);

    /**
     * 根据角色Id删除角色
     * @param role
     * @return
     */
    Integer delRoleByRoleId(Role role);

    /**
     * 校验角色名是否重复
     * @param roleName
     * @param oldRoleName
     * @return
     */
    Boolean verifyRoleName(String roleName, String oldRoleName);

    /**
     * 更新角色菜单关系
     * @param role
     */
    void authSave(Role role);

}

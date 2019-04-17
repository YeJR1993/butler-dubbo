package com.tuxiaoer.shanghai.modules.system.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.tuxiaoer.shanghai.modules.common.utils.PageInfo;
import com.tuxiaoer.shanghai.modules.system.dao.RoleDao;
import com.tuxiaoer.shanghai.modules.system.entity.Role;
import com.tuxiaoer.shanghai.modules.system.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/17 10:44
 * @description：角色服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role getRoleByRoleId(Role role) {
        return roleDao.getRoleById(role);
    }

    @Override
    public PageInfo<Role> getRoleListByPage(Role role, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(roleDao.getRoleList(role));
    }

    @Override
    public List<Role> getAllRoleList(Role role) {
        return roleDao.getRoleList(role);
    }

    @Override
    public List<Role> getUserAllRole(Long userId) {
        List<Role> list = new ArrayList<>();
        if (userId != null) {
            list = roleDao.getUserAllRole(userId);
        }
        return list;
    }

    @Override
    public Integer insertRole(Role role) {
        return roleDao.insertRole(role);
    }

    @Override
    public Integer upRoleById(Role role) {
        return roleDao.upRoleById(role);
    }

    @Override
    public Integer delRoleByRoleId(Role role) {
        Integer result = roleDao.delRoleById(role);
        roleDao.delRoleMenuById(role);
        roleDao.delRoleUserById(role);
        return result;
    }

    @Override
    public Boolean verifyRoleName(String roleName, String oldRoleName) {
        if (StringUtils.isNotBlank(roleName)) {
            if (roleName.equals(oldRoleName)) {
                return true;
            }
            Role role = roleDao.getRoleByName(roleName);
            if (role == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void authSave(Role role) {
        // 先删除角色原有的对应的菜单
        roleDao.delRoleMenuById(role);
        //接着插入新的对应关系
        if (role.getMenus() != null && role.getMenus().size() > 0) {
            roleDao.insertRoleMenu(role);
        }
    }
}

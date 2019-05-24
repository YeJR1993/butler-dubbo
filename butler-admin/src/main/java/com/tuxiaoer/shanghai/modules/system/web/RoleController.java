package com.tuxiaoer.shanghai.modules.system.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tuxiaoer.shanghai.common.persistence.BaseController;
import com.tuxiaoer.shanghai.common.constant.SystemConstants;
import com.tuxiaoer.shanghai.common.utils.PageInfo;
import com.tuxiaoer.shanghai.common.utils.Result;
import com.tuxiaoer.shanghai.modules.system.entity.Menu;
import com.tuxiaoer.shanghai.modules.system.entity.Role;
import com.tuxiaoer.shanghai.modules.system.service.MenuService;
import com.tuxiaoer.shanghai.modules.system.service.RoleService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/18 16:03
 * @description：角色controller
 */
@Controller
@RequestMapping(value = "system/role")
public class RoleController extends BaseController {

    @Reference
    private RoleService roleService;

    @Reference
    private MenuService menuService;

    /**
     * list列表
     *
     * @param role
     * @param model
     * @return
     */
    @RequestMapping(value = "list")
    @RequiresPermissions(value = "system:list:role")
    public String list(Role role, Model model) {
        Result<PageInfo<Role>> pageInfoResult = roleService.getRoleListByPage(role, getPageDefault(SystemConstants.PAGE_NUM), getPageDefault(SystemConstants.PAGE_SIZE));
        PageInfo<Role> page = pageInfoResult.getData();
        model.addAttribute("page", page);
        return "modules/system/roleList";
    }

    /**
     * form表单
     *
     * @param role
     * @param model
     * @return
     */
    @RequestMapping(value = "form")
    @RequiresPermissions(value = {"system:add:role", "system:view:role", "system:edit:role"}, logical = Logical.OR)
    public String form(Role role, Model model) {
        if (role.getId() != null) {
            Result<Role> roleResult = roleService.getRoleByRoleId(role);
            role = roleResult.getData();
            model.addAttribute("role", role);
        }
        return "modules/system/roleForm";
    }

    /**
     * 添加或者编辑
     *
     * @param role
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save")
    @RequiresPermissions(value = {"system:add:role", "system:edit:role"}, logical = Logical.OR)
    public String save(Role role, RedirectAttributes redirectAttributes) {
        if (role.getId() == null) {
            roleService.insertRole(role);
        } else {
            roleService.upRoleById(role);
        }
        redirectAttributes.addFlashAttribute("msg", SystemConstants.OPERATE_SUCCESS_PAGE_TIP);
        return "redirect:/system/role/list";
    }

    /**
     * 单个删除
     *
     * @param role
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "delete")
    @RequiresPermissions(value = "system:delete:role")
    public String delete(Role role, RedirectAttributes redirectAttributes) {
        roleService.delRoleByRoleId(role);
        redirectAttributes.addFlashAttribute("msg", SystemConstants.OPERATE_SUCCESS_PAGE_TIP);
        return "redirect:/system/role/list";
    }

    /**
     * 批量删除
     *
     * @param ids
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "deleteAll")
    @RequiresPermissions(value = "system:delete:user")
    public String deleteAll(Long[] ids, RedirectAttributes redirectAttributes) {
        roleService.delRolesByIds(ids);
        redirectAttributes.addFlashAttribute("msg", SystemConstants.OPERATE_SUCCESS_PAGE_TIP);
        return "redirect:/system/role/list";
    }

    /**
     * 校验角色名是不是新的
     *
     * @param roleName
     * @param oldRoleName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "verifyRoleName")
    public boolean verifyUsername(String roleName, String oldRoleName) {
        Result<Boolean> booleanResult = roleService.verifyRoleName(roleName, oldRoleName);
        return booleanResult.getData();
    }

    /**
     * 进入权限设置页面
     *
     * @param role
     * @param model
     * @return
     */
    @RequestMapping(value = "auth")
    @RequiresPermissions(value = "system:allocation:role")
    public String auth(Role role, Model model) {
        Result<Role> roleResult = roleService.getRoleByRoleId(role);
        Result<List<Menu>> menuListResult = menuService.getMenuList(new Menu());
        model.addAttribute("role", roleResult.getData());
        model.addAttribute("menuList", menuListResult.getData());
        return "modules/system/roleAuth";
    }

    /**
     * 权限保存
     *
     * @param role
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "authSave")
    @RequiresPermissions(value = "system:allocation:role")
    public String authSave(Role role, RedirectAttributes redirectAttributes) {
        roleService.authSave(role);
        redirectAttributes.addFlashAttribute("msg", SystemConstants.OPERATE_SUCCESS_PAGE_TIP);
        return "redirect:/system/role/list";
    }

}

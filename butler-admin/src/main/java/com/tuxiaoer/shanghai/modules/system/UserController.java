package com.tuxiaoer.shanghai.modules.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tuxiaoer.shanghai.common.persistence.BaseController;
import com.tuxiaoer.shanghai.modules.common.constant.SystemConstants;
import com.tuxiaoer.shanghai.modules.common.utils.PageInfo;
import com.tuxiaoer.shanghai.modules.system.entity.Role;
import com.tuxiaoer.shanghai.modules.system.entity.User;
import com.tuxiaoer.shanghai.modules.system.service.RoleService;
import com.tuxiaoer.shanghai.modules.system.service.UserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/12 10:44
 * @description：用户模块
 */
@Controller
@RequestMapping(value = "system/user")
public class UserController extends BaseController {

    @Reference
    private UserService userService;

    @Reference
    private RoleService roleService;

    /**
     * list列表
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "list")
    @RequiresPermissions(value="system:list:user")
    public String list(User user, Model model) {
        PageInfo<User> page = userService.getUserListByPage(user,getPageDefault(SystemConstants.PAGE_NUM),getPageDefault(SystemConstants.PAGE_SIZE));
        model.addAttribute("page", page);
        return "modules/system/userList";
    }

    /**
     * form表单
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "form")
    @RequiresPermissions(value= {"system:add:user", "system:view:user", "system:edit:user"}, logical= Logical.OR)
    public String form(User user, Model model) {
        if (user.getId() != null) {
            user = userService.getUserByUserId(user);
            model.addAttribute("user", user);
            model.addAttribute("allRoles", roleService.getUserAllRole(user.getId()));
        } else {
            Role role = new Role();
            role.setStatus(1);
            model.addAttribute("allRoles", roleService.getAllRoleList(role));
        }
        return "modules/system/userForm";
    }

    /**
     * 添加或者编辑
     * @param user
     * @param redirectAttributes
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "save")
    @RequiresPermissions(value= {"system:add:user", "system:edit:user"}, logical=Logical.OR)
    public String save(User user, RedirectAttributes redirectAttributes)  {
        if (user.getId() == null) {
            userService.insertUser(user);
        } else {
            userService.upUserByUserId(user);
        }
        redirectAttributes.addFlashAttribute("msg", SystemConstants.OPERATE_SUCCESS_PAGE_TIP);
        return "redirect:/system/user/list";
    }


}

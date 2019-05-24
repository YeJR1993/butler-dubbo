package com.tuxiaoer.shanghai.modules.system.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tuxiaoer.shanghai.common.persistence.BaseController;
import com.tuxiaoer.shanghai.common.constant.SystemConstants;
import com.tuxiaoer.shanghai.common.utils.Result;
import com.tuxiaoer.shanghai.modules.system.entity.Menu;
import com.tuxiaoer.shanghai.modules.system.service.MenuService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/18 16:18
 * @description：菜单controller
 */
@Controller
@RequestMapping(value = "system/menu")
public class MenuController extends BaseController {

    @Reference
    private MenuService menuService;

    /**
     * list 列表
     *
     * @param menu
     * @param model
     * @return
     */
    @RequestMapping(value = "list")
    @RequiresPermissions(value = "system:list:menu")
    public String list(Menu menu, Model model) {
        Result<List<Menu>> menuListResult = menuService.getMenuList(new Menu());
        List<Menu> list = menuListResult.getData();
        model.addAttribute("list", list);
        return "modules/system/menuList";
    }

    /**
     * form表单
     *
     * @param menu
     * @param model
     * @return
     */
    @RequestMapping(value = "form")
    @RequiresPermissions(value = {"system:add:menu", "system:view:menu", "system:edit:menu"}, logical = Logical.OR)
    public String form(Menu menu, Model model) {
        if (menu.getId() != null) {
            Result<Menu> menuResult = menuService.getMenuById(menu);
            menu = menuResult.getData();
        }
        // 添加下级菜单，需要获取父菜单信息
        if (menu.getParentId() != null) {
            Menu parent = new Menu(menu.getParentId());
            Result<Menu> menuResult = menuService.getMenuById(parent);
            menu.setParent(menuResult.getData());
        }
        model.addAttribute("menu", menu);
        return "modules/system/menuForm";
    }

    /**
     * 添加或者编辑
     *
     * @param menu
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save")
    @RequiresPermissions(value = {"system:add:menu", "system:edit:menu"}, logical = Logical.OR)
    public String save(Menu menu, RedirectAttributes redirectAttributes) {
        if (menu.getId() == null) {
            menuService.insertMenu(menu);
        } else {
            menuService.upMenuById(menu);
        }
        redirectAttributes.addFlashAttribute("msg", SystemConstants.OPERATE_SUCCESS_PAGE_TIP);
        return "redirect:/system/menu/list";
    }

    /**
     * 单个删除
     *
     * @param menu
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "delete")
    @RequiresPermissions(value = "system:delete:menu")
    public String delete(Menu menu, RedirectAttributes redirectAttributes) {
        menuService.delMenuById(menu);
        redirectAttributes.addFlashAttribute("msg", SystemConstants.OPERATE_SUCCESS_PAGE_TIP);
        return "redirect:/system/menu/list";
    }

    /**
     * 批量删除
     *
     * @param ids
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "deleteAll")
    @RequiresPermissions(value = "system:delete:menu")
    public String deleteAll(Long[] ids, RedirectAttributes redirectAttributes) {
        menuService.delMenusByIds(ids);
        redirectAttributes.addFlashAttribute("msg", SystemConstants.OPERATE_SUCCESS_PAGE_TIP);
        return "redirect:/system/menu/list";
    }

    /**
     * 进入选择父菜单页面
     *
     * @param menu
     * @param model
     * @return
     */
    @RequestMapping(value = "menuSelect")
    public String menuSelect(Menu menu, Model model) {
        Result<List<Menu>> menuListResult = menuService.getMenuList(menu);
        model.addAttribute("menuList", menuListResult.getData());
        return "modules/system/menuSelect";
    }
}

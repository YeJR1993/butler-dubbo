package com.tuxiaoer.shanghai.modules.system.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tuxiaoer.shanghai.modules.common.utils.Result;
import com.tuxiaoer.shanghai.modules.system.entity.Menu;
import com.tuxiaoer.shanghai.modules.system.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/17 14:15
 * @description：菜单接口
 */
@RestController
@RequestMapping(value = "/system/menu")
public class MenuController {

    @Reference
    private MenuService menuService;


    @GetMapping(value = "/{id}")
    public Result<Menu> getMenuById(Menu menu) {
        return menuService.getMenuById(menu);
    }

}

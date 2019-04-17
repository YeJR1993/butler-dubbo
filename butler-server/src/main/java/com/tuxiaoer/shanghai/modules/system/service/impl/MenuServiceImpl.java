package com.tuxiaoer.shanghai.modules.system.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tuxiaoer.shanghai.modules.system.dao.MenuDao;
import com.tuxiaoer.shanghai.modules.system.entity.Menu;
import com.tuxiaoer.shanghai.modules.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/17 11:06
 * @description：菜单服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public Menu getMenuById(Menu menu) {
        return menuDao.getMenuById(menu);
    }

    @Override
    public List<Menu> getMenuList(Menu menu) {
        // 查询并进行排序
        List<Menu> list = new ArrayList<Menu>();
        List<Menu> sourceList = menuDao.getMenuList(menu);
        Menu.sortList(list, sourceList, 1L);
        return list;
    }

    @Override
    public List<Menu> getMenuByUserId(Long userId, Integer isShow, Boolean isAdmin) {
        List<Menu> menus;
        if (isAdmin) {
            Menu menu = new Menu();
            menu.setIsShow(isShow);
            menus = menuDao.getMenuList(menu);
        } else {
            menus = menuDao.getMenuByUserId(userId, isShow);
        }
        List<Menu> list = new ArrayList<>();
        Menu.sortList(list, menus, 1L);
        return list;
    }

    @Override
    public Integer insertMenu(Menu menu) {
        return menuDao.insertMenu(menu);
    }

    @Override
    public Integer upMenuById(Menu menu) {
        return menuDao.upMenuById(menu);
    }

    @Override
    public Integer delMenuById(Menu menu) {
        // 因为需要删除该菜单下的所有子菜单以及子子菜单等等，先查询
        menu = menuDao.getMenuById(menu);
        // 递归删除子菜单、子子菜单等等
        if (menu != null && menu.getChildren() != null && menu.getChildren().size() > 0) {
            for(Menu childMenu : menu.getChildren()){
                delMenuById(childMenu);
            }
        }
        menuDao.delMenuById(menu);
        return 1;
    }
}

package com.tuxiaoer.shanghai.modules.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/12 10:45
 * @description：登录（公用）模块
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/login")
    public String login() {
        return "modules/login";
    }
}

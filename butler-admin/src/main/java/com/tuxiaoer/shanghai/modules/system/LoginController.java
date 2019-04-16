package com.tuxiaoer.shanghai.modules.system;

import com.tuxiaoer.shanghai.modules.common.utils.RandomValidateCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/12 10:45
 * @description：登录（公用）模块
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login")
    public String login() {
        return "modules/login";
    }

    /**
     * 生成验证码
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 设置相应类型,告诉浏览器输出的内容为图片
            response.setContentType("image/jpeg");
            // 设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            // 输出验证码图片方法
            randomValidateCode.getRandcode(request, response);
        } catch (Exception e) {
            logger.info("获取验证码失败:{}", e);
        }
    }
}

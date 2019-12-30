package com.sso.login.controller;

import com.sso.login.pojo.User;
import com.sso.login.utils.LoginCacheUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * @author ：XUMINGXING
 * @description : Created by 写代码的徐师傅
 * @date ：Created in 15:49 2019/12/27
 * @description ：sso-use-cookie 页面跳转逻辑
 * @modified by ：No Modified
 */
@Controller
@RequestMapping("/view")
public class ViewController {
    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping("/login")
    public String toLogin(@RequestParam(required = false,defaultValue = "") String target,
                          HttpSession session,
                          @CookieValue(required = false,value = "TOKEN") Cookie cookie){

        if (StringUtils.isEmpty(target)){
            target = "http://www.codeshop.com:9010";
        }
//        如果已经登录的用户再次访问系统时，就要重定向回去
        if (cookie != null){
            String value = cookie.getValue();
            User user = LoginCacheUtil.loginUser.get(value);
            if(user !=null){
                return "redirect:" + target;
            }
        }
//        TODO：要做target地址是否合法校验的
//        重定向地址
        session.setAttribute("target",target);
        return "login";
    }
}

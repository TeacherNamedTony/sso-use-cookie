package com.sso.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String toLogin(){
        return "login";
    }
}

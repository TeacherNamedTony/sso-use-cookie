package com.sso.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：XUMINGXING
 * @description : Created by 写代码的徐师傅
 * @date ：Created in 17:07 2019/12/27
 * @description ：sso-use-cookie
 * @modified by ：No Modified
 */
@Controller
@RequestMapping("/view")
public class ViewController {
    @GetMapping("/index")
    public String toIndex(){
        return "index";
    }
}

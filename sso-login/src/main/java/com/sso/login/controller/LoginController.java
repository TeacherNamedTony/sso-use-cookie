package com.sso.login.controller;

import com.sso.login.pojo.User;
import com.sso.login.utils.LoginCacheUtil;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * @author ：XUMINGXING
 * @description : Created by 写代码的徐师傅
 * @date ：Created in 15:47 2019/12/27
 * @description ：sso-use-cookie
 * @modified by ：No Modified
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private static Set<User> dbUser;
    static {
        dbUser = new HashSet<>();
        dbUser.add(new User(0,"zhangsan","12345"));
        dbUser.add(new User(1,"lisi","123456"));
        dbUser.add(new User(0,"wangwu","1234567"));
    }
    @PostMapping
    public String toLogin(User user, HttpSession session, HttpServletResponse response){
        String target = (String) session.getAttribute("target");
//        模拟从数据库中通过登录用户名和密码去查找数据库中的用户
        Optional<User> first = dbUser.stream().filter(dbUser -> dbUser.getUsername().equals(user.getUsername()) &&
                dbUser.getPassword().equals(user.getPassword()))
                .findFirst();
//        判断用户是否登录
        if (first.isPresent()){
//             保存用户信息
            String token = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("TOKEN",token);
            cookie.setDomain("codeshop.com");
            response.addCookie(cookie);

            LoginCacheUtil.loginUser.put(token,first.get());
        }else {
//            登录失败
            session.setAttribute("msg","用户名或密码错误");
            return "login";
        }
//        重定向到target地址
        return "redirect:" + target;
    }

    @GetMapping("info")
    @ResponseBody
    public ResponseEntity<User> getUserInfo(String token){
        if (!StringUtils.isEmpty(token)){
            User user = LoginCacheUtil.loginUser.get(token);
            return ResponseEntity.ok(user);
        }else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

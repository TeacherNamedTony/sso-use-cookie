package com.sso.login.utils;

import com.sso.login.pojo.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：XUMINGXING
 * @description : Created by 写代码的徐师傅
 * @date ：Created in 15:16 2019/12/30
 * @description ：sso-use-cookie
 * @modified by ：No Modified
 */
@Component
public class LoginCacheUtil {
    public static Map<String, User>  loginUser = new HashMap<>();
}

package com.sso.login.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/**
 * 添加getter setter方法
 * @author Administrator
 */
@Data
/**
 * 添加无参构造方法
 */
@NoArgsConstructor
/**
 * 添加全参构造方法
 */
@AllArgsConstructor
/**
 * 添加链式调用
 */
@Accessors(chain = true)

/**
 * @author ：XUMINGXING
 * @description : Created by 写代码的徐师傅
 * @date ：Created in 15:40 2019/12/27
 * @description ：sso-use-cookie
 * @modified by ：No Modified
 */
public class User  {
    private Integer id;
    private String username;
    private String password;
}

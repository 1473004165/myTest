package com.dongye.sanquan.security.token;

import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

/**
 * 登录类型
 * @author 冉翔
 */
public class CustomizedToken extends UsernamePasswordToken implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -4890297065880698142L;

    //登录类型，判断是普通用户登录，还是管理员登录
    private String loginType;

    public CustomizedToken(final String username, final String password,String loginType) {
        super(username,password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
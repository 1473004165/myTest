package com.dongye.sanquan.pojo.login;

/**
 * 枚举类型
 * @author 冉翔
 */
public enum LoginType
{
    USER("User"),  ADMIN("Admin");

    private String type;

    private LoginType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
package com.dongye.sanquan.api.mb.login.utils;

import java.util.Random;

/**该工具类用于生成随机盐
 * @author 冉翔
 * @date 2021/04/18 9:52
 */
public class SaltUtils {
    public static String getSalt(int n){
        char[] chars = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                "1234567890!@#$%^&*()_+").toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            //Random().nextInt()返回值为[0,n)
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}

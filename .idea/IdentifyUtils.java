package com.dongye.sanquan.api.mb.login.utils;

import com.dongye.sanquan.pojo.login.LoginType;
import com.dongye.sanquan.security.token.CustomizedToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;

/**mb端登录工具类
 * @author 冉翔
 * @date 2021/04/19
 */
public class IdentifyUtils {
    private static final String USER_LOGIN_TYPE = LoginType.USER.toString();

    public static boolean identify(Integer userID,String openID){
        Subject subject = SecurityUtils.getSubject();
        CustomizedToken customizedToken = new CustomizedToken(userID.toString(),openID,USER_LOGIN_TYPE);
        try {
            subject.login(customizedToken);
            System.out.println("认证成功了吗？"+subject.isAuthenticated());
            return subject.isAuthenticated();
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("userID不存在");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("openID错误");
        }
        return subject.isAuthenticated();
    }
}

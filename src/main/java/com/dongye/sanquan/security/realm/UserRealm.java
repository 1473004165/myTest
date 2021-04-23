package com.dongye.sanquan.security.realm;

import com.dongye.sanquan.api.mb.login.service.LoginService;
import com.dongye.sanquan.pojo.orm.SysUserEntity;
import com.dongye.sanquan.security.token.CustomizedToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;


/**
 * @author 冉翔
 * @since 2021-04-18
 */
public class UserRealm extends AuthorizingRealm {

    @Resource(name = "mbLoginService")
    private LoginService loginService;


    /**
     * 身份认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        CustomizedToken customizedToken = (CustomizedToken) token;
        Integer principal = Integer.parseInt(customizedToken.getUsername());
        System.out.println(principal);
        //操作数据库查询openid
        SysUserEntity sysUserEntity = loginService.findByPrincipal(principal);
        if (ObjectUtils.isEmpty(sysUserEntity)){
            throw new UnknownAccountException("用户不存在！");
        }
        System.out.println(sysUserEntity);
        //验证通过返回一个封装了用户信息的AuthenticationInfo实例。
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                sysUserEntity, //用户信息
                sysUserEntity.getWeixinOpenid(), //openID
                getName() //realm name
        );
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(sysUserEntity.getSalt())); //设置盐
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}

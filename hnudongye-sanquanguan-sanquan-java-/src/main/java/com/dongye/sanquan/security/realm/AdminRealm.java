package com.dongye.sanquan.security.realm;

import com.dongye.sanquan.api.pc.adminUser.service.AdminUserService;
import com.dongye.sanquan.api.pc.login.pojo.vo.UserLoginVO;
import com.dongye.sanquan.pojo.orm.SysAdminEntity;
import com.dongye.sanquan.utils.ShiroUtils;
import com.dongye.sanquan.utils.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;


/**
 * @author 章卜
 * @since 2021-04-04
 */
public class AdminRealm extends AuthorizingRealm {


    
    @Resource(name = "adminUserServiceImpl")
            @Lazy
    AdminUserService adminUserService;



    /**
     * 身份认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
        String principal = (String) token.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到进行验证
        //实际项目中,这里可以根据实际情况做缓存,如果不做,Shiro自己也是有时间间隔机制,2分钟内不会重复执行该方法
        UserLoginVO userLoginVO = new UserLoginVO();
        SysAdminEntity user = null;
        userLoginVO.setLoginId(principal);

        try {

            user = adminUserService.selectUserByName(userLoginVO);
            System.out.println(user.toString()+"CEBOOOOOOOSBBBBBBBBBBBBBBBBB");
        } catch (Exception e) {
            Exception exception = new Exception(e.getMessage());
            try {
                throw exception;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        //判断账号是否存在
        if (user == null) {
            throw new AuthenticationException();
        }
        //判断账号是否被冻结
        System.out.println(user.toString()+"222222222222222222222222222222222222");
        //进行验证

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                //用户
                user,
                //密码
                user.getPassword(),
                //设置盐值
                ByteSource.Util.bytes(user.getSalt()),
                getName()
        );

        //验证成功开始踢人(清除缓存和Session)
        ShiroUtils.deleteAdminCache(principal, true);
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}

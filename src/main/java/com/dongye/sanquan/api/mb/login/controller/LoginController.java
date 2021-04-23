package com.dongye.sanquan.api.mb.login.controller;

import com.dongye.sanquan.api.mb.login.pojo.MbResult;
import com.dongye.sanquan.api.mb.login.service.LoginService;
import com.dongye.sanquan.api.mb.login.utils.IdentifyUtils;
import com.dongye.sanquan.pojo.orm.SysUserEntity;
import com.dongye.sanquan.pojo.rmso.ResultCode;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import com.dongye.sanquan.utils.SHA256Util;
import com.dongye.sanquan.utils.ShiroUtils;
import io.swagger.annotations.Api;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**微信登录模块
 * <p>@author 冉翔 </p>
 * <p>@date 2021/4/18 </p>
 */
@RestController("mbLoginController")
@RequestMapping("mb")
@Api("微信用户登录模块")
public class LoginController {
    //用户登录

    @Resource(name = "mbLoginService")
    private LoginService loginService;

    @GetMapping("login")
    public ResultVO login(String nickName,String phone,String code,String salt){
        MbResult mbResult = new MbResult();
        //第一次登录或openID认证失败，向微信官方请求openID
        String openId = loginService.linkWechat(code);
        System.out.println(openId);
        //查询是否初次授权
        if (openId == null) {
            return new ResultVO(ResultCode.ERROR,"授权失败");
        }
        String newId = SHA256Util.sha256(openId,salt);
        SysUserEntity sysUserEntity = loginService.findByOpenId(newId);
        if (ObjectUtils.isEmpty(sysUserEntity)){
            //初次授权
            sysUserEntity = new SysUserEntity();
            sysUserEntity.setUserNickname(nickName);
            sysUserEntity.setWeixinOpenid(newId);
            sysUserEntity.setUserMobile(phone);
            sysUserEntity.setSalt(salt);
            boolean register = loginService.register(sysUserEntity);
            if (register){
                sysUserEntity = loginService.findByOpenId(newId);
            }else {
                return new ResultVO(ResultCode.ERROR,"登陆失败");
            }
        }else {
            //数据不一致更新数据
            if (!sysUserEntity.getUserNickname().equals(nickName) || !sysUserEntity.getUserMobile().equals(phone)){
                sysUserEntity.setUserNickname(nickName);
                sysUserEntity.setUserMobile(phone);
                loginService.updateUser(sysUserEntity);
            }
        }
        boolean identify = IdentifyUtils.identify(sysUserEntity.getUserId(),openId);
        if (identify){
            Map<String,Object> map = new HashMap<>();
            map.put("token", ShiroUtils.getSession().getId().toString());
            System.out.println(map);
            return new ResultVO(map);
        }
        return new ResultVO(ResultCode.ERROR,"授权失败");
    }
}

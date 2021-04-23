package com.dongye.sanquan.api.mb.login.service;

import com.dongye.sanquan.pojo.orm.SysUserEntity;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 冉翔
 * @since 2021-04-18
 */
public interface LoginService {
    /**
     * 通过code获取openID
     * @param code 用户code
     * @return 微信openID
     */
    String linkWechat(String code);

    /**
     * 通过身份信息查询
     * @param principal userId
     * @return SysUserEntity
     */
    SysUserEntity findByPrincipal(Integer principal);

    /**
     * 通过openId查询：是否初次授权
     * @param openId 微信用户的openId
     * @return SysUserEntity
     */
    SysUserEntity findByOpenId(String openId);

    /**
     * 初次授权，写入相关数据
     * @param sysUserEntity 写入的用户信息
     * @return 是否成功写入
     */
    boolean register(SysUserEntity sysUserEntity);

    /**
     * 更新数据
     * @param sysUserEntity 新的用户数据
     */
    void updateUser(SysUserEntity sysUserEntity);
}

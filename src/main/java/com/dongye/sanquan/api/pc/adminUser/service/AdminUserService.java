package com.dongye.sanquan.api.pc.adminUser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dongye.sanquan.api.pc.login.pojo.vo.UserLoginVO;
import com.dongye.sanquan.pojo.orm.SysAdminEntity;
import com.dongye.sanquan.pojo.rmso.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 章卜
 * @since 2021-04-05
 */
public interface AdminUserService extends IService<SysAdminEntity> {

    /**
     * 根据姓名查询用户
     *
     * @param username
     * @return SysUserEntity
     * @throws Exception
     */
    SysAdminEntity selectUserByName(UserLoginVO username) throws Exception;

    /**
     * 添加数据
     *
     * @param sysAdminEntity
     * @return ResultVO
     * @throws Exception
     */
    ResultVO addData(SysAdminEntity sysAdminEntity) throws Exception;


}

package com.dongye.sanquan.api.pc.adminUser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dongye.sanquan.api.pc.adminUser.mapper.AdminUserMapper;
import com.dongye.sanquan.api.pc.adminUser.service.AdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dongye.sanquan.api.pc.login.pojo.vo.UserLoginVO;
import com.dongye.sanquan.pojo.orm.SysAdminEntity;
import com.dongye.sanquan.pojo.rmso.ResultCode;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import com.dongye.sanquan.utils.SHA256Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 章卜
 * @since 2021-04-05
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, SysAdminEntity> implements AdminUserService {

    @Autowired
    private AdminUserMapper userMapper;

    @Override
    public SysAdminEntity selectUserByName(UserLoginVO user) throws Exception {
        QueryWrapper<SysAdminEntity> qw = new QueryWrapper<>();
        if (user.getLoginId()!= null && !"".equals(user.getLoginId())) {
            qw.eq("login_id", user.getLoginId());
        }

        return userMapper.selectOne(qw);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public ResultVO addData(SysAdminEntity sysAdminEntity) throws Exception {
        if (sysAdminEntity != null) {
            QueryWrapper<SysAdminEntity> qw = new QueryWrapper<>();
            qw.eq("login_id", sysAdminEntity.getLoginId());
            if(userMapper.selectOne(qw) != null){
                return new ResultVO(ResultCode.VALIDATE_FAILED, "该账号已注册!");
            }

            if (sysAdminEntity.getPassword() == null || sysAdminEntity.getPassword().equals("")) {
                return new ResultVO(ResultCode.VALIDATE_FAILED, "待添加用户密码不能为空！");
            }  else if (sysAdminEntity.getAdminName() == null || sysAdminEntity.getAdminName().equals("")) {
                return new ResultVO(ResultCode.VALIDATE_FAILED, "待添加用户名不能为空！");
            } else if (sysAdminEntity.getPassword().length() < 6) {
                return new ResultVO(ResultCode.VALIDATE_FAILED, "密码不得小于6位，请重新输入！");
            }  else {
                String salt = UUID.randomUUID().toString();
                byte[] sb = salt.getBytes();
                String sha256 = SHA256Util.sha256(sysAdminEntity.getPassword(), salt);
                sysAdminEntity.setPassword(sha256);
                sysAdminEntity.setSalt(sb);
                int res = userMapper.insert(sysAdminEntity);
                if (res > 0) {
                    return new ResultVO(ResultCode.SUCCESS, "用户注册成功！");
                } else {
                    return new ResultVO(ResultCode.VALIDATE_FAILED, "添加失败！");
                }
            }
        } else {
            return new ResultVO(ResultCode.FAILED, "空参数！");
        }
    }
}

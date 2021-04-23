package com.dongye.sanquan.api.mb.login.service.impl;
import com.dongye.sanquan.api.mb.login.mapper.LoginMapper;
import com.dongye.sanquan.api.mb.login.service.LoginService;
import com.dongye.sanquan.api.mb.login.utils.HttpUtils;
import com.dongye.sanquan.pojo.orm.SysUserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 冉翔
 * @since 2021-04-18
 */
@Service("mbLoginService")
@Transactional
public class LoginServiceImpl implements LoginService {
    @Resource(name = "mbLoginMapper")
    private LoginMapper loginMapper;

    /**
     * 从微信平台获取openid
     * @param code 微信登录动态code
     * @return openid
     */
    @Override
    public String linkWechat(String code) {
        return HttpUtils.getResponse(code);
    }

    @Override
    public SysUserEntity findByPrincipal(Integer principal) {
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",principal);
        List<SysUserEntity> users = loginMapper.selectByMap(map);
        if (users != null){
            return users.get(0);
        }
        return null;
    }

    @Override
    public SysUserEntity findByOpenId(String openId) {
        Map<String,Object> map = new HashMap<>();
        map.put("weixin_openId",openId);
        List<SysUserEntity> users = loginMapper.selectByMap(map);
        if (users != null && users.size()>0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public boolean register(SysUserEntity sysUserEntity) {
        //微信用户第一次登录，写入数据
        //加密openId
       try {
            loginMapper.insert(sysUserEntity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateUser(SysUserEntity sysUserEntity) {
        loginMapper.updateById(sysUserEntity);
    }
}

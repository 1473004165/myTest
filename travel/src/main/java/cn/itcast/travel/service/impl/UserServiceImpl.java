package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User checkUsername(String username) {
        //调用dao
        return userDao.findByUsername(username);
    }

    @Override
    public boolean register(User user) {
        //1.存储信息
        user.setCode(UUID.randomUUID().toString());
        user.setStatus("N");
        //2.调用dao
        //2.1再次判断用户名是否已经存在
        User byUsername = userDao.findByUsername(user.getUsername());
        if (byUsername == null){
            userDao.register(user);
            //3.发送激活邮件
            MailUtils.sendMail(user.getEmail(),"<a href=\"http://localhost/travel/user/active?code="+user.getCode()+"\">点击激活</a>","激活邮件");
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        return userDao.loginFind(user);
    }

    @Override
    public boolean active(String code) {
        //1.查新code是否存在
        User user = userDao.findByCode(code);
        //2.判断结果，执行相关操作
        if (user != null){
            userDao.active(code);
            return true;
        }
        return false;
    }
}

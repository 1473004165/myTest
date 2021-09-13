package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

public interface UserService {
    /**
     * 判断用户名是否有效
     * @param username
     * @return
     */
    User checkUsername(String username);

    /**
     * 注册方法
     * @param user
     * @return
     */
    boolean register(User user);

    /**
     * 激活方法
     * @param code
     * @return
     */
    boolean active(String code);

    /**
     * 用户登录方法
     * @param user
     * @return
     */
    User login(User user);
}

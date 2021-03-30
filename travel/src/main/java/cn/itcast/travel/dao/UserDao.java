package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {

    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 写入信息
     * @param user
     */
    void register(User user);

    /**
     * 通过激活码查询
     * @param code
     * @return
     */
    User findByCode(String code);

    /**
     * 激活
     * @param code
     */
    void active(String code);

    /**
     * 登录
     * @param user
     * @return
     */
    User loginFind(User user);
}

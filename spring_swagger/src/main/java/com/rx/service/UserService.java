package com.rx.service;


import com.rx.domain.User;

import java.util.List;

public interface UserService {
    /**
     * 查询所有
     * @return 查询的用户结果集
     */
    List<User> findAll();

    /**
     * 添加用户
     * @param user 需要添加的用户
     */
    void addUser(User user);

    /**
     * 根据ID删除用户
     * @param id 用户的id
     */
    void deleteUserById(Integer id);

    /**
     * 更新用户数据
     * @param user 新数据
     */
    void updateUser(User user);
}

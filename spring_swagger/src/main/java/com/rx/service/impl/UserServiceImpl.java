package com.rx.service.impl;

import com.rx.domain.User;
import com.rx.mapper.UserMapper;
import com.rx.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}

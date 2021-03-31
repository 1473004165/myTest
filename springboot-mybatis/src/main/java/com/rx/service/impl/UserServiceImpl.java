package com.rx.service.impl;

import com.rx.domain.User;
import com.rx.mapper.UserMapper;
import com.rx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;
    @Override
    public List<User> findAll() {
        return mapper.findAll();
    }
}

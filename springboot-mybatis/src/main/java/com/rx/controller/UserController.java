package com.rx.controller;

import com.rx.domain.User;
import com.rx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public String findAll(){
        return "success";
    }

    @RequestMapping("findAllUser")
    @ResponseBody
    public List<User> findUser(){
        return userService.findAll();
    }
}

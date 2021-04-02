package com.rx.controller;

import com.rx.domain.User;
import com.rx.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user")
@Api("操作用户的一些列接口")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("findAll")
    @ApiOperation("查询所有用户")
    public List<User> findAll(){
        return userService.findAll();
    }
    @PostMapping("delete")
    @ApiOperation("根据ID删除用户")
    public void deleteUser(@ApiParam("要删除的用户的id") Integer userId){
        System.out.println(userId);
        userService.deleteUserById(userId);
    }
    @PostMapping("update")
    @ApiOperation("更新用户信息")
    public void updateUser(@ApiParam("新用户相关信息") User user){
        userService.updateUser(user);
    }
    @GetMapping("add")
    @ApiOperation("添加用户")
    public void addUser(@ApiParam("添加用户") User user){
        userService.addUser(user);
    }
}

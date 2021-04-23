package com.dongye.sanquan.api.pc.adminUser.controller;


import com.dongye.sanquan.api.pc.adminUser.service.AdminUserService;
import com.dongye.sanquan.pojo.orm.SysAdminEntity;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 章卜
 * @since 2021-04-05
 */
@RestController
@RequestMapping("/adminUser")
public class AdminUserController {

    @Resource
    AdminUserService adminUserService;

    /**
     * 注册用户
     *
     * @return int
     * @throws Exception e
     */
    @PostMapping("/addUser")
    @ApiOperation("注册")
    public ResultVO addDate(@RequestBody SysAdminEntity sysAdminEntity) throws Exception {
        return adminUserService.addData(sysAdminEntity);
    }

}


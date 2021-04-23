package com.dongye.sanquan.api.pc.adminUser.controller;


import com.dongye.sanquan.api.pc.adminUser.service.AdminUserService;
import com.dongye.sanquan.pojo.orm.SysAdminEntity;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import com.dongye.sanquan.utils.ShiroUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/pc/admin")
public class AdminUserController {

    @Resource
    AdminUserService adminUserService;

    /**
     * 注册管理员
     *
     * @return int
     * @throws Exception e
     */
    @PostMapping("/adminAdd")
    @ApiOperation("注册")
    public ResultVO addDate(@RequestBody SysAdminEntity sysAdminEntity) throws Exception {
        return adminUserService.addData(sysAdminEntity);
    }

    @GetMapping("/adminInfo")
    @ApiOperation("查询管理员信息")
    public ResultVO<SysAdminEntity> adminInfo(){
        Long userId = ShiroUtils.getAdminInfo().getAdminId();
        return new ResultVO<SysAdminEntity>(adminUserService.getById(userId));
    }

}


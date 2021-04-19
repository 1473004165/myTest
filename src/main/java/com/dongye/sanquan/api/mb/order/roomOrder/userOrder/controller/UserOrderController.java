package com.dongye.sanquan.api.mb.order.roomOrder.userOrder.controller;


import com.dongye.sanquan.api.mb.order.roomOrder.userOrder.pojo.vo.UserOrderVo;
import com.dongye.sanquan.api.mb.order.roomOrder.userOrder.service.UserOrderService;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 杨子硕
 * @since 2021-04-15
 */
@Api("移动端自习室预约Controller")
@RestController
@RequestMapping("/mb/order/roomOrder")
public class UserOrderController {

    @Autowired
    UserOrderService userOrderService;

    @GetMapping("/userOrder")
    public ResultVO<List<UserOrderVo>> selectUserOrder(Long userId) throws Exception{
        return userOrderService.selectUserOrder(userId);
    }

}


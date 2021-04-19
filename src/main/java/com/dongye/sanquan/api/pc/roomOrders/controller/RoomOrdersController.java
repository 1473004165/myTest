package com.dongye.sanquan.api.pc.roomOrders.controller;


import com.dongye.sanquan.api.pc.roomOrders.pojo.vo.RoomOrdersVo;
import com.dongye.sanquan.api.pc.roomOrders.service.RoomOrdersService;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import io.swagger.annotations.Api;
import org.apache.commons.collections4.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * VIEW 前端控制器
 * </p>
 *
 * @author 叶翔乐
 * @since 2021-04-14
 */
@Api("预约订单查询Controller")
@RestController
@RequestMapping("/pc/order/roomOrder")
public class RoomOrdersController {

    @Autowired
    RoomOrdersService roomOrdersService;

    @GetMapping("/checkOrder")
    public ResultVO<List<RoomOrdersVo>> selectOrders(int orderStatus) throws Exception{
        return roomOrdersService.selectOrders(orderStatus);
    };


    @PostMapping("/updateOrder")
    public ResultVO updateRoomOrderStatus(int orderId,int orderStatus) throws Exception{
        return roomOrdersService.updateRoomOrderStatus(orderId,orderStatus);
    };
}


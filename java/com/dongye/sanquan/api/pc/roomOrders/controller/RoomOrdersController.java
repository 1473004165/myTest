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
@RequestMapping("/pc/order")
public class RoomOrdersController {

    @Autowired
    RoomOrdersService roomOrdersService;

    @GetMapping("/selectCheckingOrder")
    public ResultVO<List<RoomOrdersVo>> selectCheckingRoomOrders(int orderStatus) throws Exception{
        return roomOrdersService.selectCheckingRoomOrders(orderStatus);
    };
    @GetMapping("/selectDeniedOrder")
    public ResultVO<List<RoomOrdersVo>> selectDeniedOrder(int orderStatus) throws Exception{
        return roomOrdersService.selectDeniedOrders(orderStatus);
    };
    @GetMapping("/selectPassedOrder")
    public ResultVO<List<RoomOrdersVo>> selectPassedOrder(int orderStatus) throws Exception{
        return roomOrdersService.selectPassedOrders(orderStatus);
    };


    @PostMapping("/checkOrder")
    public ResultVO updateRoomOrder(int orderId,int orderStatus) throws Exception{
        if(orderStatus == 1){
            return roomOrdersService.updatePassedRoomOrder(orderId,orderStatus);
        }
        else {
            return roomOrdersService.updateDeniedRoomOrder(orderId,orderStatus);
        }
    };
}


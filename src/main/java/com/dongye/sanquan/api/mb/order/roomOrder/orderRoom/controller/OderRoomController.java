package com.dongye.sanquan.api.mb.order.roomOrder.orderRoom.controller;

import com.dongye.sanquan.api.mb.order.roomOrder.orderRoom.pojo.OrderRoom;
import com.dongye.sanquan.api.mb.order.roomOrder.orderRoom.service.OrderRoomService;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王练
 */

@Api("移动端自习室预约Controller")
@RestController
@RequestMapping("/mb/order/roomOrder")
public class OderRoomController {

    @Autowired
    OrderRoomService orderRoomService;
     @PostMapping("/orderRoom")
    public ResultVO orderRoom(OrderRoom orderRoom){

         return orderRoomService.addOrderData(orderRoom);
     }
}

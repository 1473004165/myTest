package com.dongye.sanquan.api.mb.order.roomorder.controller;

import com.dongye.sanquan.api.mb.order.roomorder.pojo.OrderRoom;
import com.dongye.sanquan.api.mb.order.roomorder.service.OrderRoomService;
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
@RequestMapping("/mb/order/roomorder")
public class OderRoomController {

    @Autowired
    OrderRoomService orderRoomService;
     @PostMapping("/orderRoom")
    public ResultVO orderRoom(OrderRoom orderRoom){
         return orderRoomService.addOrderData(orderRoom);
     }
}

package com.dongye.sanquan.api.mb.order.roomOrder.availableRoom.controller;

import com.dongye.sanquan.api.mb.order.roomOrder.availableRoom.pojo.vo.AvailableRoomVo;
import com.dongye.sanquan.api.mb.order.roomOrder.availableRoom.pojo.vo.OrderRequirementVo;
import com.dongye.sanquan.api.mb.order.roomOrder.availableRoom.service.OrderService;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：杨子硕
 * @date ：2021/4/14 18:42
 */
@Api("移动端自习室预约Controller")
@RestController
@RequestMapping("/mb/order/roomOrder")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/availableRoom")
    public ResultVO<List<AvailableRoomVo>> selectAvailableRoom(OrderRequirementVo orderRequirementVo) throws Exception{
        return orderService.selectAvailableRoom(orderRequirementVo);
    }

}

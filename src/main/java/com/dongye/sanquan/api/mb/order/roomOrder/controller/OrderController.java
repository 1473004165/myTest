package com.dongye.sanquan.api.mb.order.roomOrder.controller;

import com.dongye.sanquan.api.mb.order.roomOrder.pojo.vo.AvailableRoomVo;
import com.dongye.sanquan.api.mb.order.roomOrder.pojo.vo.OrderRequirementVo;
import com.dongye.sanquan.api.mb.order.roomOrder.service.OrderService;
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
@RequestMapping("/mb/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/selectRoom")
    public ResultVO<List<AvailableRoomVo>> selectAvailableRoom(OrderRequirementVo orderRequirementVo) throws Exception{
        return orderService.selectAvailableRoom(orderRequirementVo);
    }

}

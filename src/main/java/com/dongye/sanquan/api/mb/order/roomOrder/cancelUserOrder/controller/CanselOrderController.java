package com.dongye.sanquan.api.mb.order.roomOrder.cancelUserOrder.controller;

import com.dongye.sanquan.api.mb.order.roomOrder.cancelUserOrder.service.CancelOrderService;
import com.dongye.sanquan.api.mb.order.roomOrder.cancelUserOrder.service.Imp.CancelOrderServiceImpl;
import com.dongye.sanquan.pojo.rmso.ResultCode;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端控制器
 * @author 王练
 */
@Api("移动端取消预约Controller")
@RestController
@RequestMapping("/mb/order/roomOrder")
public class CanselOrderController {

    @Autowired
    CancelOrderService cancelOrderService;
    @RequestMapping("/cancelOrder")
   public ResultVO cancelOrderById(Integer orderId){
        return cancelOrderService.updateOrderStatus(orderId);
    }
}

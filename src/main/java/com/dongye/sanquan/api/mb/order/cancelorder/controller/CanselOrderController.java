package com.dongye.sanquan.api.mb.order.cancelorder.controller;

import com.dongye.sanquan.api.mb.order.cancelorder.service.Imp.CancelOrderServiceImpl;
import com.dongye.sanquan.pojo.rmso.ResultCode;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端控制器
 */
@Api("移动端取消预约Controller")
@RestController
@RequestMapping("/mb/order/cancelorder")
public class CanselOrderController {

    @Autowired
    CancelOrderServiceImpl cancelOrderServiceImpl;
    @RequestMapping("/cancelOrderById")
   public ResultVO cancelOrderById(Integer orderId){
        cancelOrderServiceImpl.updateOrderStatus(orderId);
        return new ResultVO(ResultCode.SUCCESS,"取消成功");
    }
}

package com.dongye.sanquan.api.mb.order.roomOrder.cancelUserOrder.service;

import com.dongye.sanquan.pojo.rmso.ResultVO;
import org.springframework.stereotype.Service;

@Service
public interface CancelOrderService {
    /**
     * 修改订单状态
     */
    ResultVO updateOrderStatus(Integer orderId);
}

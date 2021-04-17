package com.dongye.sanquan.api.mb.order.roomOrder.cancelOrder.service.Imp;

import com.dongye.sanquan.api.mb.order.roomOrder.cancelOrder.mapper.OrderMapper;
import com.dongye.sanquan.api.mb.order.roomOrder.cancelOrder.service.CancelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wanglian
 */
@Service
public class CancelOrderServiceImpl implements CancelOrderService {
    @Autowired
    OrderMapper orderMapper;
    /**
     * 修改订单状态
     */
    @Override
    public void updateOrderStatus(Integer orderId){
        /**
         * 更新order状态
         */
        orderMapper.updateOrderStatus(orderId);
    }
}

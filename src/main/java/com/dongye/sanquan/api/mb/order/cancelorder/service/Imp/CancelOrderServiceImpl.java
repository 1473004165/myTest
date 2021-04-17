package com.dongye.sanquan.api.mb.order.cancelorder.service.Imp;

import com.dongye.sanquan.api.mb.order.cancelorder.mapper.OrderMapper;
import com.dongye.sanquan.api.mb.order.cancelorder.service.CancelOrderService;
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

package com.dongye.sanquan.api.mb.order.roomOrder.orderRoom.service;

import com.dongye.sanquan.api.mb.order.roomOrder.orderRoom.pojo.OrderRoomVo;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import org.springframework.stereotype.Service;

/**
 * @author 王练
 *
 */
@Service
public interface OrderRoomService {
    /**
     *添加订单信息
     */
    public ResultVO addOrderData(OrderRoomVo orderRoomVo);
}

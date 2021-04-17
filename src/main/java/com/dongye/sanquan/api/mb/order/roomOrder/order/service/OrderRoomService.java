package com.dongye.sanquan.api.mb.order.roomorder.service;

import com.dongye.sanquan.api.mb.order.roomorder.pojo.OrderRoom;
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
   ResultVO addOrderData(OrderRoom orderRoom);
}

package com.dongye.sanquan.api.mb.order.roomOrder.cancelUserOrder.mapper;

import org.apache.ibatis.annotations.Update;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author wanglian
 */
@Repository
@Mapper
public interface OrderMapper  {
    /**
     * 修改订单状态
     */
    @Update("UPDATE room_order\n" +
            "SET ORDER_STATUS=5 \n" +
            "WHERE ORDER_ID=#{orderId};\n")
    void updateOrderStatus(Integer orderId);
}

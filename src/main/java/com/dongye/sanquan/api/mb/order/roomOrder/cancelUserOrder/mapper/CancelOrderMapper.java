package com.dongye.sanquan.api.mb.order.roomOrder.cancelUserOrder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dongye.sanquan.api.mb.order.roomOrder.cancelUserOrder.pojo.OrderVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author wanglian
 */
@Repository
@Mapper
public interface CancelOrderMapper extends BaseMapper<OrderVo> {
//    /**
//     * 修改订单状态
//     */
//    @Update("UPDATE room_order\n" +
//            "SET ORDER_STATUS=5 \n" +
//            "WHERE ORDER_ID=#{orderId};\n")
//    void updateOrderStatus(Integer orderId);
}

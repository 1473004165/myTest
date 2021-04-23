package com.dongye.sanquan.api.mb.order.roomOrder.orderRoom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dongye.sanquan.api.mb.order.roomOrder.orderRoom.pojo.OrderRoomVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 王练
 */
@Repository
@Mapper
public interface OrderRoomMapper extends BaseMapper<OrderRoomVo> {
    /**
     * 添加订单信息
     * @return
     */
}

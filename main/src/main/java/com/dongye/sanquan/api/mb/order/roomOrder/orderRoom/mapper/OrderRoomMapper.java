package com.dongye.sanquan.api.mb.order.roomorder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dongye.sanquan.api.mb.order.roomorder.pojo.OrderRoom;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 王练
 */
@Repository
@Mapper
public interface OrderRoomMapper extends BaseMapper<OrderRoom> {
    /**
     * 添加订单信息
     * @return
     */
}

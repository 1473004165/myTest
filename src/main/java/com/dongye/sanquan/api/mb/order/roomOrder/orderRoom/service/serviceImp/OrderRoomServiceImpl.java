package com.dongye.sanquan.api.mb.order.roomOrder.orderRoom.service.serviceImp;

import com.dongye.sanquan.api.mb.order.roomOrder.orderRoom.mapper.OrderRoomMapper;
import com.dongye.sanquan.api.mb.order.roomOrder.orderRoom.pojo.OrderRoomVo;
import com.dongye.sanquan.api.mb.order.roomOrder.orderRoom.service.OrderRoomService;
import com.dongye.sanquan.pojo.rmso.ResultCode;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 王练
 */
@Service
public class OrderRoomServiceImpl implements OrderRoomService {
    @Autowired

    OrderRoomMapper orderRoomMapper;

    /**
     * 向表中添加数据
     * @param orderRoomVo
     * @return
     */
    @Override
    public ResultVO addOrderData(OrderRoomVo orderRoomVo){
        orderRoomMapper.insert(orderRoomVo);
        return new ResultVO(ResultCode.SUCCESS,"操作成功");
    }
}

package com.dongye.sanquan.api.mb.order.roomorder.service.serviceImp;

import com.dongye.sanquan.api.mb.order.roomorder.mapper.OrderRoomMapper;
import com.dongye.sanquan.api.mb.order.roomorder.pojo.OrderRoom;
import com.dongye.sanquan.api.mb.order.roomorder.service.OrderRoomService;
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
     * @param orderRoom
     * @return
     */
    @Override
    public ResultVO addOrderData(OrderRoom orderRoom){
        orderRoomMapper.insert(orderRoom);
        return new ResultVO(ResultCode.SUCCESS,"操作成功");
    }
}

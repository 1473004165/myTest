package com.dongye.sanquan.api.pc.roomOrders.service.impl;

import com.dongye.sanquan.api.pc.roomOrders.mapper.RoomOrdersMapper;
import com.dongye.sanquan.api.pc.roomOrders.pojo.vo.RoomOrdersVo;
import com.dongye.sanquan.api.pc.roomOrders.service.RoomOrdersService;
import com.dongye.sanquan.pojo.rmso.ResultCode;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 叶翔乐
 * @since 2021-04-14
 */
@Service
public class RoomOrderServiceImpl implements RoomOrdersService {

    @Autowired
    RoomOrdersMapper roomOrdersMapper;

    @Override
    public ResultVO<List<RoomOrdersVo>> selectOrders(int orderStatus) throws Exception {
        List<RoomOrdersVo> roomOrdersVos = roomOrdersMapper.selectOrderList(orderStatus);
        if (roomOrdersVos.size() == 0) {
            if(orderStatus == 1){
                return new ResultVO(ResultCode.SUCCESS, "没有审核订单");
            }
            else if(orderStatus == 2|| orderStatus == 3 || orderStatus == 4){
                return new ResultVO(ResultCode.SUCCESS, "没有审核成功订单");
            }
            else if(orderStatus == 5){
                return new ResultVO(ResultCode.SUCCESS, "没有审核失败订单");
            }
            else{
                return new ResultVO(ResultCode.VALIDATE_FAILED, "没有改状态订单");
            }

        } else {
            return new ResultVO(roomOrdersVos);
        }
    }

    @Override
    public ResultVO updateRoomOrderStatus(int orderId, int orderStatus) throws Exception {
        int res = roomOrdersMapper.updateRoomOrderStatus(orderId, orderStatus);
        if (res == 1) {
            return new ResultVO(ResultCode.SUCCESS, "操作成功");
        }
        else {
            return new ResultVO(ResultCode.ERROR, "操作失败");
        }
    }
}

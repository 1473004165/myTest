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
    public ResultVO<List<RoomOrdersVo>> selectCheckingRoomOrders(int orderStatus) throws Exception {
        List<RoomOrdersVo> roomOrdersVos = roomOrdersMapper.selectCheckingOrderList(orderStatus);
        if (roomOrdersVos.size() == 0) {
            return new ResultVO(ResultCode.SUCCESS, "没有待审核订单");
        } else {
            return new ResultVO(roomOrdersVos);
        }
    }

    @Override
    public ResultVO<List<RoomOrdersVo>> selectDeniedOrders(int orderStatus) throws Exception {
        List<RoomOrdersVo> roomOrdersVos = roomOrdersMapper.selectDeniedOderList(orderStatus);
        if (roomOrdersVos.size() == 0) {
            return new ResultVO(ResultCode.SUCCESS, "没有审核失败订单");
        } else {
            return new ResultVO(roomOrdersVos);
        }
    }

    @Override
    public ResultVO<List<RoomOrdersVo>> selectPassedOrders(int orderStatus) throws Exception {
        List<RoomOrdersVo> roomOrdersVos = roomOrdersMapper.selectPassedOrderList(orderStatus);
        if (roomOrdersVos.size() == 0) {
            return new ResultVO(ResultCode.SUCCESS, "没有审核成功订单");
        } else {
            return new ResultVO(roomOrdersVos);
        }
    }

    @Override
    public ResultVO updatePassedRoomOrder(int orderId, int orderStatus) throws Exception {
        int res = roomOrdersMapper.updatePassedRoomOrder(orderId, orderStatus);
        if (res == 1) {
            return new ResultVO(ResultCode.SUCCESS, "操作成功");
        }
        else {
            return new ResultVO(ResultCode.VALIDATE_FAILED, "操作失败");
        }
    }

    @Override
    public ResultVO updateDeniedRoomOrder(int orderId, int orderStatus) throws Exception {
        int res = roomOrdersMapper.updateDeniedRoomOrder(orderId, orderStatus);
        if (res == 1) {
            return new ResultVO(ResultCode.SUCCESS, "操作成功");
        }
        else {
            return new ResultVO(ResultCode.VALIDATE_FAILED, "操作失败");
        }
    }
}

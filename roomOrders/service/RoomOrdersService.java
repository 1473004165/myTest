package com.dongye.sanquan.api.pc.roomOrders.service;

import com.dongye.sanquan.api.pc.roomOrders.pojo.vo.RoomOrdersVo;
import com.dongye.sanquan.pojo.rmso.ResultVO;

import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author 叶翔乐
 * @since 2021-04-14
 */
public interface RoomOrdersService  {
    /**
     * 查询数据
     *
     * @param orderStatus
     * @return ResultVO<List<RoomOrdersVo>>
     * @throws Exception
     */
    ResultVO<List<RoomOrdersVo>> selectCheckingRoomOrders(int orderStatus) throws Exception;
    /**
     * 查询数据
     *
     * @param orderStatus
     * @return ResultVO<List<RoomOrdersVo>>
     * @throws Exception
     */
    ResultVO<List<RoomOrdersVo>> selectDeniedOrders(int orderStatus) throws Exception;
    /**
     * 查询数据
     *
     * @param orderStatus
     * @return ResultVO<List<RoomOrdersVo>>
     * @throws Exception
     */
    ResultVO<List<RoomOrdersVo>> selectPassedOrders(int orderStatus) throws Exception;

    /**
     * 更新数据
     *
     * @param  orderId
     * @param orderStatus
     * @return ResultVO
     * @throws Exception
     */
    ResultVO updatePassedRoomOrder(int orderId,int orderStatus) throws Exception;

    /**
     * 更新数据
     *
     * @param  orderId
     * @param orderStatus
     * @return ResultVO
     * @throws Exception
     */
    ResultVO updateDeniedRoomOrder(int orderId,int orderStatus) throws Exception;

}

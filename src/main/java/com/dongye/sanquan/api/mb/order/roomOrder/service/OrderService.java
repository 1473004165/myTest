package com.dongye.sanquan.api.mb.order.roomOrder.service;

import com.dongye.sanquan.api.mb.order.roomOrder.pojo.vo.AvailableRoomVo;
import com.dongye.sanquan.api.mb.order.roomOrder.pojo.vo.OrderRequirementVo;
import com.dongye.sanquan.pojo.rmso.ResultVO;

import java.util.List;

/**
 * @author ：杨子硕
 * @date ：2021/4/14 11:07
 */
public interface OrderService {
    /**
     * @description：查询当前可使用研讨室
     * @param orderRequirementVo
     * @return ResultVO
     * @throws Exception
     */
    ResultVO<List<AvailableRoomVo>> selectAvailableRoom(OrderRequirementVo orderRequirementVo) throws Exception;
}

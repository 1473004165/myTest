package com.dongye.sanquan.api.mb.order.roomOrder.userOrder.service;

import com.dongye.sanquan.api.mb.order.roomOrder.userOrder.pojo.vo.UserOrderVo;
import com.dongye.sanquan.pojo.rmso.ResultVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨子硕
 * @since 2021-04-15
 */
public interface UserOrderService {

    /**
     * @description：查询当前可使用研讨室
     * @param userId
     * @return ResultVO
     * @throws Exception
     */
    ResultVO<List<UserOrderVo>> selectUserOrder(Long userId) throws Exception;

}

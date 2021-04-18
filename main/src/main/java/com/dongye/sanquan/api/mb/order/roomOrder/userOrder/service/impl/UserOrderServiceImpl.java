package com.dongye.sanquan.api.mb.order.roomOrder.userOrder.service.impl;

import com.dongye.sanquan.api.mb.order.roomOrder.userOrder.pojo.vo.UserOrderVo;
import com.dongye.sanquan.api.mb.order.roomOrder.userOrder.mapper.UserOrderMapper;
import com.dongye.sanquan.api.mb.order.roomOrder.userOrder.service.UserOrderService;
import com.dongye.sanquan.pojo.rmso.ResultCode;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨子硕
 * @since 2021-04-15
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    UserOrderMapper userOrderMapper;

    @Override
    public ResultVO<List<UserOrderVo>> selectUserOrder(Long userId) throws Exception {

        List<UserOrderVo> userOrderVoList = userOrderMapper.selectUserOrders(userId);
        if(userOrderVoList.size() == 0){
            return new ResultVO(ResultCode.SUCCESS,"未查到历史订单");
        }else {
            return new ResultVO(userOrderVoList);
        }
    }
}

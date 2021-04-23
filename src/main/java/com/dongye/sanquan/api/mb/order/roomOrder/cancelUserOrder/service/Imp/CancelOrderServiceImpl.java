package com.dongye.sanquan.api.mb.order.roomOrder.cancelUserOrder.service.Imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dongye.sanquan.api.mb.order.roomOrder.cancelUserOrder.mapper.CancelOrderMapper;
import com.dongye.sanquan.api.mb.order.roomOrder.cancelUserOrder.pojo.OrderVo;
import com.dongye.sanquan.api.mb.order.roomOrder.cancelUserOrder.service.CancelOrderService;
import com.dongye.sanquan.pojo.rmso.ResultCode;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wanglian
 */
@Service
public class CancelOrderServiceImpl implements CancelOrderService {
    @Autowired
    CancelOrderMapper cancelOrderMapper;
    /**
     * 修改订单状态
     */
    @Override
    public ResultVO updateOrderStatus(Integer orderId){
        /**
         * 更新order状态
         */
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderStatus(5);
        QueryWrapper<OrderVo> wrapper = new QueryWrapper<>();
        wrapper.eq("ORDER_ID",orderId);
        cancelOrderMapper.update(orderVo,wrapper);
        return new ResultVO(ResultCode.SUCCESS, "取消成功");
    }
}

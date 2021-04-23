package com.dongye.sanquan.api.mb.order.roomOrder.availableRoom.service.serviceImpl;

import com.dongye.sanquan.api.mb.order.roomOrder.availableRoom.mapper.OrderMapper;
import com.dongye.sanquan.api.mb.order.roomOrder.availableRoom.pojo.vo.OrderRequirementVo;
import com.dongye.sanquan.api.mb.order.roomOrder.availableRoom.service.OrderService;
import com.dongye.sanquan.api.mb.order.roomOrder.availableRoom.pojo.vo.AvailableRoomVo;
import com.dongye.sanquan.pojo.rmso.ResultCode;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：杨子硕
 * @date ：2021/4/14 11:09
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public ResultVO<List<AvailableRoomVo>> selectAvailableRoom(OrderRequirementVo orderRequirementVo) throws Exception{
        if(orderRequirementVo.getOrderPeopleNum() != null && orderRequirementVo.getOrderPeopleNum() >= 2){
            if(orderRequirementVo.getOrderStartTime() != null || orderRequirementVo.getOrderEndTime() != null){
                List<AvailableRoomVo> availableRoomVoList = orderMapper.selectAvailableRoom(orderRequirementVo);
                if(availableRoomVoList.size() == 0){
                    return new ResultVO(ResultCode.SUCCESS,"没有空闲自习室");
                }else {
                    return new ResultVO(availableRoomVoList);
                }
            }else{
                return new ResultVO(ResultCode.VALIDATE_FAILED,"预约时间不可为空!");
            }
        }else{
            return new ResultVO(ResultCode.VALIDATE_FAILED,"预约人数至少为2人！");
        }
    }
}

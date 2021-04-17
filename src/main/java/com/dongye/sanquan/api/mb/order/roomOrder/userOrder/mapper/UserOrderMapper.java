package com.dongye.sanquan.api.mb.order.roomOrder.userOrder.mapper;

import com.dongye.sanquan.api.mb.order.roomOrder.userOrder.pojo.vo.UserOrderVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 杨子硕
 * @since 2021-04-15
 */
@Repository
@Mapper
public interface UserOrderMapper {

    @Select("SELECT ORDER_ID,ORDER_GOAL,ORDER_PEOPLE_NUM,ROOM_DORM,ROOM_NAME,ROOM_CAPACITY,ORDER_START_TIME,ORDER_END_TIME,ORDER_STATUS\n" +
            "FROM room_order ro, room r\n" +
            "WHERE ro.USER_ID = #{userId}\n" +
            "AND ro.ROOM_ID = r.ROOM_ID;")
    @Results({
            @Result(column = "ORDER_ID", property = "orderId"),
            @Result(column = "ORDER_GOAL", property = "orderGoal"),
            @Result(column = "ORDER_PEOPLE_NUM", property = "orderPeopleNum"),
            @Result(column = "ROOM_DORM", property = "roomDorm"),
            @Result(column = "ROOM_NAME", property = "roomName"),
            @Result(column = "ROOM_CAPACITY", property = "roomCapacity"),
            @Result(column = "ORDER_START_TIME", property = "orderStartTime"),
            @Result(column = "ORDER_END_TIME", property = "orderEndTime"),
            @Result(column = "ORDER_STATUS", property = "orderStatus")
    })
    List<UserOrderVo> selectUserOrders(Long userId);

}

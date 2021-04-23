package com.dongye.sanquan.api.pc.roomOrders.mapper;

import com.dongye.sanquan.api.pc.roomOrders.pojo.vo.RoomOrdersVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * VIEW Mapper 接口
 * </p>
 *
 * @author 叶翔乐
 * @since 2021-04-14
 */
@Repository
@Mapper
public interface RoomOrdersMapper extends BaseMapper<RoomOrdersVo> {

    /**
     * 查询数据
     *
     * @param orderStatus
     * @return List<RoomOrdersVo>
     * @throws Exception
     */
    @Select("SELECT order_id,user_name,order_goal,ORDER_PEOPLE_NUM,o.ROOM_ID,ROOM_DORM,ROOM_NAME,ROOM_CAPACITY,ORDER_START_TIME,ORDER_END_TIME\n" +
            "from room_order o left join user u on u.user_id = o.user_id\n" +
            "left join room r on o.room_id = r.room_id\n" +
            "where order_status = #{orderStatus};")
    @Results({
            @Result(column = "ORDER_ID", property = "orderId"),
            @Result(column = "USER_NAME", property = "userName"),
            @Result(column = "ORDER_GOAL", property = "orderGoal"),
            @Result(column = "ORDER_PEOPLE_NUM", property = "orderPeopleNum"),
            @Result(column = "ROOM_ID", property = "roomId"),
            @Result(column = "ROOM_DORM", property = "roomDorm"),
            @Result(column = "ROOM_NAME", property = "roomName"),
            @Result(column = "ROOM_CAPACITY", property = "roomCapacity"),
            @Result(column = "ORDER_START_TIME", property = "orderStartTime"),
            @Result(column = "ORDER_END_TIME", property = "orderEndTime")
    })
    List<RoomOrdersVo> selectOrderList(int orderStatus);


    /**
     * 更新数据
     *
     * @param  orderId
     * @param orderStatus
     * @return ResultVO
     * @throws Exception
     */

    @Update("UPDATE ROOM_ORDER SET ORDER_STATUS = #{orderStatus} WHERE ORDER_ID = #{orderId};")
    int updateRoomOrderStatus(int orderId,int orderStatus);


}

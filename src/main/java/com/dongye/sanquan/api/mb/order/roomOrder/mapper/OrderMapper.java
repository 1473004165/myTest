package com.dongye.sanquan.api.mb.order.roomOrder.mapper;

import com.dongye.sanquan.api.mb.order.roomOrder.pojo.vo.AvailableRoomVo;
import com.dongye.sanquan.api.mb.order.roomOrder.pojo.vo.OrderRequirementVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author ：杨子硕
 * @date ：2021/4/13 21:55
 */

@Repository
@Mapper
public interface OrderMapper {
    /**
     * @description：
     */
    @Select("select ROOM_ID,ROOM_CAMPUS,ROOM_DORM,ROOM_NAME,ROOM_CAPACITY FROM room\n" +
            "WHERE ROOM_STATUS = 1 \n" +
            "AND ROOM_CAPACITY >= #{orderPeopleNum}\n" +
            "AND ROOM_CAPACITY <= #{orderPeopleNum}+2\n" +
            "AND ROOM_ID NOT IN\n" +
            "\t(SELECT ROOM_ID FROM room_order\n" +
            "\t WHERE ORDER_STATUS IN(1,2,3)\n" +
            "\t AND((ORDER_START_TIME BETWEEN #{orderStartTime} AND #{orderEndTime}) \n" +
            "\t OR (ORDER_END_TIME BETWEEN #{orderStartTime} AND #{orderEndTime})));")
    @Results({
            @Result(column = "ROOM_ID", property = "roomId"),
            @Result(column = "ROOM_CAMPUS", property = "roomCampus"),
            @Result(column = "ROOM_DORM", property = "roomDorm"),
            @Result(column = "ROOM_NAME", property = "roomName"),
            @Result(column = "ROOM_CAPACITY", property = "roomCapacity")
    })
    List<AvailableRoomVo> selectAvailableRoom(OrderRequirementVo requirementVo);
}

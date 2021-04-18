package com.dongye.sanquan.api.mb.order.roomOrder.availableRoom.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：杨子硕
 * @date ：2021/4/13 11:18
 */
@ApiModel("可用研讨室返回参数")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableRoomVo implements Serializable {
    /**
     * @description：研讨室Id
     */
    @ApiParam("研讨室Id")
    @TableField("ROOM_ID")
    private Long roomId;

    /**
     * @description：研讨室所在校区
     */
    @ApiParam("研讨室所在校区")
    @TableField("ROOM_CAMPUS")
    private String roomCampus;

    /**
     * @description：研讨室所在宿舍
     */
    @ApiParam("研讨室所在宿舍")
    @TableField("ROOM_DORM")
    private String roomDorm;

    /**
     * @description：研讨室编号
     */
    @ApiParam("研讨室编号")
    @TableField("ROOM_NAME")
    private String roomName;

    /**
     * @description：研讨室容量
     */
    @ApiParam("研讨室容量")
    @TableField("ROOM_CAPACITY")
    private Integer roomCapacity;
}

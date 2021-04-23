package com.dongye.sanquan.api.pc.roomOrders.pojo.vo;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author 叶翔乐
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="RoomOrders对象", description="VIEW")
public class RoomOrdersVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "预约订单号")
    @TableField("ORDER_ID")
    private Integer orderId;

    @ApiModelProperty(value = "用户姓名")
    @TableField("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "预约目的")
    @TableField("ORDER_GOAL")
    private String orderGoal;

    @ApiModelProperty(value = "预约人数")
    @TableField("ORDER_PEOPLE_NUM")
    private Integer orderPeopleNum;

    @ApiModelProperty(value = "房间ID")
    @TableField("ROOM_ID")
    private Integer roomId;

    @ApiModelProperty(value = "所在宿舍楼")
    @TableField("ROOM_DORM")
    private String roomDorm;

    @ApiModelProperty(value = "房间号")
    @TableField("ROOM_NAME")
    private String roomName;

    @ApiModelProperty(value = "教室容量")
    @TableField("ROOM_CAPACITY")
    private Integer roomCapacity;

    @ApiModelProperty(value = "预约开始时间")
    @TableField("ORDER_START_TIME")
    private Date orderStartTime;

    @ApiModelProperty(value = "预约结束时间")
    @TableField("ORDER_END_TIME")
    private Date orderEndTime;


}

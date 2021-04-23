package com.dongye.sanquan.api.mb.order.roomOrder.userOrder.pojo.vo;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author 杨子硕
 * @since 2021-04-15
 */
@TableName(value = "room_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="RoomOrder对象", description="")
public class UserOrderVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "预约订单号")
    @TableId(value = "ORDER_ID", type = IdType.AUTO)
    private Integer orderId;

    @ApiModelProperty(value = "预约目的")
    @TableField("ORDER_GOAL")
    private String orderGoal;

    @ApiModelProperty(value = "预约人数")
    @TableField("ORDER_PEOPLE_NUM")
    private Integer orderPeopleNum;

    @ApiModelProperty(value = "研讨室所在宿舍")
    @TableField("ROOM_DORM")
    private String roomDorm;

    @ApiModelProperty(value = "研讨室房间号")
    @TableField("ROOM_NAME")
    private String roomName;

    @ApiModelProperty(value = "房间容量")
    @TableField("ROOM_CAPACITY")
    private Integer roomCapacity;

    @ApiModelProperty(value = "预约开始时间")
    @TableField("ORDER_START_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderStartTime;

    @ApiModelProperty(value = "预约结束时间")
    @TableField("ORDER_END_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderEndTime;

    @ApiModelProperty(value = "预约状态，1：‘待审核’，2：’待使用’，3：‘使用中’，4：‘已结束’，5：’已取消‘，6：’审核失败‘")
    @TableField("ORDER_STATUS")
    private Integer orderStatus;


}

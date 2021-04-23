package com.dongye.sanquan.api.mb.order.roomOrder.orderRoom.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import sun.util.resources.LocaleData;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *预约订单对象
 * 王练
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("room_order")
public class OrderRoomVo implements Serializable {
    /**
     * 用户ID
     */
    @TableField("USER_ID")
    private Integer userId=0;
    /**
     * 研讨室ID
     */
    @TableField("ROOM_ID")
    private Integer roomId;
    /**
     * 预约目的
     */
    @TableField("ORDER_GOAL")
    private String orderGoal;
    /**
     * 预约人数
     */
    @TableField("ORDER_PEOPLE_NUM")
    private Integer  orderPeopleNum;
    /**
     * 预约开始时间
     */
    @TableField("ORDER_START_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderStartTime;
    /**
     * 预约结束时间
     */
    @TableField("ORDER_END_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderEndTime;
    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date creatTime=new Date();
    /**
     * 预约状态
     */
    @TableField("ORDER_STATUS")
    private Integer orderStatus=1;
}

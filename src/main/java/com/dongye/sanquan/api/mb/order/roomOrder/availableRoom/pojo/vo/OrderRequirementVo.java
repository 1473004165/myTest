package com.dongye.sanquan.api.mb.order.roomOrder.availableRoom.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author ：杨子硕
 * @date ：2021/4/13 15:55
 */
@ApiModel("查找可用研讨室请求参数")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequirementVo implements Serializable {

    /**
     * @description：预约人数
     */
    @ApiParam("预约人数")
    @TableField("ORDER_PEOPLE_NUM")
    private Long orderPeopleNum;

    /**
     * @description：预约人数
     */
    @ApiParam("预约开始时间")
    @TableField("ORDER_START_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderStartTime;

    /**
     * @description：预约人数
     */
    @ApiParam("预约结束时间")
    @TableField("ORDER_END_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderEndTime;


}

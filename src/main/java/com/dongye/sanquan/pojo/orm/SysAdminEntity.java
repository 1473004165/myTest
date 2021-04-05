package com.dongye.sanquan.pojo.orm;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 章卜
 * @version 1.0
 * @date 2021/04/04 13:25
 */
@TableName(value = "admin_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysAdminEntity implements Serializable {

    /**
     * 用户id
     */
    @ApiModelProperty("用户ID")
    @TableId(value = "ADMIN_ID",type = IdType.AUTO)
    private Long adminId;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名称")
    @TableField(value = "ADMIN_NAME",exist = true)
    private String adminName;

    /**
     * 账号
     */
    @ApiParam("系统账号")
    private String loginId;

    /**
     * 密码
     */
    @ApiModelProperty("登录密码")
    @TableField(value = "PASSWORD",exist = true)
    @JSONField(serialize = false)
    private String password;

    /**
     * 盐值
     */
    @ApiModelProperty("盐值")
    @TableField(value = "SALT")
    private byte[] salt;

    /**剩余的其他字段*/

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间 ")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}

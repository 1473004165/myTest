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
import java.util.Date;

/**
 * 功能描述
 *
 * @author 冉翔
 * @date 2021/4/18
 **/
@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserEntity implements Serializable {
    @ApiModelProperty("用户ID")
    @TableId(value = "USER_ID",type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty("登录ID")
    private String userLoginId;

    @ApiModelProperty("学号")
    private String studentId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户学院")
    private String userCollege;

    @ApiModelProperty("专业")
    private String userMajor;

    @ApiModelProperty("用户班级")
    private String userClass;

    @ApiModelProperty("认证信息")
    private String userEvidence;

    @ApiModelProperty("用户描述")
    private String userDescribe;

    @ApiModelProperty("微信openID")
    private String weixinOpenid;

    @ApiModelProperty("用户信用分")
    private Float userCredit;

    @ApiModelProperty("三全分")
    private Integer userScore;

    @ApiModelProperty("用户昵称")
    private String userNickname;

    @ApiModelProperty("用户手机号")
    private String userMobile;

    @ApiModelProperty("用户头像")
    private String userAvatar;

    @ApiModelProperty("用户状态")
    private Integer userStatus;

    @ApiModelProperty("学霸标识")
    private Integer isWellStu;

    @ApiModelProperty("盐值")
    private String salt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间 ")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}

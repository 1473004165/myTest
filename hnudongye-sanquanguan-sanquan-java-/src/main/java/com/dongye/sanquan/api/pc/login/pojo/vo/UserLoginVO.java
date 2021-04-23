package com.dongye.sanquan.api.pc.login.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**用户登录请求参数
 * @author 赖柄沣 bingfengdev@aliyun.com
 * @version 1.0
 * @date 2020/8/24 17:06
 */
@ApiModel("登录请求参数")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVO implements Serializable {

    /**
     * 验证码key
     */
    @ApiParam("验证码key")
    private String token;

    /**
     * 验证码value
     */
    @ApiParam("验证码value")
    private String code;

    /**
     * 账号
     */
    @ApiParam("系统账号")
    private String loginId;

    /**
     * 密码
     */
    private String password;

}

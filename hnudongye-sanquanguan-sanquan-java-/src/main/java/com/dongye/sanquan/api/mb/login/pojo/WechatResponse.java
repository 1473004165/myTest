package com.dongye.sanquan.api.mb.login.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**微信认证响应结果
 * @author 冉翔
 * @date 2021/04/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class WechatResponse implements Serializable {

    /**
     * errcode 的合法值
     *
     * 值	说明	最低版本
     * -1	系统繁忙，此时请开发者稍候再试
     * 0	请求成功
     * 40029	code 无效
     * 45011	频率限制，每个用户每分钟100次
     */
    private Integer errcode;
    private String errmsg;
    private String session_key;
    private String openid;
}

package com.dongye.sanquan.api.pc.login.controller;

import com.dongye.sanquan.api.pc.login.pojo.vo.UserLoginVO;
import com.dongye.sanquan.pojo.login.LoginType;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import com.dongye.sanquan.security.token.CustomizedToken;
import com.dongye.sanquan.utils.RedisUtils;
import com.dongye.sanquan.utils.ShiroUtils;
import com.google.code.kaptcha.impl.DefaultKaptcha;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**用户登录模块
 * <p>@author 章卜 </p>
 * <p>@date 2021/4/4 </p>
 */
@RestController
@RequestMapping("pc/")
@Api("管理端用户登录模块")
public class LoginController {
    private static final String ADMIN_LOGIN_TYPE = LoginType.ADMIN.toString();

    private final Logger logger =  LoggerFactory.getLogger(LoginController.class);

    @Resource
    private DefaultKaptcha producer;
    @Resource
    private RedisUtils redisUtils;

    /** 用户登录接口
     * @author 章卜
     * @date 2021-04-04 16:55:19
     * @param userVO 登录参数，包含username，password
     * @return java.util.Map<String,Object>
     * @throws IncorrectCredentialsException 用户不存在或者密码错误
     * @throws LockedAccountException 账户已冻结
     */
    @ApiOperation("登录")
    @PostMapping("/login")
    public ResultVO login(@RequestBody @ApiParam(name = "用户登录参数")
                                      UserLoginVO userVO)
            throws IncorrectCredentialsException,LockedAccountException{


        if (userVO.getCode()==null || "".equals(userVO.getCode())){
            return ResultVO.error("请输入验证码");
        }

        if (userVO.getToken()==null|| "".equals(userVO.getToken())){
            return ResultVO.error("验证码错误");
        }

        //1.校验验证码
        String code = (String) redisUtils.get(userVO.getToken());
        //String code = stringRedisTemplate.opsForValue().get(userVO.getToken());
        if (code == null|| !code.equals(userVO.getCode())){
            return ResultVO.error("验证码错误");
        }else {
            //使验证码过期
            redisUtils.expire(userVO.getToken(),1);
            //stringRedisTemplate.expire(userVO.getToken(),1,TimeUnit.SECONDS);
        }



//     =======开始验证账号==================================================

        String principal = "";

        //账号登录
        if(userVO.getLoginId()!=null&&!"".equals(userVO.getLoginId())){
            principal = userVO.getLoginId();
        }

        //没有输入账号
        if ("".equals(principal)){
            return ResultVO.error("请输入账号");
        }

        //没有输入密码
        if (userVO.getPassword()==null || "".equals(userVO.getPassword())){
            return ResultVO.error("请输入密码");
        }

        //进行身份验证
        try{
            //验证身份和登陆
            Subject subject = SecurityUtils.getSubject();
            System.out.println(userVO.toString());
            CustomizedToken customizedToken = new CustomizedToken(principal, userVO.getPassword(),ADMIN_LOGIN_TYPE);
//            UsernamePasswordToken token = new UsernamePasswordToken(principal, userVO.getPassword());
            //验证成功进行登录操作
            subject.login(customizedToken);
        }catch (IncorrectCredentialsException e) {
            return ResultVO.error("用户不存在或者密码错误");
        } catch (LockedAccountException e) {

            return ResultVO.error("登录失败，此账号已被冻结");
        } catch (AuthenticationException e) {

            return ResultVO.error("用户不存在或者密码错误");
        } catch (Exception e) {
            return ResultVO.error("未知的异常，请稍后重试");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("token", ShiroUtils.getSession().getId().toString());


        return ResultVO.ok().data(map);
    }



    /**
     * 未登录
     *
     */
    @ApiOperation("未登录")
    @RequestMapping("/unauth")
    public void unauth(HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<>();
        map.put("code",500);
        map.put("msg","未登录");
        response.sendRedirect("/login.html");
    }


    /**
     * 登出
     * @return
     * @throws IOException
     */
    @ApiOperation("登出")
    @PostMapping("/logout")
    public ResultVO logout() throws IOException {
       ShiroUtils.logout();
       return ResultVO.ok();
    }

    /**
     * 前后端分离 登录验证码 方案
     * 后端生成图片 验证码字符串 uuid
     * uuid为key  验证码字符串为value
     * 传递bs64图片 和uuid给前端
     * 前端在登录的时候 传递 账号 密码 验证码 uuid
     * 通过uuid获取 验证码 验证
     * @return
     * @throws IOException
     */
    @ApiOperation("验证码")
    @GetMapping("/authcode")
    public ResultVO getAuthCode() throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //获取验证码
        String text = producer.createText();


        BufferedImage image = producer.createImage(text);
        ImageIO.write(image, "png", out);
        String base64bytes =  Base64.encode(out.toByteArray());

        //该字符串传输至前端放入src即可显示图片，安卓可以去掉data:image/png;base64,
        String src = "data:image/png;base64," + base64bytes;
        String token = UUID.randomUUID().toString();
        token = "VI_"+token;
        logger.info("登录验证码value："+text);
        logger.info("登录验证码key："+token);
        Map<String, Object> map = new HashMap<>(2);
        map.put("token", token);
        map.put("img_src", src);
        redisUtils.set(token,text,3*60);
//        ValueOperations<String, String> vot = stringRedisTemplate.opsForValue();
//                vot.set(token, text);
//               stringRedisTemplate.expire(token,3, TimeUnit.MINUTES);

        return ResultVO.ok().data(map);
    }


}




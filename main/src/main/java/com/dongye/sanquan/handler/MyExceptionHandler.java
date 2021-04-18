package com.dongye.sanquan.handler;

import com.alibaba.fastjson.JSONException;

import com.dongye.sanquan.api.pc.login.controller.LoginController;
import com.dongye.sanquan.pojo.rmso.ResultVO;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.el.MethodNotFoundException;
import java.util.Arrays;

/**
 * @author 章卜
 * @version 1.0
 * @date 2021/04/04 13:25
 */
@RestControllerAdvice(basePackages = "com.onedata.qsm.api")
public class MyExceptionHandler {
    private Logger logger =  LoggerFactory.getLogger(LoginController.class);


    @ExceptionHandler(value = JSONException.class)
    public ResultVO jsonExceptionHandler(JSONException e) {
        logger.error("JSON数据转换类型错误:"+e.getMessage()+ Arrays.toString(e.getStackTrace()));
        return ResultVO.error("JSON数据转换类型错误"+e.getLocalizedMessage());
    }

    @ExceptionHandler(value = MethodNotFoundException.class)
    public ResultVO methodNotFoundExceptionHandler(MethodNotFoundException e) {
        logger.error("资源不存在"+e.getMessage() + Arrays.toString(e.getStackTrace()));
        return ResultVO.error("资源不存在"+e.getLocalizedMessage());
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResultVO nullExceptionHandler(NullPointerException e) {
        logger.error("空指针异常"+e.getMessage() + Arrays.toString(e.getStackTrace()));
        return ResultVO.error("空指针异常"+ Arrays.toString(e.getStackTrace()));
    }



    @ExceptionHandler(value = AuthorizationException.class)
    public ResultVO authorizationExceptionHandler(AuthorizationException e){
        return ResultVO.error("权限不足，请联系公司管理员授权");
    }

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public ResultVO httpMediaTypeNotSupportedExceptionHandler(HttpMediaTypeNotSupportedException e){
        return ResultVO.error("不支持的媒体类型"+e.getLocalizedMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResultVO exceptionHandler(Exception e) {
        logger.error(e.getMessage());
        logger.error(Arrays.toString(e.getStackTrace()));
        return ResultVO.error("服务升级维护中，请稍后重试"+e.getMessage());
    }






}

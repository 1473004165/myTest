package com.dongye.sanquan.api.mb.login.utils;

import java.io.IOException;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  Json字符串转换工具类
 * @author 冉翔
 * @date 2021/04/14
 */
public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    //字符串转对象
    public static <T> T string2Obj(String str,Class<T> clazz){
        if (StringUtils.isEmpty(str) || clazz == null){
            return null;
        }
        try {
            return clazz.equals(String.class)? (T) str :objectMapper.readValue(str,clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
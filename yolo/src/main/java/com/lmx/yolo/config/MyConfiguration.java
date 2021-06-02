package com.lmx.yolo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/templates/");
        //和页面有关的静态目录都放在项目的static目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //上传的图片在D盘下的OTA目录下，访问路径如：http://localhost:8081/OTA/d3cf0281-bb7f-40e0-ab77-406db95ccf2c.jpg
        //其中OTA表示访问的前缀。"file:D:/OTA/"是文件真实的存储路径
        registry.addResourceHandler("/outputPath/**").addResourceLocations("file:C:/Users/Legion/Desktop/outputPath/");
        registry.addResourceHandler("/storePath/**").addResourceLocations("file:C:/Users/Legion/Desktop/storePath/");///uploadImage/
        registry.addResourceHandler("/result/**").addResourceLocations("file:C:/Users/Legion/Desktop/result/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").
                allowedOrigins("POST","GET","OPTIONS","PUT").allowCredentials(true);
    }
}
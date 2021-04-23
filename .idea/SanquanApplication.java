package com.dongye.sanquan;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement(proxyTargetClass = true)//开启事务,强制使用CGLIB代理
@MapperScan("com.dongye.sanquan.api.**.mapper")
@EnableSwagger2Doc
@EnableScheduling
public class SanquanApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanquanApplication.class, args);
    }

}

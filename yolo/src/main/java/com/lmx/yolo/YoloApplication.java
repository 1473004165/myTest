package com.lmx.yolo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;

@EnableAsync
@RestController
@SpringBootApplication
public class YoloApplication {

    public static void main(String[] args) {
//        SpringApplication.run(YoloApplication.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(YoloApplication.class);
        builder.headless(false).run(args);
    }

}

package com.rx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean(name = "docket")
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApi())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rx.controller"))
                .build();
    }

    private ApiInfo getApi(){
        Contact contact = new Contact("冉翔","https://e.coding.net/hnudongye/sanquanguan/Springboot_Test.git","rx1473004165@outlook.com");
        return new ApiInfo(
                "冉翔的Api文档",
                "一个api文档",
                "v 1.0",
                "https://e.coding.net/hnudongye/sanquanguan/Springboot_Test.git",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }

}

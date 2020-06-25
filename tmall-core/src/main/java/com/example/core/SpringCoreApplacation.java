package com.example.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@EnableEurekaClient
@EnableConfigurationProperties
@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.core")
public class SpringCoreApplacation {


    private static String test;

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(SpringCoreApplacation.class, args);
    }


}

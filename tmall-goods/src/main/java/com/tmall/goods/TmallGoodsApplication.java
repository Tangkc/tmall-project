package com.tmall.goods;


import com.example.core.user.util.RedisUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@EnableConfigurationProperties
@SpringBootApplication
@EnableFeignClients(basePackages = "com.tmall.goods")
public class TmallGoodsApplication {


    public static void main(String[] args) {
        SpringApplication.run(TmallGoodsApplication.class, args);
    }


    @Bean
    public RedisUtil getRedisUtil(){
        return new RedisUtil();
    }
}

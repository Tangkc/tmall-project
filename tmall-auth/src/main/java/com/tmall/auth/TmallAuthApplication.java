package com.tmall.auth;


import com.example.core.user.util.RedisUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@EnableConfigurationProperties
@SpringBootApplication
@EnableFeignClients(basePackages = "com.tmall.auth")
public class TmallAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmallAuthApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new Md4PasswordEncoder();
    }

    @Bean
    public RedisUtil getRedisUtil(){
        return new RedisUtil();
    }

}

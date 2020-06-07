package com.example.tmalleurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class TmallEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmallEurekaServerApplication.class, args);
    }

}

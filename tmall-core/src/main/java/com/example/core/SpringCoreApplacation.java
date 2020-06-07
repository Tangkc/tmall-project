package com.example.core;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.concurrent.TimeUnit;

@EnableSwagger2
@EnableEurekaClient
@EnableConfigurationProperties
@SpringBootApplication
public class SpringCoreApplacation {


    private static String test;

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(SpringCoreApplacation.class, args);
        while(true) {

            System.err.println(test);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Value("${downloadCenter.downloadUrl}")
    public void setSiteUrl(String myUrl) {
        System.out.println(myUrl);
        test = myUrl;
    }

}

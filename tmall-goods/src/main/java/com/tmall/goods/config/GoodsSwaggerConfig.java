package com.tmall.goods.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class GoodsSwaggerConfig {
    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.SWAGGER_2).groupName("tmall")
                .apiInfo(apiInfo("Tmall商城","",""))
                .select()
            .apis(RequestHandlerSelectors.basePackage("com.tmall.goods"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo(String name, String description, String version) {
        ApiInfo apiInfo = new ApiInfoBuilder().title(name).description(description).version(version).build();
        return apiInfo;
    }
}

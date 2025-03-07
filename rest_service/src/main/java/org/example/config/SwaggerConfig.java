package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;


@Configuration
public class SwaggerConfig {

    //доступен по адресу: http://localhost:rest/swagger-ui/
    @Bean
    public Docket apiV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.example.v1.controller"))
                .paths(PathSelectors.regex("/api/v1/*.*"))
                .build()
                .apiInfo(apiInfo("v1"))
                .groupName("v1")
                .useDefaultResponseMessages(false);
    }

    @Bean
    public Docket apiV2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.example.v2.controller"))
                .paths(PathSelectors.regex("/api/v2/*.*"))
                .build()
                .apiInfo(apiInfo("v2"))
                .groupName("v2")
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo(String version) {
        return new ApiInfo(
                "Calculator REST API",
                "REST Api for calculating",
                version,
                "Terms of service",
                new Contact("Ivan Minchenko",
                        "t.me/vanchessco",
                        "ewan.min4enko@yandex.ru"),
                "License",
                "License url",
                Collections.emptyList());
    }
}

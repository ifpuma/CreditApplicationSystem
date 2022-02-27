package com.paycorepinarozdil.CreditApplicationSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/api/customer.*"), regex("/api/credit-application.*"),regex("/api/credit-result.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Credit Application System for Paycore")
                .description("Credit Application System with Spring Boot reference for developers")
                .termsOfServiceUrl("http://localhost:8080")
                .contact(new Contact("Pınar Özdil","","pinarrozdil@gmail.com")).license("")
                .licenseUrl("").version("1.0").build();
    }

}
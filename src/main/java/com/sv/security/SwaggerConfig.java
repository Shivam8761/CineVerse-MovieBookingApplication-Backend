package com.sv.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CineVerse Movie Booking API")
                        .version("1.0")
                        .description("CineVerse is a Movie Booking REST API built using Spring Boot, Spring Security JWT, Spring Data JPA, and MySQL. It provides secure authentication, role-based authorization, movie management, theater management, show scheduling, and seat booking functionality.")
                        .contact(new Contact()
                                .name("Shivam Vishwakarma")
                                .email("shivamvishwakarma6781@gmail.com")));
    }
}
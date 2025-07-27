package com.example.bookstoreapi.util;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class ApplicationConfiguration {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components())
                .info(new Info().title("Bookstore API")
                        .description("Bookstore API is a RESTful service for managing books and authors. "
                                + "This system allows users to add, update, delete and fetch books, as well as manage author information. "
                                + "It is built using Java, Spring Boot, and H2 database, and supports full CRUD operations.")
                        .version("1.0")
                        .contact(new Contact().name("Srinivas Jella").email("srinivas45jella@gmail.com"))   
                        .license(new License().name("Copyright (c) 2025 Srinivas Jella")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("com.example.bookstoreapi")
                .build();
    }
}

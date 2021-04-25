package com.example.sportgamesmanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages= {"com.example"})
@ComponentScan({"com.example.sportgamesmanagement.mapper"})
@OpenAPIDefinition
public class SportGamesManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportGamesManagementApplication.class, args);
    }

}

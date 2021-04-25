package com.example.sportgamesmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.sportgamesmanagement.mapper"})
public class SportGamesManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportGamesManagementApplication.class, args);
    }

}

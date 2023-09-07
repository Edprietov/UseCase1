package com.example.usecase1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import controller.CountryController;

@SpringBootApplication
public class UseCase1Application {

    public static void main(String[] args) {
        SpringApplication.run(UseCase1Application.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CountryController getCountryController() {
        return new CountryController();
    }
}

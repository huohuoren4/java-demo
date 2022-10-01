package com.example.demo02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class Demo02Application {
    public static void main(String[] args) {
		SpringApplication.run(Demo02Application.class, args);
    }
}

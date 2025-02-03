package com.example.course.week1.BeanLecture;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    Apple getApple(){
        System.out.println("given preference");
        return new Apple();
    }

}

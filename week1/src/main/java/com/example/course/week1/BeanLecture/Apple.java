package com.example.course.week1.BeanLecture;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Apple {
    public void eatApple(){
        System.out.println("Eating apple");
    }

    @PostConstruct
    public void after(){
        System.out.println("After creation");
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("Before destroy");
    }
}

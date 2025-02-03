package com.example.course.week1.DependencyInjectionLecture;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "deploy.env", havingValue = "prod")
public class ProdDB implements DB {
    public String getData(){
        return "Prod Data";
    }
}

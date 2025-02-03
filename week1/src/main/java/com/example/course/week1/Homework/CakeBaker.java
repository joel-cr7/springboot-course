package com.example.course.week1.Homework;

import org.springframework.stereotype.Component;

@Component
public class CakeBaker {
    private final Frosting frosting;
    private final Syrup syrup;

    public CakeBaker(Frosting frosting, Syrup syrup){
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake(){
        System.out.println("Frosting type: " + frosting.getFrostingType());
        System.out.println("Syrup type: " + syrup.getSyrupType());
        System.out.println("Baking the cake !!");
    }
}

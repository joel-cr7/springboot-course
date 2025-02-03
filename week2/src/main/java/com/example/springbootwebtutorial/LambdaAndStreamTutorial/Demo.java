package com.example.springbootwebtutorial.LambdaAndStreamTutorial;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {

        // LAMBDA

        // Traditional way of implementing interface is creating new class
        // Another way of implementing interface using anonymous class as shown below

        //    Walkable walkable = new Walkable() {
        //        @Override
        //        public int walk(int steps) {
        //            return 0;
        //        }
        //    };

        // implementing interface using Lambda
        // Note: can use lambda only with Functional interface
//        Walkable walkable = (step) -> {
//            System.out.println("Walking fact " + step);
//            return 0;
//        };
//        walkable.walk(4);



        // STREAMS
        // Note: once a stream is accessed it cant be used again
        List<String> fruits = List.of("Apple", "Banana", "Mango");

//        Stream<String> stream = fruits.stream();
//        stream
//                .map(String::length)
//                .filter(length -> length <5)
//                .map(fruitLength -> fruitLength*2)      // convert one type to another using map
//                .forEach(fruit -> System.out.println(fruit));

        Map<String, Integer> fruitLen = fruits.stream()
                .collect(Collectors.toMap(
                        fruit -> fruit,     // key
                        String::length   // value (using method reference "class::methodName")
                        ));
        System.out.println(fruitLen);
    }
}



@FunctionalInterface
interface Walkable{
    int walk(int steps);

    default int walk2(int steps) {
        return 0;
    }
}
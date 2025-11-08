package com.example.sec02;

import com.example.common.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {
    public static void main(String[] args) {
//        getUsername(1)
//                .subscribe(Util.subscriber("Subscriber 1"));
//
//        getUsername(2)
//                .subscribe(Util.subscriber("Subscriber 2"));
//
//        getUsername(3)
//                .subscribe(Util.subscriber("Subscriber 3"));
//
        getUsername(3)
                .subscribe(System.out::println);
    }

    private static Mono<String> getUsername(int userId){
        return switch (userId){
            case 1 -> Mono.just("Abhishek");
            case 2 -> Mono.empty(); // Giving NUll
            default -> Mono.error(new RuntimeException("Invalid Input"));
        };
    }
}

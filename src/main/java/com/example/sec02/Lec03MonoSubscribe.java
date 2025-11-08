package com.example.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    private static final Logger logger = LoggerFactory.getLogger(Lec01LazyStream.class);

    public static void main(String[] args) {

        var mono = Mono.just(1);

        mono.subscribe(
                i -> logger.info("Recieved : {}", i),
                err -> logger.error("Error :- ", err),
                () -> logger.info("Completed"),
                subscription -> {
                    logger.info("Subscribed!!!");
//                    throw new RuntimeException("Failed...");
                    subscription.request(5);
                });
    }
}

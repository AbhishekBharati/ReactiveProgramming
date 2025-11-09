package com.example.sec02;

import com.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec09FromFuture {
    public static Logger log = LoggerFactory.getLogger(Lec09FromFuture.class);

    public static void main(String[] args) {
        // Even Though we haven't attached Subscriber still it will execute the completableFuture
        // :- Therefore, we wrap it up in supplier in next line
        Mono.fromFuture(getName());

        Mono.fromFuture(() -> getName())
                .subscribe(Util.subscriber());

        // This is Because completableFuture is executing different Thread so if main thread is terminated before it won't show the result.
        Util.sleepSeconds(1);
    }

    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(() -> {
            log.info("Generating Name :- ");
            return Util.faker.name().firstName();
        });
    }
}

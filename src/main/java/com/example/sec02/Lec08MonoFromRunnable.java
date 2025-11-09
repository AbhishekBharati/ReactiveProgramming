package com.example.sec02;

import com.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    private static final Logger log = LoggerFactory.getLogger(Lec08MonoFromRunnable.class);

    public static void main(String[] args) {
        getProducName(2)
                .subscribe(Util.subscriber());
    }

    public static Mono<String> getProducName(int productId){
        if(productId == 1) return Mono.fromSupplier(() -> Util.getFaker().commerce().productName());
        return Mono.empty();
//        return Mono.fromRunnable(() -> notifyBusiness(productId));
    }

    public static void notifyBusiness(int productId){
        log.info("Notifying business that the product Id isn't available : {}", productId);
    }
}

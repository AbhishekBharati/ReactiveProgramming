package com.example.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec07MonoFromCalllable {

    private static final Logger log = LoggerFactory.getLogger(Lec07MonoFromCalllable.class);

    public static void main(String[] args) {

        var list = List.of(1,2,3);
        Mono.fromSupplier(() -> {
            try {
                return sum(list);
            } catch (Exception e){
                log.error(e.getMessage());
                return e;
            }
        });

    }

    private static int sum(List<Integer> list) throws Exception {
        log.info("Finding the sum of {},",list);
        return list.stream().mapToInt(a -> a).sum();
    }
}

package com.example.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lec01LazyStream {

    private static final Logger logger = LoggerFactory.getLogger(Lec01LazyStream.class);

    public static void main(String[] args){
        List<Integer> arrayList =  Stream.of(1,5)
                .peek(i -> {
                    logger.info("Received : {}", i);
                })
                .collect(Collectors.toList());

        for(var li : arrayList){
            System.out.println(li);
        }
    }
}

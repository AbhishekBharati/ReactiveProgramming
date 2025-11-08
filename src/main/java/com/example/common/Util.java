package com.example.common;

import org.reactivestreams.Subscriber;

public class Util {

    public static <T>Subscriber<T> subscriber(){
        return new DefaultSubscriberImpl<>("");
    }

    public static <T>Subscriber<T> subscriber(String name){
        return new DefaultSubscriberImpl<>(name);
    }
}

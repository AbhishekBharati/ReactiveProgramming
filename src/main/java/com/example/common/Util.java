package com.example.common;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

public class Util {

    public static Faker faker = Faker.instance();
    public static <T>Subscriber<T> subscriber(){
        return new DefaultSubscriberImpl<>("");
    }

    public static <T>Subscriber<T> subscriber(String name){
        return new DefaultSubscriberImpl<>(name);
    }

    public static Faker getFaker() {
        return faker;
    }
}

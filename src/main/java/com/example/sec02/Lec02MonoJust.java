package com.example.sec02;

import com.example.sec01.subscriber.SubscriberImpl;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {
        // This publisher will emit only one value that is Abhishek.
        Mono<String> mono = Mono.just("Abhishek");
        System.out.println(mono);

        var subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);

        subscriber.getSubscription().request(10);

//        Why we need Mono.just(); --> Suppose we've the value in memory and we need to pass Publisher to someone else then it is useful
//        ex :-
        save(Mono.just("Abhishek"));
    }

    private static void save(Publisher<String> publisher){

    }
}

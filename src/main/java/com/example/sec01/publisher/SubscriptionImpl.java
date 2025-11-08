package com.example.sec01.publisher;

import com.example.sec01.subscriber.SubscriberImpl;
import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {

    private static final Logger logger = LoggerFactory.getLogger(SubscriberImpl.class);
    private final Faker faker;
    private static final int MAX_ITEMS = 10;
    private int count = 0;

    private final Subscriber<? super String> subscriber;
    private boolean isCancelled;

    public SubscriptionImpl(Subscriber<? super String> subscriber){
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long requested) {
        if(isCancelled){
            return;
        }
        logger.info("Subscriber has requested {} items", requested);
        for(int i = 0; i < requested && count < MAX_ITEMS; i++){
            count++;
            this.subscriber.onNext(this.faker.internet().emailAddress());
        }
        if(count == MAX_ITEMS) {
            logger.info("No more data to produce");
            this.subscriber.onComplete();
            this.isCancelled = true;
        }
    }

    @Override
    public void cancel() {
        logger.info("Subscriber is Cancelled");
        this.isCancelled = true;
    }
}

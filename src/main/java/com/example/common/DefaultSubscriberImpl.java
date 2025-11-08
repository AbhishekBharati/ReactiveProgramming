package com.example.common;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSubscriberImpl<T> implements Subscriber<T> {
    private static final Logger log = LoggerFactory.getLogger(DefaultSubscriberImpl.class);
    private final String name;
//    One publisher can be subscribed by many publishers so to distinguish who get's the data and who doesn't we're tracking name.
    public DefaultSubscriberImpl(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T t) {
        log.info("{} Received : {}",this.name, t);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("{} Error :- ",this.name, throwable);
    }

    @Override
    public void onComplete() {
        log.info("{} Completed!!!", this.name);
    }
}

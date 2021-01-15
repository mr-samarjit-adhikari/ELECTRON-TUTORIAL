package com.example.webclientdemo.clients;

import org.reactivestreams.Subscription;
import org.springframework.web.reactive.function.client.ClientResponse;

public abstract class DefaultWebClientResponseHandler implements ApiWebClientResponseHandler {
    private Subscription subscription;
    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request( Long.MAX_VALUE);
    }

    @Override
    public void onNext(ClientResponse clientResponse) {
        System.out.println(clientResponse);
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}

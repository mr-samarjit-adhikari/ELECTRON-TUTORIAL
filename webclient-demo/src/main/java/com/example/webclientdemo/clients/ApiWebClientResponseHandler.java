package com.example.webclientdemo.clients;

import org.reactivestreams.Subscriber;
import org.springframework.web.reactive.function.client.ClientResponse;

public interface ApiWebClientResponseHandler extends Subscriber<ClientResponse> {
}

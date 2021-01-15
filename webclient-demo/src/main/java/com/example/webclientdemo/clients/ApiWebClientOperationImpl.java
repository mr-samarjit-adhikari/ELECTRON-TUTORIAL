package com.example.webclientdemo.clients;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.ExchangeFunctions;
import org.springframework.web.util.UriBuilderFactory;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;

public class ApiWebClientOperationImpl implements ApiClientOperation {
    private UriBuilderFactory factory;
    private ApiWebClientResponseHandler responseHandler;
    private HttpMethod  operationType;
    private Scheduler scheduler;

    private ApiWebClientOperationImpl(UriBuilderFactory factory,ApiWebClientResponseHandler handler){
        this.factory = factory;
        this.responseHandler = handler;
        scheduler = Schedulers.newParallel("commandrun-executor");
    }

    public ApiWebClientOperationImpl(HttpMethod operationType,UriBuilderFactory factory,
                                     ApiWebClientResponseHandler handler){
        this(factory,handler);
        this.operationType = operationType;
    }

    @Override
    public void execute(Long timeout, TimeUnit unit) {
        ExchangeFunction exchangeFunction = ExchangeFunctions.create(new ReactorClientHttpConnector());
        ClientRequest clientRequest = ClientRequest.create(operationType,factory.builder().build()).build();
        Mono<ClientResponse> monoClientResponse = exchangeFunction.exchange(clientRequest);
        monoClientResponse.log().publishOn(scheduler)
                .subscribeOn(scheduler)
                .subscribe(responseHandler);
    }
}

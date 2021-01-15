package com.example.webclientdemo.clients;

import com.example.webclientdemo.service.ApiClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.ClientResponse;

public class CcmWebLoginResponseHandlerImpl extends DefaultWebClientResponseHandler {
    private ApiClientService clientService;

    @Autowired
    public CcmWebLoginResponseHandlerImpl(ApiClientService clientService){
        super();
        this.clientService = clientService;
    }

    @Override
    public void onNext(ClientResponse clientResponse) {
        System.out.println("++++ CcmWebLoginResponseHandlerImpl Called...");
        System.out.println(clientResponse);
    }
}

package com.example.webclientdemo.service;

import com.example.webclientdemo.clients.ApiClientOperation;

public interface ApiClientService {
    void run();
    void addClientOperation(ApiClientOperation operation);
}

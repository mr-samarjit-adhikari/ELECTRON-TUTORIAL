package com.example.webclientdemo.clients;

import java.util.concurrent.TimeUnit;

public interface ApiClientOperation {
    void execute(Long timeout, TimeUnit unit);
}

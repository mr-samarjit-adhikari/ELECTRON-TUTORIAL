package com.example.webclientdemo.service;

import com.example.webclientdemo.clients.ApiClientOperation;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

@Service
public class ApiWebClientServiceImpl implements ApiClientService{
    private Queue<ApiClientOperation> clientOperationList;
    private long defaultCmdTimeOut = 30; //30 second

    public ApiWebClientServiceImpl(){
        this.clientOperationList = new ConcurrentLinkedQueue<>();
    }

    @Override
    public synchronized void run() {
        while(!clientOperationList.isEmpty()) {
            ApiClientOperation operation = clientOperationList.poll();
            operation.execute(defaultCmdTimeOut, TimeUnit.SECONDS);
        }
    }

    @Override
    public synchronized void addClientOperation(ApiClientOperation operation) {
        clientOperationList.add(operation);
    }

}

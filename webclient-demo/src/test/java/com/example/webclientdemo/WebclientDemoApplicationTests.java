package com.example.webclientdemo;

import com.example.webclientdemo.clients.ApiClientOperation;
import com.example.webclientdemo.clients.ApiWebClientOperationImpl;
import com.example.webclientdemo.clients.ApiWebClientResponseHandler;
import com.example.webclientdemo.clients.CcmWebLoginResponseHandlerImpl;
import com.example.webclientdemo.service.ApiClientService;
import com.example.webclientdemo.service.ApiWebClientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.DefaultUriBuilderFactory;

@SpringBootTest
class WebclientDemoApplicationTests {
	private final String CCM_WEB_BASE_URL = "https://tq1.wysemanagementsuite.com/ccm-web/";
	private ApiClientService clientService;
	DefaultUriBuilderFactory webUriBuilderFactory;

	@BeforeEach
	public void setUp(){
		webUriBuilderFactory = new DefaultUriBuilderFactory(CCM_WEB_BASE_URL);
		clientService = new ApiWebClientServiceImpl();
	}

	@Test
	void contextLoads(){
		ApiWebClientResponseHandler responseHandler = new CcmWebLoginResponseHandlerImpl(clientService);
		ApiClientOperation clientOperation = new ApiWebClientOperationImpl(HttpMethod.GET,webUriBuilderFactory,responseHandler);
		clientService.addClientOperation(clientOperation);
		clientService.run();
	}

}

package com.adam.test.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by Adam.Zhang on 2017/6/14.
 */
@Configuration
public class RestTemplateCustomize {

    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
            OAuth2AccessToken token = oAuth2RestTemplate.getAccessToken();
            String tokenType = token.getTokenType();
            String tokenValue = token.getValue();
            request.getHeaders().add("Authorization", tokenType + " " + tokenValue);
            return execution.execute(request, body);
        };
        restTemplateBuilder = restTemplateBuilder.interceptors(interceptor);
        return restTemplateBuilder;
    }

}

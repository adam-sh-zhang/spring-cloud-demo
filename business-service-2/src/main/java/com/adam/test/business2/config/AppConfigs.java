package com.adam.test.business2.config;

import feign.RequestInterceptor;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

/**
 * Created by Adam.Zhang on 2017/8/25.
 */
@Configuration
public class AppConfigs {

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor(OAuth2ClientContext oauth2ClientContext, OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails) {
        return new OAuth2FeignRequestInterceptor(oauth2ClientContext, oAuth2ProtectedResourceDetails);
    }

}

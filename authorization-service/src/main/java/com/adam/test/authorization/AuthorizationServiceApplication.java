package com.adam.test.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by Adam.Zhang on 2017/5/22.
 */
@SpringBootApplication
@EnableResourceServer
@EnableAuthorizationServer
@EnableEurekaClient
public class AuthorizationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServiceApplication.class, args);
    }
}

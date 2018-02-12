package com.adam.test.business2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by Adam.Zhang on 2017/8/25.
 */
@SpringBootApplication
//@EnableEurekaClient
//@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableFeignClients
public class BusinessService2Application {
    public static void main(String[] args) {
        SpringApplication.run(BusinessService2Application.class, args);
    }
}

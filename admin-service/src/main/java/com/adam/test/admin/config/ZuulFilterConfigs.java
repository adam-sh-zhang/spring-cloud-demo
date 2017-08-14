package com.adam.test.admin.config;

import com.adam.test.admin.zuul.CustomizeZuulFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Adam.Zhang on 2017/6/13.
 */
@Configuration
public class ZuulFilterConfigs {
    @Bean
    public CustomizeZuulFilter customizeZuulFilter() {
        return new CustomizeZuulFilter();
    }
}

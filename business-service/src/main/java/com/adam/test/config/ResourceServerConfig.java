package com.adam.test.config;

import com.adam.test.util.UserPrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Created by Adam.Zhang on 2017/8/24.
 */
@Configuration
public class ResourceServerConfig {

    @Bean
    public PrincipalExtractor principalExtractor() {
        return new UserPrincipalExtractor();
    }

}

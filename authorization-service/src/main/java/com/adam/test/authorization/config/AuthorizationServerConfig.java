package com.adam.test.authorization.config;

import com.adam.test.authorization.service.ClientService;
import com.adam.test.authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    //use jwt
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
//        jwtAccessTokenConverter.setSigningKey("111111");
//        return new JwtAccessTokenConverter();
//    }
//    @Autowired
//    private AccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private Environment env;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenStore tokenStore;

    @Bean
    public AuthenticationManager authenticationManagerBean() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(userService);
        List<AuthenticationProvider> providers = new ArrayList<AuthenticationProvider>();
        providers.add(authenticationProvider);
        ProviderManager manager = new ProviderManager(providers);
        return manager;
    }

    @Bean
    public TokenStore tokenStore() {
        //plan to use redis token store in feature
        return new InMemoryTokenStore();
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //use customized client service
        clients.withClientDetails(clientService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                //.accessTokenConverter(jwtAccessTokenConverter)
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userService)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
    }
}

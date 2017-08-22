package com.adam.test.authorization.config;

import com.adam.test.authorization.model.Client;
import com.adam.test.authorization.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Adam.Zhang on 2017/6/14.
 */
@Configuration
public class ApplicationConfigs {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Autowired
    public ApplicationConfigs(ClientRepository clientRepository) {
        initClients(clientRepository);
    }

    private void initClients(ClientRepository clientRepository) {
        List<Client> clients = clientRepository.findAll();
        if (clients == null || clients.isEmpty()) {
            Client client = new Client();
            client.setClientId("browser");

            HashSet<String> authorizedGrantTypes = new HashSet<>();
            authorizedGrantTypes.add("password");
            authorizedGrantTypes.add("refresh_token");
            client.setAuthorizedGrantTypes(authorizedGrantTypes);

            HashSet<String> scopes = new HashSet<>();
            scopes.add("ui");
            client.setScope(scopes);
            client.setScoped(true);

            client.setAuthorities(new ArrayList<>());

            clientRepository.save(client);
        }
    }


}

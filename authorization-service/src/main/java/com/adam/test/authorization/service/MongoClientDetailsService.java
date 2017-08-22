package com.adam.test.authorization.service;

import com.adam.test.authorization.model.Client;
import com.adam.test.authorization.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

/**
 * Created by Adam.Zhang on 2017/8/22.
 */
public class MongoClientDetailsService implements ClientDetailsService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Client client = clientRepository.findByClientId(clientId);
        if (client == null) {
            throw new ClientRegistrationException("client not found");
        }
        return client;
    }
}

package com.adam.test.authorization.repository;

import com.adam.test.authorization.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Adam.Zhang on 2017/8/22.
 */
public interface ClientRepository extends MongoRepository<Client, String> {
    public Client findByClientId(String clientId);
}

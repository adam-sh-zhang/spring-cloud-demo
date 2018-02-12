package com.adam.test.authorization.repository;

import com.adam.test.authorization.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Adam.Zhang on 2017/6/6.
 */
public interface UserRepository extends MongoRepository<User, String> {
    public User findByUsername(String username);
}

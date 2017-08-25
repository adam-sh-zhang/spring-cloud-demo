package com.adam.test.authorization.repository;

import com.adam.test.authorization.model.Authority;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Adam.Zhang on 2017/8/25.
 */
public interface AuthorityRepository extends MongoRepository<Authority, String> {

}

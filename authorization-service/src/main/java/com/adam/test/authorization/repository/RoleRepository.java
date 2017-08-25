package com.adam.test.authorization.repository;

import com.adam.test.authorization.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Adam.Zhang on 2017/8/24.
 */
public interface RoleRepository extends MongoRepository<Role, String> {
    public Role findByName(String name);
}

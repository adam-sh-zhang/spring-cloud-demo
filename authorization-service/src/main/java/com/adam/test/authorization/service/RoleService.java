package com.adam.test.authorization.service;

import com.adam.test.authorization.model.Role;
import com.adam.test.authorization.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Adam.Zhang on 2017/8/24.
 */
@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role getRoleById(String id) {
        return roleRepository.findOne(id);
    }
}

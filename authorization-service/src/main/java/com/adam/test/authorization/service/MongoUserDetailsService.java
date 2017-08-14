package com.adam.test.authorization.service;

import com.adam.test.authorization.model.User;
import com.adam.test.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Adam.Zhang on 2017/6/6.
 */
public class MongoUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return existingUser;
    }
}

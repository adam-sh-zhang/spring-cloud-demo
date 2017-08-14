package com.adam.test.authorization.service;

import com.adam.test.authorization.model.User;
import com.adam.test.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by Adam.Zhang on 2017/6/7.
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public void createUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        Assert.isNull(existingUser, "This is a duplicate user:" + user.getUsername());

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        userRepository.save(user);

    }
}

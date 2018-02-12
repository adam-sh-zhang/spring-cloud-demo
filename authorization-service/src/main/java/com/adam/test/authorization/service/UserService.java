package com.adam.test.authorization.service;

import com.adam.test.authorization.model.Authority;
import com.adam.test.authorization.model.User;
import com.adam.test.authorization.repository.UserRepository;
import com.adam.test.authorization.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;

/**
 * Created by Adam.Zhang on 2017/6/7.
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void createUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        Assert.isNull(existingUser, "This is a duplicate user:" + user.getUsername());

        String hash = passwordEncoder.encode(user.getPassword());
        user.password = hash;
        userRepository.save(user);

    }

    public long count() {
        return userRepository.count();
    }

    //implement the method in UserDetailService
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return existingUser;
    }

    public UserVo convertToVo(User user) {
        final UserVo userVo = new UserVo();
        userVo.id = user.id;
        userVo.username = user.username;
        userVo.isEnabled = user.isEnabled;
        userVo.roleName = user.getRoleName();
        userVo.authorities = new ArrayList<>();
        user.getAuthorities().forEach(authority -> userVo.authorities.add(authority.getAuthority()));
        userVo.createdDate = user.createdDate;
        userVo.updatedDate = user.updatedDate;
        return userVo;
    }
}

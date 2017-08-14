package com.adam.test.authorization.controller;

import com.adam.test.authorization.model.User;
import com.adam.test.authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Adam.Zhang on 2017/5/23.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

}

package com.adam.test.admin.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * Created by Adam.Zhang on 2017/6/21.
 */
@Controller
public class LoginController {

    //@ResponseBody
    @RequestMapping("/login")
    public String login(Principal principal) {

        return "login";
    }

}

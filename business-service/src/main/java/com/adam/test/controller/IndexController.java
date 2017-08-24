package com.adam.test.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Adam.Zhang on 2017/5/22.
 */
@RestController
public class IndexController {


    @RequestMapping("/index")
    @PreAuthorize("hasAuthority('ADMIN')")
    //About method security, see here: http://docs.spring.io/spring-security/site/docs/4.2.3.RELEASE/reference/htmlsingle/#el-access
    public String index() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getDetails();
        UserDetails user;
        if (principal instanceof UserDetails) {
            user = (UserDetails) principal;
            String username = user.getUsername();
            String password = user.getPassword();
            return username + ' ' + password;
        }
        return principal.toString();
    }
}

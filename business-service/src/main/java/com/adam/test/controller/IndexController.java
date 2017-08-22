package com.adam.test.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Adam.Zhang on 2017/5/22.
 */
@RestController
public class IndexController {


    @RequestMapping("/index")
    public String index(Principal user) {
        //SecurityContext
        return "index";
    }
}

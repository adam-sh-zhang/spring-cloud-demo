package com.adam.test.business2.controller;

import com.adam.test.business2.feign.BusinessClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Adam.Zhang on 2017/8/25.
 */
@RestController
public class IndexController {

    @Autowired
    BusinessClient businessClient;

    @RequestMapping("/index")
    public String index() {
        return businessClient.index();
    }

}

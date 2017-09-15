package com.adam.test.business2.controller;

import com.adam.test.business2.dao.DemoDao;
import com.adam.test.business2.feign.BusinessClient;
import com.adam.test.business2.mapper.DemoMapper;
import com.adam.test.business2.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by Adam.Zhang on 2017/8/25.
 */
@RestController
public class IndexController {

    @Autowired
    BusinessClient businessClient;

    @Autowired
    DemoMapper demoMapper;

    @Autowired
    DemoDao demoDao;

    @RequestMapping("/index")
    public List<Demo> index() {
        //return businessClient.index();
        //List<Demo> demoList = demoMapper.findAll();
        List<Demo> demoList = demoDao.findAll();
        return demoList;
    }

    @RequestMapping("/create")
    @Transactional
    public Demo create() {
        Demo demo = new Demo();
        demo.id = UUID.randomUUID();
        demo.value = "test";
        demoDao.insert(demo);
        //throw new RuntimeException("1111");
        return demo;
    }

}

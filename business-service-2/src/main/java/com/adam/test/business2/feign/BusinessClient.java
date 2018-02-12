package com.adam.test.business2.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Adam.Zhang on 2017/8/25.
 */
@FeignClient("business")
public interface BusinessClient {
    @RequestMapping("/index")
    public String index();
}

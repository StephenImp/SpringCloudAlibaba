package com.cn.democlient1.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient("demo-server1")
@Component
public interface ClientFeignService {

    @RequestMapping("/server/query")
    String query();
}

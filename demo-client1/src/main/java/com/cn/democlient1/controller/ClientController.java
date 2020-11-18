package com.cn.democlient1.controller;

import com.cn.democlient1.feign.ClientFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RequestMapping("/client")
@RestController
public class ClientController {
	@Autowired
    private ClientFeignService clientFeignService;


	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String query() {
		return clientFeignService.query();
	}
}

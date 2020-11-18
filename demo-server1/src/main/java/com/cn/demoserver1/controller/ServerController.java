package com.cn.demoserver1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RequestMapping("/server")
@RestController
public class ServerController {

	@Value("${name}")
	private String name;

	@Value("${age}")
	private Integer age;

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String query() {

		return name+","+age;
	}
}

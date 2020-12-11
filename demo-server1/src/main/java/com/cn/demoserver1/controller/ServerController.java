package com.cn.demoserver1.controller;

import com.cn.demoserver1.channel.TestTopicChannel;
import com.cn.demoserver1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RequestMapping("/server")
@RestController
@EnableBinding(TestTopicChannel.class)
public class ServerController {

	@Value("${name}")
	private String name;

	@Value("${age}")
	private Integer age;

	@Autowired
	private TestTopicChannel testTopicChannel;

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String query() {

		return name+","+age;
	}


	/**
	 * RocketMq发送消息
	 */
	@PostMapping(value = {"/v1/test"})
	public void test() {
		User user = new User();
		user.setName("wpw");
		user.setAge(18);
		boolean send = testTopicChannel.output().send(MessageBuilder.withPayload(user).build());
		if (send){
			System.out.println("消息发送成功");
		}
	}

}

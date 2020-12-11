package com.cn.demoserver1.customer;

import com.cn.demoserver1.channel.TestTopicChannel;
import com.cn.demoserver1.channel.TestTopicChannelTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * ReceiveService
 *
 * @author wupw
 * @date 2020/12/11
 */
@Component
@EnableBinding(TestTopicChannelTwo.class)
public class DemoCustomer {

    @Autowired
    private TestTopicChannelTwo testTopicChannelTwo;

    @StreamListener(TestTopicChannel.INPUT)
    public void receive(String msg) {
        System.out.println("stream-channel-one-msg: "+msg);

        //向下一个topic发送消息
        testTopicChannelTwo.output().send(MessageBuilder.withPayload(msg).build());

    }

}

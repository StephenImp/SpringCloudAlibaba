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
public class DemoTopicTwoCustomer {

    @StreamListener(TestTopicChannelTwo.INPUT)
    public void receive(String msg) {

        //这里是流转到topicTwo的消息
        System.out.println("stream-channel-two-msg: "+msg);

    }

}

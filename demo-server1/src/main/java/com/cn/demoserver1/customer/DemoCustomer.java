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

        //先是调用output()方法获取输出通道对象，接着调用send方法发送数据。
        // send方法接收一个Message对象，这个对象不能直接new，需要使用MessageBuilder获取。
        //向下一个topic发送消息
        testTopicChannelTwo.output().send(MessageBuilder.withPayload(msg).build());

    }

}

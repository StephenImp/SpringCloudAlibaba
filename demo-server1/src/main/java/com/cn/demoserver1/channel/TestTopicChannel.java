package com.cn.demoserver1.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 这里配置的是Stream 的信道
 *
 * INPUT 与 OUTPUT 属于 SpringCloudStream
 *
 * 在  application.properties  配置文件中建立绑定信道与 topic之间的关系
 *
 * 还要注意建立topic与消费者组之间的关系
 *
 * 应用间的通信通过输入通道（input channel）和输出通道（output channel）完成
 *
 */
public interface TestTopicChannel {

    String OUTPUT = "example-topic-output";
    String INPUT = "example-topic-input";

    @Output(OUTPUT)
    MessageChannel output();

    @Input(INPUT)
    SubscribableChannel input();

}

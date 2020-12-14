package com.cn.demoserver1.customer;

import com.cn.demoserver1.channel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * TransformProcessor
 *
 * @author wupw
 * @date 2020/12/14
 */

@EnableBinding(Processor.class)
public class TransformProcessor {

    @StreamListener(Processor.INPUT)
    //@SendTo(Processor.OUTPUT)
    //An output channel cannot be specified for a method that does not return a value
    //监听端的@SendTo注解的方法中，@SendTo指定的方法必须要有返回值，也就是说不能是void方法
    public void handle(String msg) {
        System.out.println("Processor msg:"+ msg);
    }
}

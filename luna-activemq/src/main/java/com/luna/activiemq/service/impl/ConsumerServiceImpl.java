package com.luna.activiemq.service.impl;

import javax.jms.JMSException;

import com.luna.activiemq.service.ConsumerService;

public class ConsumerServiceImpl implements ConsumerService {

    public void receiveMessage(String message) throws JMSException {
        System.out.println("------------------消费者接收消息-----------------");
        System.out.println("-----------------生产者发来的消息是：" + message);
    }

}

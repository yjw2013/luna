/*
 * Project: luna-web
 * 
 * File Created at 2017年12月6日
 * 
 * Copyright 2016 LUNA Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.luna.web.controller;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luna.web.service.ConsumerService;
import com.luna.web.service.ProducerService;

/**
 * 消息服务
 * @Type MessageController.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月6日 下午3:10:56
 * @version 
 */
@Controller
public class MessageController {
	
	private Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Resource(name = "demoQueueDestination")
    private Destination destination;
	
	//队列消息生产者
	@Autowired
    private ProducerService producer;
	
	//队列消息消费者
    @Autowired
    private ConsumerService consumer;
    
    @RequestMapping(value = "SendMessage.do", method = RequestMethod.GET)
    public void send(String msg) {
        logger.info(Thread.currentThread().getName()+"------------send to jms Start");
        producer.sendMessage(msg);
        logger.info(Thread.currentThread().getName()+"------------send to jms End");
    }

    @RequestMapping(value= "ReceiveMessage.do",method = RequestMethod.GET)
    public Object receive(){
        logger.info(Thread.currentThread().getName()+"------------receive from jms Start");
        TextMessage tm = consumer.receive(destination);
        logger.info(Thread.currentThread().getName()+"------------receive from jms End");
        return tm;
    }
	
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 		每天进步一点点，长此以往，大海将会出现！
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年12月6日 于继伟 creat
 */
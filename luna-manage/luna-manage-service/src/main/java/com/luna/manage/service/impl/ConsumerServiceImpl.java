/*
 * Project: luna-manage-service
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
package com.luna.manage.service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.luna.common.exception.MQException;
import com.luna.manage.service.ConsumerService;

/**
 * @Type ConsumerServiceImpl.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月6日 下午2:52:00
 * @version 
 */
@Service
public class ConsumerServiceImpl implements ConsumerService{
	
	@Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;
	
	@Override
	public TextMessage receive(Destination destination) {
		TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        try{
        	if(null == textMessage){
        		throw new MQException("请注意...获取的内容异常...");
        	}
            System.out.println("从队列" + destination.toString() + "收到了消息：\t"
                    + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return textMessage;
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
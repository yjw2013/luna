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
import javax.jms.Message;
import javax.jms.Session;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.luna.common.exception.MQException;
import com.luna.manage.service.ProducerService;

/**
 * @Type ProducerServiceImpl.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月6日 下午2:51:43
 * @version 
 */
@Service
public class ProducerServiceImpl implements ProducerService{
	
	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	@Override
	public void sendMessage(Destination destination,final String msg){
		try {
			if(StringUtils.isEmpty(msg)){
				throw new MQException("请注意...发送的消息内容异常...");
			}
	        jmsTemplate.send(destination, new MessageCreator() {
	            public Message createMessage(Session session) throws JMSException {
	                return session.createTextMessage(msg);
	            }
	        });
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	@Override
    public void sendMessage(final String msg){
		try {
			if(StringUtils.isEmpty(msg)){
				throw new MQException("请注意...发送的消息内容异常...");
			}
	        jmsTemplate.send(new MessageCreator() {
	            public Message createMessage(Session session) {
	                try {
						return session.createTextMessage(msg);
					} catch (JMSException e) {
						e.printStackTrace();
					}
	                return null;
	            }
	        });
		} catch (Exception e) {
			e.printStackTrace();
		}
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
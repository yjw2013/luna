package com.luna.activiemq.service;

import javax.jms.JMSException;

public interface ConsumerService {

	public void receiveMessage(String message) throws JMSException;
	
}

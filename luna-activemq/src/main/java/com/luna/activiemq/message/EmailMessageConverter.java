package com.luna.activiemq.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class EmailMessageConverter implements MessageConverter {

	@Override
	public Message toMessage(Object object, Session session)
			throws JMSException, MessageConversionException {
		return null;
	}

	@Override
	public Object fromMessage(Message message) throws JMSException,
			MessageConversionException {
		return null;
	}

}

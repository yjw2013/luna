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
package com.luna.web.service;

import javax.jms.Destination;

/**
 * 消息中间件生产者服务接口
 * @Type ProducerService.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月6日 下午2:46:31
 * @version 
 */
public interface ProducerService {
	
	/**
	 * 将消息发送到指定的目的地
	 * @param destination
	 * @param msg
	 */
	void sendMessage(Destination destination,final String msg);
	
	/**
	 * 将消息发送到默认的目的地
	 * @param msg
	 */
	void sendMessage(final String msg);
	
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
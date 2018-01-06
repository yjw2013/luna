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
import javax.jms.TextMessage;

/**
 * 消息中间件消费者接口
 * @Type ConsumerService.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月6日 下午2:47:42
 * @version 
 */
public interface ConsumerService {
	
	/**
	 * 接收消息
	 * @param destination
	 * @return
	 */
	TextMessage receive(Destination destination);
	
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
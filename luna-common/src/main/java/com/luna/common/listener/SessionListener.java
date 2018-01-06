/*
 * Project: luna-common
 * 
 * File Created at 2017年12月5日
 * 
 * Copyright 2016 LUNA Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.luna.common.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 基于HttpSession（会话）的监听器
 * @Type SessionListener.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月5日 下午1:39:11
 * @version 
 */
public class SessionListener implements HttpSessionListener{
	
	private Logger logger = LogManager.getLogger(SessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		logger.info("创建了一个Session连接:[" + session.getId() + "]");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		logger.info("销毁了一个Session连接:[" + session.getId() + "]");
	}
	
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 		每天进步一点点，长此以往，大海将会出现！
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年12月5日 于继伟 creat
 */
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

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 基于Servlet容器启动和关闭的监听器类
 * @Type ServerContextListener.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月5日 下午1:27:47
 * @version 
 */
public class ServerContextListener implements ServletContextListener{
	
	protected final Logger logger = LogManager.getLogger(ServerContextListener.class);
	
	private static final String OPERATER_NAME = "【全局监听器】";

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		logger.info(OPERATER_NAME + "被初始化...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info(OPERATER_NAME + "被销毁...");
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
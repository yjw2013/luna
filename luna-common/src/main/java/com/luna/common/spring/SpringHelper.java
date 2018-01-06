/*
 * Project: luna-common
 * 
 * File Created at 2017年11月29日
 * 
 * Copyright 2016 LUNA Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.luna.common.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * SpringIoc容器帮助类
 * 
 * @Type SpringHelper.java
 * @Desc 
 * @author 于继伟
 * @date 2017年11月29日 下午3:56:51
 * @version 
 */
@Component
public class SpringHelper implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;
	
	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	/**
	 * 获取ApplicationContext对象
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	/**
	 * 指定BeanName获取Bean
	 * @param beanName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName){
		return (T) applicationContext.getBean(beanName);
	}
	
	/**
	 * 指定Class类型获取Bean
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<?> clazz){
		return (T) applicationContext.getBean(clazz);
	}

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 		每天进步一点点，长此以往，大海将会出现！
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年11月29日 于继伟 creat
 */
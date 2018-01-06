/*
 * Project: luna-common
 * 
 * File Created at 2017年12月11日
 * 
 * Copyright 2016 LUNA Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.luna.common.support.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @Type SessionContainer.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月11日 下午8:50:57
 * @version 
 */
public class SessionContainer implements HttpSessionBindingListener{

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		
	}
	
	
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 		每天进步一点点，长此以往，大海将会出现！
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年12月11日 于继伟 creat
 */
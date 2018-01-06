/*
 * Project: luna-common
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
package com.luna.common.exception;

/**
 * 消息服务自定义异常
 * @Type MQException.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月6日 下午5:10:03
 * @version 
 */
public class MQException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8788852690458126378L;
	
	public MQException(){
	}
	
	public MQException(String msg){
		super(msg);
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
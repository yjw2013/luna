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
package com.luna.common.exception;

/**
 * Luna全局异常类
 * @Type LunaException.java
 * @Desc 
 * @author 于继伟
 * @date 2017年11月29日 下午4:02:04
 * @version 
 */
public class LunaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1032700443120786405L;
	
	public LunaException(){
	}
	
	public LunaException(String msg){
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
 * 2017年11月29日 于继伟 creat
 */
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
package com.luna.common.exception;

/**
 * Http请求定位JSON模版异常
 * @Type JsonTempleteException.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月5日 下午5:33:14
 * @version 
 */
public class HttpServerTempleteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8179340804120811231L;
	
	public HttpServerTempleteException(){
	}
	
	public HttpServerTempleteException(String msg){
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
 * 2017年12月5日 于继伟 creat
 */
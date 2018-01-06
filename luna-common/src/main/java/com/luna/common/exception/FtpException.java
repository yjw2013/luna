/*
 * Project: luna-common
 * 
 * File Created at 2017年12月13日
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
 * Ftp的异常类
 * @Type FtpException.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月13日 下午10:30:22
 * @version 
 */
public class FtpException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2521446636448384000L;

	public FtpException() {
    }

    public FtpException(String message) {
        super(message);
    }

    public FtpException(String message, Throwable throwable) {
        super(message, throwable);
    }

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 		每天进步一点点，长此以往，大海将会出现！
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年12月13日 于继伟 creat
 */
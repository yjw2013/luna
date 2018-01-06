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

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 自定义类型转换异常
 * @Type TypeCastException.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月5日 下午2:00:35
 * @version 
 */
public class TypeCastException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5487044458731321131L;
	
	Throwable nested;
	
	public TypeCastException() {
		nested = null;
	}

	public TypeCastException(String msg) {
		super(msg);
		nested = null;
	}

	public TypeCastException(String msg, Throwable nested) {
		super(msg);
		this.nested = null;
		this.nested = nested;
	}

	public TypeCastException(Throwable nested) {
		
		this.nested = null;
		this.nested = nested;
	}

	public String getMessage() {
		if (nested != null)
			return super.getMessage() + " (" + nested.getMessage() + ")";
		else
			return super.getMessage();
	}

	public String getNonNestedMessage() {
		return super.getMessage();
	}

	public Throwable getNested() {
		if (nested == null)
			return this;
		else
			return nested;
	}

	public void printStackTrace() {
		super.printStackTrace();
		if (nested != null)
			nested.printStackTrace();
	}

	public void printStackTrace(PrintStream ps) {
		super.printStackTrace(ps);
		if (nested != null)
			nested.printStackTrace(ps);
	}

	public void printStackTrace(PrintWriter pw) {
		super.printStackTrace(pw);
		if (nested != null)
			nested.printStackTrace(pw);
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
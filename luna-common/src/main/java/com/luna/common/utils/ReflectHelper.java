/*
 * Project: luna-common
 * 
 * File Created at 2017年11月28日
 * 
 * Copyright 2016 LUNA Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.luna.common.utils;

/**
 * 反射工具类
 * @Type ReflectHelper.java
 * @Desc 
 * @author 于继伟
 * @date 2017年11月28日 下午9:53:54
 * @version 
 */
public class ReflectHelper {
	/**
	 * 提指定的类载入以系统中
	 *
	 * @param name
	 *            类名称
	 * @return 类对象
	 * @throws ClassNotFoundException
	 */
	public static Class<?> classForName(String name) throws ClassNotFoundException {
		try {
			return Thread.currentThread().getContextClassLoader().loadClass(name);
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("类[" + name + "]加载出错");
		} catch (SecurityException e) {
			e.printStackTrace();
			System.err.println("类[" + name + "]加载出错");
		}
		return Class.forName(name);
	}

	/**
	 * 根据名称生成指定的对象
	 *
	 * @param name
	 *            类名称
	 * @return 具体的对象,若发生异常，则返回null
	 */
	public static Object objectForName(String name) {
		try {
			return Class.forName(name).newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("类[" + name + "]获取对象实例出错");
		}
		return null;
	}
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 		每天进步一点点，长此以往，大海将会出现！
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年11月28日 于继伟 creat
 */
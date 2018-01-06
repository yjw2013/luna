/*
 * Project: luna-common
 * 
 * File Created at 2017年12月7日
 * 
 * Copyright 2016 LUNA Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.luna.common.support;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.luna.common.utils.IDCardUtil;

/**
 * 全局断言类，用于业务校验，可自定义扩展，在于维护业务的整洁性
 * 或者用于单元测试，维护测试代码的一个可读性
 * 
 * @Type Assert.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月7日 下午10:30:37
 * @version 
 */
public class Assert {
	
	/**
	 * 校验参数是否为true，如果不为ture，则打印相应的异常信息
	 * @param expression
	 * @param message
	 */
	public static void isTrue(boolean expression, String message){
		if(!expression){
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * 如果为false，则打印指定的异常信息
	 * @param expression
	 */
	public static void isTrue(boolean expression) {
		isTrue(expression, "这里可以自定义异常信息...");
	}
	
	/**
	 * 检查结果是否为null，如果不为null，则打印相应的异常信息
	 * @param object
	 * @param message
	 */
	public static void isNull(Object object, String message) {
		if (object != null) {
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * 如果不为null，则打印指定的异常信息
	 * @param object
	 */
	public static void isNull(Object object) {
		isNull(object, "这里可以自定义异常信息...");
	}
	
	/**
	 * 检查结果是否为null，如果为null，则打印相应的异常信息
	 * @param object
	 * @param message
	 */
	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * 检查结果是否为null，如果为null，则打印异常信息
	 * @param object
	 */
	public static void notNull(Object object) {
		notNull(object, "这里可以自定义异常信息...");
	}
	
	/**
	 * 检查字符串是否为空或者null，如果为null或者空，则抛出相应的异常信息
	 * @param text
	 * @param message
	 */
	public static void hasLength(String text, String message) {
		if (!StringUtils.hasLength(text)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * 如果为null或者空，则抛出自定义异常信息
	 * @param text
	 */
	public static void hasLength(String text) {
		hasLength(text,
				"自定义异常信息...");
	}
	
	/**
	 * 判断字符串是否是空串，如果是则抛出相应的异常
	 * @param text
	 * @param message
	 */
	public static void hasText(String text, String message) {
		if (!StringUtils.hasText(text)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * 判断字符串是否是空串，如果是则抛出指定的异常
	 * @param text
	 */
	public static void hasText(String text) {
		hasText(text,
				"自定义异常信息...");
	}
	
	/**
	 * 判断数组是否为null或者长度为零，如果是则抛出相应的异常
	 * @param array
	 * @param message
	 */
	public static void notEmpty(Object[] array, String message) {
		if (ObjectUtils.isEmpty(array)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * 判断数组是否为null或者长度为零，如果是则抛出指定的异常
	 * @param array
	 */
	public static void notEmpty(Object[] array) {
		notEmpty(array, "自定义异常信息...");
	}
	
	/**
	 * 判断数组中是否有空的元素，如果有，则抛出相应的异常
	 * @param array
	 * @param message
	 */
	public static void noNullElements(Object[] array, String message) {
		if (array != null) {
			for (Object element : array) {
				if (element == null) {
					throw new IllegalArgumentException(message);
				}
			}
		}
	}
	
	/**
	 * 判断数组中是否有空的元素，如果有，则抛出指定的异常
	 * @param array
	 */
	public static void noNullElements(Object[] array) {
		noNullElements(array, "自定义异常信息...");
	}
	
	/**
	 * 判断集合是否为null或者长度为零，如果是的话则抛出相应的异常
	 * @param collection
	 * @param message
	 */
	public static void notEmpty(Collection<?> collection, String message) {
		if (CollectionUtils.isEmpty(collection)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * 判断集合是否为null或者长度为零，如果是的话则抛出指定的异常
	 * @param collection
	 */
	public static void notEmpty(Collection<?> collection) {
		notEmpty(collection,
				"自定义异常信息...");
	}
	
	/**
	 * 判断Map是否为null或者长度为零，如果是的话则抛出相应的异常
	 * @param map
	 * @param message
	 */
	public static void notEmpty(Map<?, ?> map, String message) {
		if (CollectionUtils.isEmpty(map)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * 判断Map是否为null或者长度为零，如果是的话则抛出指定的异常
	 * @param map
	 */
	public static void notEmpty(Map<?, ?> map) {
		notEmpty(map, "自定义异常信息...");
	}
	
	/**
	 * 校验obj是否为clazz类型的对象
	 * @param clazz
	 * @param obj
	 */
	public static void isInstanceOf(Class<?> clazz, Object obj) {
		isInstanceOf(clazz, obj, "");
	}
	
	/**
	 * 校验obj是否为clazz类型的对象，如果不是则抛出异常
	 * @param type
	 * @param obj
	 * @param message
	 */
	public static void isInstanceOf(Class<?> type, Object obj, String message) {
		notNull(type, "obj不能为null...");
		if (!type.isInstance(obj)) {
			throw new IllegalArgumentException(
					(StringUtils.hasLength(message) ? message + " " : "") +
					"Object of class [" + (obj != null ? obj.getClass().getName() : "null") +
					"] must be an instance of " + type);
		}
	}
	
	/**
	 * 校验身份证格式
	 * @param text
	 */
	public static void idCard(String text, String message) {
		if (!IDCardUtil.isIdentity(text)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * 校验邮箱
	 * @param text
	 * @param message
	 */
	public static void email(String text, String message) {
		String regex = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		pattern(text, regex, true, message);
	}
	
	/**
	 * 校验手机号
	 * @param text
	 */
	public static void mobile(String text, String message) {
		String regex = "((^(13|15|17|18)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
		pattern(text, regex, true, message);
	}
	
	/**
	 * 正则表达式
	 * @param text
	 * @param regex
	 * @param flag
	 * @param key
	 */
	public static void pattern(String text, String regex, boolean flag, String message) {
		boolean result = false;
		try {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(text);
			result = matcher.matches();
		} catch (Exception e) {
			result = false;
		}
		if (result != flag) {
			throw new IllegalArgumentException(message);
		}
	}
	
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 		每天进步一点点，长此以往，大海将会出现！
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年12月7日 于继伟 creat
 */
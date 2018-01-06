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

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 数据传输对象接口
 * @Type Dto.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月11日 下午8:34:23
 * @version 
 */
public interface Dto extends Map<Object, Object>{
	
	/**
	 * 以Integer类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Integer 键值
	 */
	Integer getAsInteger(String pStr);

	/**
	 * 以Long类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Long 键值
	 */
	Long getAsLong(String pStr);

	/**
	 * 以String类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return String 键值
	 */
	String getAsString(String pStr);

	/**
	 * 取出属性值
	 * 
	 * @param pStr
	 *            属性Key
	 * @return Integer
	 */
	BigDecimal getAsBigDecimal(String pStr);

	/**
	 * 取出属性值
	 * 
	 * @param pStr
	 *            :属性Key
	 * @return Integer
	 */
	Date getAsDate(String pStr);

	/**
	 * 以List类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return List 键值
	 */
	List<?> getAsList(String key);

	/**
	 * 以Timestamp类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Timestamp 键值
	 */
	Timestamp getAsTimestamp(String pStr);
	
	/**
	 * 以Boolean类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Timestamp 键值
	 */
	Boolean getAsBoolean(String key);

	/**
	 * 给Dto压入第一个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	void setDefaultAList(List<?> pList);

	/**
	 * 给Dto压入第二个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	void setDefaultBList(List<?> pList);

	/**
	 * 获取第一个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	List<?> getDefaultAList();

	/**
	 * 获取第二个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	List<?> getDefaultBList();

	/**
	 * 给Dto压入一个默认的Json格式字符串
	 * 
	 * @param jsonString
	 */
	void setDefaultJson(String jsonString);

	/**
	 * 获取默认的Json格式字符串
	 * 
	 * @return
	 */
	String getDefaultJson();

	/**
	 * 将此Dto对象转换为XML格式字符串
	 * 
	 * @param pStyle
	 *            XML生成方式(可选：节点属性值风格和节点元素值风格)
	 * @return string 返回XML格式字符串
	 */
	String toXml(String pStyle);

	/**
	 * 将此Dto对象转换为XML格式字符串<br>
	 * 默认为节点元素值风格
	 * 
	 * @return string 返回XML格式字符串
	 */
	String toXml();

	/**
	 * 将此Dto对象转换为Json格式字符串<br>
	 * 
	 * @return string 返回Json格式字符串
	 */
	String toJson();
	
	/**
	 * 打印DTO对象<br>
	 * 
	 */
	void println();

	/**
	 * 将此Dto对象转换为Json格式字符串(带日期时间型)<br>
	 * 
	 * @return string 返回Json格式字符串
	 */
	String toJson(String pFormat);
	
	/**
	 * 设置交易状态
	 * 
	 * @param pSuccess
	 */
	void setSuccess(Boolean pSuccess);
	
	/**
	 * 获取交易状态
	 * 
	 * @param pSuccess
	 */
	Boolean getSuccess();
	
	/**
	 * 设置交易提示信息
	 * 
	 * @param pSuccess
	 */
	void setMsg(String pMsg);
	
	/**
	 * 获取交易提示信息
	 * 
	 * @param pSuccess
	 */
	String getMsg();
	
	/**
	 * BLOB字段以String类型返回
	 * 
	 * @param key
	 *            键名
	 */
	String getBlobAsStr(String key);
	
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
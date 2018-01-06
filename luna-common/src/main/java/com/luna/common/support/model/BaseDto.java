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

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.luna.common.constants.SystemConstants;
import com.luna.common.utils.ConvertHelper;
import com.luna.common.utils.XMLHelper;

/**
 * @Type BaseDto.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月11日 下午8:58:12
 * @version 
 */
public class BaseDto extends HashMap<Object, Object> implements Dto, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8746565875814156271L;

	public BaseDto(){}
	
	public BaseDto(String key, Object value){
		put(key, value);
	}
	
	public BaseDto(Boolean success){
		setSuccess(success);
	}
	
	public BaseDto(Boolean success, String msg){
		setSuccess(success);
		setMsg(msg);
	}

	/**
	 * 以BigDecimal类型返回键�?
	 * 
	 * @param key
	 *            键名
	 * @return BigDecimal 键�?
	 */
	public BigDecimal getAsBigDecimal(String key) {
		Object obj = ConvertHelper.convert(get(key), "BigDecimal", null);
		if (obj != null)
			return (BigDecimal) obj;
		else
			return null;
	}

	/**
	 * 以Date类型返回键�?
	 * 
	 * @param key
	 *            键名
	 * @return Date 键�?
	 */
	public Date getAsDate(String key) {
		Object obj = ConvertHelper.convert(get(key), "Date", "yyyy-MM-dd");
		if (obj != null)
			return (Date) obj;
		else
			return null;
	}

	/**
	 * 以Integer类型返回键�?
	 * 
	 * @param key
	 *            键名
	 * @return Integer 键�?
	 */
	public Integer getAsInteger(String key) {
		Object obj = ConvertHelper.convert(get(key), "Integer", null);
		if (obj != null)
			return (Integer) obj;
		else
			return null;
	}

	/**
	 * 以Long类型返回键�?
	 * 
	 * @param key
	 *            键名
	 * @return Long 键�?
	 */
	public Long getAsLong(String key) {
		Object obj = ConvertHelper.convert(get(key), "Long", null);
		if (obj != null)
			return (Long) obj;
		else
			return null;
	}

	/**
	 * 以String类型返回键的值
	 * 
	 * @param key
	 *            键名
	 * @return String 键的值
	 */
	public String getAsString(String key) {
 
		Object obj = ConvertHelper.convert(get(key), "String", null);
		if (obj != null)
			return (String) obj;
		else
			return "";
	}
	
	/**
	 * 以List类型返回键
	 * 
	 * @param key
	 *            键名
	 * @return List 
	 */
	public List<?> getAsList(String key){
		return (List<?>)get(key);
	}

	/**
	 * 以Timestamp类型返回键�?
	 * 
	 * @param key
	 *            键名
	 * @return Timestamp 键�?
	 */
	public Timestamp getAsTimestamp(String key) {
 
		Object obj = ConvertHelper.convert(get(key), "Timestamp", "yyyy-MM-dd HH:mm:ss");
		if (obj != null)
			return (Timestamp) obj;
		else
			return null;
	}
	
	/**
	 * 以Boolean类型返回键�?
	 * 
	 * @param key
	 *            键名
	 * @return Timestamp 键�?
	 */
	public Boolean getAsBoolean(String key){
		Object obj = ConvertHelper.convert(get(key), "Boolean", null);
		if (obj != null)
			return (Boolean) obj;
		else
			return null;
	}

	/**
	 * 给Dto压入第一个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过�?
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	public void setDefaultAList(List<?> pList) {
		put("defaultAList", pList);
	}

	/**
	 * 给Dto压入第二个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过�?
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	public void setDefaultBList(List<?> pList) {
		put("defaultBList", pList);
	}

	/**
	 * 获取第一个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过�?
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	public List<?> getDefaultAList() {
		return (List<?>) get("defaultAList");
	}

	/**
	 * 获取第二个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过�?
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	public List<?> getDefaultBList() {
		return (List<?>) get("defaultBList");
	}
	
    /**
     * @param jsonString
     */
	public void setDefaultJson(String jsonString){
    	put("defaultJsonString", jsonString);
    }
    
    /**
     * 获取默认的Json格式字符串
     * @return
     */
    public String getDefaultJson(){
    	return getAsString("defaultJsonString");
    }

	/**
	 * 将此Dto对象转换为XML格式字符串
	 * 
	 * @param pStyle
	 * @return string 返回XML格式字符串
	 */
	public String toXml(String pStyle) {
		String strXml = null;
		if (pStyle.equals(SystemConstants.XML_Attribute))
			strXml = XMLHelper.parseDto2Xml(this, "root", "row");
		else if (pStyle.equals(SystemConstants.XML_Node))
			strXml = XMLHelper.parseDto2Xml(this, "root");
		return strXml;
	}

	/**
	 * 将此Dto对象转换为XML格式字符串
	 * 
	 * @return string 返回XML格式字符串
	 */
	public String toXml() {
		String strXml = null;
		// 节点元素值风格
		strXml = XMLHelper.parseDto2Xml(this, "root");
		return strXml;
	}
	
	/**
	 * 将此Dto对象转换为Json格式字符格式
	 * 
	 * @return string 返回Json格式字符串
	 */
//	public String toJson() {
//		String strJson = null;
//		strJson = JsonHelper.encodeObject2Json(this);
//		return strJson;
//	}
	
	/**
	 * 将此Dto对象转换为Json格式字符�?带日期时间型)<br>
	 * 
	 * @return string 返回Json格式字符�?
	 */
//	public String toJson(String pFormat){
//		String strJson = null;
//		strJson = JsonHelper.encodeObject2Json(this, pFormat);
//		return strJson;
//	}
	
	/**
	 * 设置交易状�?
	 * 
	 * @param pSuccess
	 */
	public void setSuccess(Boolean pSuccess){
		put("success", pSuccess);
	}
	
	/**
	 * 获取交易状�?
	 * 
	 * @param pSuccess
	 */
	public Boolean getSuccess(){
		return getAsBoolean("success");
	}
	
	/**
	 * 设置交易提示信息
	 * 
	 * @param pSuccess
	 */
	public void setMsg(String pMsg){
		put("msg", pMsg);
	}
	
	/**
	 * 获取交易提示信息
	 * 
	 * @param pSuccess
	 */
	public String getMsg(){
		return getAsString("msg");
	}
	
	/**
	 * 打印DTO对象
	 * 
	 */
	public void println(){
		System.out.println(this);
	}
	
	/**
	 * BLOB字段以String类型返回
	 * 
	 * @param key
	 *            键名
	 * @return String
	 */
	public String getBlobAsStr(String key) {
		Object obj = ConvertHelper.convert(get(key), "BLOB", null);
		if (obj != null)
			return (String) obj;
		else
			return "";
	}

	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toJson(String pFormat) {
		// TODO Auto-generated method stub
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
 * 2017年12月11日 于继伟 creat
 */
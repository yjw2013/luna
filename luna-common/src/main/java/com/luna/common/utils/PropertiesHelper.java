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
package com.luna.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.luna.common.constants.PropertiesConstants;
import com.luna.common.constants.SystemConstants;

/**
 * Properties处理器
 * @Type PropertiesHelper.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月5日 上午11:52:05
 * @version 
 */
public class PropertiesHelper {
	
	private static Log log = LogFactory.getLog(PropertiesHelper.class);
	
	private Properties objProperties;
	
	/**
	 * 构造函数
	 * @param is 属性文件输入流
	 * @throws Exception
	 */
	public PropertiesHelper(InputStream is) throws Exception {
		try{
			objProperties = new Properties();
			objProperties.load(is);
		}
		catch(FileNotFoundException e){
			log.error(SystemConstants.Exception_Head + "未找到属性资源文件!");
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			log.error(SystemConstants.Exception_Head + "读取属性资源文件发生未知错误!");
			e.printStackTrace();
			throw e;
		}finally{
			is.close();
		}
	}

    /**
     * 持久化属性文件<br>
     * 使用setProperty()设置属性后,必须调用此方法才能将属性持久化到属性文件中
     * @param pFileName 属性文件名
     * @throws IOException 
     */
	public void storefile(String pFileName){
		FileOutputStream outStream = null;
		try{
			File file = new File(pFileName + ".properties");
			outStream = new FileOutputStream(file);
			objProperties.store(outStream, "#G4Studio");
		}catch(Exception e){
			log.error(SystemConstants.Exception_Head + "保存属性文件出错.");
			e.printStackTrace();
		}finally{
			try {
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

    /**
     * 获取属性值
     * @param key 指定Key值，获取value
     * @return String 返回属性值
     */
	public String getValue(String key){
		return objProperties.getProperty(key);
	}

    /**
     * 获取属性值,支持缺省设置
     * @param key
     * @param defaultValue 缺省值
     * @return String 返回属性值
     */
	public String getValue(String key, String defaultValue){
		return objProperties.getProperty(key, defaultValue);
	}

    /**
     * 删除属性
     * @param key 属性Key
     */
	public void removeProperty(String key){
		objProperties.remove(key);
	}
	
    /**
     * 设置属性
     * @param key 属性Key
     * @param value 属性值
     */
	public void setProperty(String key, String value){
		objProperties.setProperty(key, value);
	}
	
    /**
     * 打印所有属性值
     */
	public void printAllVlue(){
		 objProperties.list(System.out);
	}
	
	public static void main(String[] args) {
		
		
		PropertiesHelper propertiesHelper = PropertiesFactory
    			.getPropertiesHelper(PropertiesConstants.SYSTEM);
		
		String luna = propertiesHelper.getValue("luna");
		System.out.println(luna);
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
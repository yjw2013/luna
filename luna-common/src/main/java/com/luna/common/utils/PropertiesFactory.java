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

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.luna.common.constants.PropertiesConstants;
import com.luna.common.constants.SystemConstants;

/**
 * @Type PropertiesFactory.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月5日 下午12:00:25
 * @version 
 */
public class PropertiesFactory {
	private static Log log = LogFactory.getLog(PropertiesFactory.class);
    /**
     * 属性文件实例容器
     */
    private static Map<String, Object> container = new ConcurrentHashMap<String, Object>();

    static {
        ClassLoader classLoader = Thread.currentThread()
                .getContextClassLoader();
        if (classLoader == null) {
            classLoader = PropertiesFactory.class.getClassLoader();
        }
        try {
        	// 加载属性文件system.properties
            InputStream is = classLoader.getResourceAsStream("system.properties");
            PropertiesHelper ph = new PropertiesHelper(is);
            container.put(PropertiesConstants.SYSTEM, ph);
        } catch (Exception e1) {
            log.error(SystemConstants.Exception_Head + "加载属性文件params.properties出错!");
            e1.printStackTrace();
        }
    }

    /**
     * 获取属性文件实例
     *
     * @param pFile 文件类型
     * @return 返回属性文件实例
     */
    public static PropertiesHelper getPropertiesHelper(String pFile) {
        PropertiesHelper ph = (PropertiesHelper) container.get(pFile);
        return ph;
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
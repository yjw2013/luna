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
package com.luna.common.support.base;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 控制器基类
 * @Type BaseController.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月11日 下午9:50:43
 * @version 
 */
public abstract class BaseController {
		
	protected final Logger logger = LogManager.getLogger(this.getClass());
	
	/**
     * 输出响应
     *
     * @param str
     * @throws IOException
     */
    protected void write(String str, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/json;charset=UTF-8");
            response.getWriter().write(str);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
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
 * 2017年12月11日 于继伟 creat
 */
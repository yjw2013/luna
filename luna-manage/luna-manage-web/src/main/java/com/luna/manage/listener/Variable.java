/*
 * Project: luna-manage-web
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
package com.luna.manage.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.luna.manage.pojo.CantsPoJo;

/**
 * 变量类
 * @Type Variable.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月13日 下午3:49:57
 * @version 
 */
public class Variable {
	
	private static final ArrayList<CantsPoJo> PROVINCES=new ArrayList<CantsPoJo>();
    private static final HashMap<String,ArrayList<CantsPoJo>> CITYS=new HashMap<String, ArrayList<CantsPoJo>>();
    private static final HashMap<String,ArrayList<CantsPoJo>> AREAS=new HashMap<String, ArrayList<CantsPoJo>>();
	
    public static List<CantsPoJo> getPROVINCES() {
        return PROVINCES;
    }

    public static HashMap<String,ArrayList<CantsPoJo>> getCITYS() {
        return CITYS;
    }

    public static HashMap<String,ArrayList<CantsPoJo>> getAREAS() {
        return AREAS;
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
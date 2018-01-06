/*
 * Project: luna-manage-web
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
package com.luna.manage.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 定义动态数据源，实现通过集成Spring提供的AbstractRoutingDataSource，
 * 只需要实现determineCurrentLookupKey方法即可
 * 由于DynamicDataSource是单例的，线程不安全的，所以采用ThreadLocal保证线程安全，
 * 由DynamicDataSourceHolder完成。
 * 
 * @Type DynamicDataSource.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月7日 下午9:55:15
 * @version 
 */
public class DynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		// 使用DynamicDataSourceHolder保证线程安全，并且得到当前线程中的数据源key
        return DynamicDataSourceHolder.getDataSourceKey();
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
/*
 * Project: luna-manage-mapper
 * 
 * File Created at 2017年12月12日
 * 
 * Copyright 2016 LUNA Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.luna.manage.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luna.manage.mapper.CantsPoJoMapper;
import com.luna.manage.mapper.CodePojoMapper;
import com.luna.manage.mapper.CodeTypePoJoMapper;
import com.luna.manage.mapper.ParamPoJoMapper;

/**
 * 全局参数字典Mapper帮助类，为了解决common
 * @Type CodeHelper.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月12日 下午11:17:52
 * @version 
 */
@Component("initValueHelper")
public class InitValueHelper {
	
	@Autowired
	private CodePojoMapper codePojoMapper; // 字典操作Mapper
	
	@Autowired
	private CodeTypePoJoMapper codeTypePoJoMapper; // 字典类目操作Mapper
	
	@Autowired
	private ParamPoJoMapper paramPoJoMapper; // 全局参数操作Mapper
	
	@Autowired
	private CantsPoJoMapper cantsPoJoMapper; // 国标地区操作Mapper
	
	/**
	 * 返回全局参数字典Mapper
	 * @return
	 */
	public CodePojoMapper createCodePojoMapper(){
		return codePojoMapper;
	}
	
	/**
	 * 返回全局字典参数类目Mapper
	 * @return
	 */
	public CodeTypePoJoMapper createCodeTypePoJoMapper(){
		return codeTypePoJoMapper;
	}
	
	/**
	 * 返回全局参数Mapper
	 * @return
	 */
	public ParamPoJoMapper createParamPoJoMapper(){
		return paramPoJoMapper;
	}
	
	/**
	 * 返回国标地区操作Mapper
	 * @return
	 */
	public CantsPoJoMapper createCantsPoJoMapper(){
		return cantsPoJoMapper;
	}
	
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 		每天进步一点点，长此以往，大海将会出现！
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年12月12日 于继伟 creat
 */
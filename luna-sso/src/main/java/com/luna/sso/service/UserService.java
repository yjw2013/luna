/*
 * Project: luna-sso
 * 
 * File Created at 2017年11月27日
 * 
 * Copyright 2016 LUNA Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.luna.sso.service;

import com.luna.sso.pojo.User;

/**
 * 单点登录系统用户登录业务接口
 * @Type UserService.java
 * @Desc 
 * @author 于继伟
 * @date 2017年11月27日 下午4:40:59
 * @version 
 */
public interface UserService {
	
	/**
	 * 用户注册
	 * 
	 * @param user 用户数据
	 * @return
	 */
	Boolean doRegister(User user);
	
	/**
	 * 用户参数校验
	 * 
	 * @param param
	 * @param type
	 * @return
	 */
	Boolean check(String param, Integer type);
	
	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	String doLogin(String username, String password);
	
	/**
	 * 根据token查询用户信息
	 * 
	 * @param token 
	 * @return
	 */
	User queryUserByToken(String token);
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 		每天进步一点点，长此以往，大海将会出现！
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年11月27日 于继伟 creat
 */
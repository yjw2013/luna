/*
 * Project: luna-manage-service
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
package com.luna.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luna.common.aspect.vo.UserInfoVo;
import com.luna.common.support.model.BaseDto;
import com.luna.common.support.model.Dto;
import com.luna.common.utils.CollectionHelper;
import com.luna.common.utils.MD5Util;
import com.luna.manage.mapper.UserPojoMapper;
import com.luna.manage.pojo.UserPojo;
import com.luna.manage.pojo.UserPojoExample;
import com.luna.manage.pojo.UserPojoExample.Criteria;
import com.luna.manage.service.UserService;

/**
 * 用户操作的业务层
 * @Type UserServiceImpl.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月11日 下午10:01:25
 * @version 
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserPojoMapper userPojoMapper;
	
	@Override
	public List<Dto> queryUserForPage(Dto dto) {
		return null;
	}

	@Override
	public Integer queryUserForPageCount(Dto dto) {
		return null;
	}

	@Override
	public Dto saveUser(Dto dto) {
		return null;
	}

	@Override
	public void deleteUser(Dto dto) {
		
	}

	@Override
	public void updateUser(Dto dto) {
		
	}

	@Override
	public Dto checkLogin(Dto dto) {
		String namefield = dto.getAsString("namefield"); // 用户名
		String password = dto.getAsString("pwdfield"); // 密码
		
		// 将密码进行MD5加密
		password = MD5Util.md5(password);
		
		// 把用户名和密码进行数据库比对
		Dto inDto = new BaseDto();
		inDto.put("namefield", namefield);
		inDto.put("password", password);
		
		UserPojoExample example = new UserPojoExample(); // 构造用户的MyBatis的Example
		Criteria criteria = example.createCriteria(); // 构造自定义查询条件
		criteria.andBussAccountEqualTo(namefield);
		criteria.andUserPwdEqualTo(password);
		List<UserPojo> users = userPojoMapper.selectByExample(example); // 根据example去查询用户
		if(CollectionHelper.isEmpty(users)){
			return null;
		}
		UserPojo user = users.get(0);
		dto.put("user", user);
		return dto;
	}

	@Override
	public UserInfoVo getUserPojoByUserId(Dto dto) {
		
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
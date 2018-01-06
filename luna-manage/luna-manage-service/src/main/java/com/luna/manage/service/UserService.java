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
package com.luna.manage.service;

import java.util.List;

import com.luna.common.aspect.vo.UserInfoVo;
import com.luna.common.support.model.Dto;

/**
 * 用户业务类
 * @Type UserService.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月11日 下午9:55:09
 * @version 
 */
public interface UserService {
	
	/**
	 * 查询人员列表 分页
	 * 
	 * @param dto
	 * @return
	 */
	List<Dto> queryUserForPage(Dto dto);

	/**
	 * 查询人员列表 分页
	 * 
	 * @param dto
	 * @return
	 */
	Integer queryUserForPageCount(Dto dto);
	
	/**
	 * 插入一条记录
	 * 
	 * @param dto
	 */
	Dto saveUser(Dto dto);

	/**
	 * 删除人员
	 * 
	 * @param dto
	 */
	void deleteUser(Dto dto);

	/**
	 * 主键更新人员
	 * 
	 * @param dto
	 */
	void updateUser(Dto dto);

	/**
	 * 校验登陆信息
	 * 
	 * @param dto
	 * @return
	 */
	Dto checkLogin(Dto dto);
	
	
	/**
	 * 查询人员信息
	 * 
	 * @param dto
	 * @return
	 */
	UserInfoVo getUserPojoByUserId(Dto dto);
	
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
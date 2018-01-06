/*
 * Project: luna-manage-web
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
package com.luna.manage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luna.common.constants.SystemConstants;
import com.luna.common.support.base.BaseController;
import com.luna.common.support.model.BaseDto;
import com.luna.common.support.model.Dto;
import com.luna.common.utils.BeanHelper;
import com.luna.common.utils.IpHelper;
import com.luna.common.utils.WebUtils;
import com.luna.manage.mapper.RolePojoMapper;
import com.luna.manage.pojo.RolePojo;
import com.luna.manage.pojo.UserPojo;
import com.luna.manage.service.UserService;
	
/**
 * @Type LoginController.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月11日 下午7:23:19
 * @version 
 */
@Controller
@RequestMapping("/manage")
public class LoginController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RolePojoMapper rolePoJoMapper;
	
	/**
	 * 后台管理系统登录
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public void loginSys(HttpServletRequest request,
			HttpServletResponse response){
		long start = System.currentTimeMillis();
		Dto dto = WebUtils.getParamAsDto(request);
		Dto outdto = new BaseDto();
		HttpSession session = request.getSession();
		
		logger.info("帐户[" + dto.getAsString("namefield") + "]正尝试登陆系统...");
		String IP = IpHelper.getIpAddr(request); // 客户端请求的IP地址
		outdto = userService.checkLogin(dto);
		
		UserPojo user = (UserPojo) outdto.get("user");
		Dto jsonDto = new BaseDto();
		if(BeanHelper.isEmpty(user)){
			jsonDto.put(SystemConstants.SUCCESS, new Boolean(false));
			jsonDto.put(SystemConstants.ERROR_MSG, "用户账号或密码错误");
//			jsonDto.put("errorType", "1");
			logger.warn("帐户[" + dto.getAsString("namefield")
					+ "]登陆失败.(失败原因：用户账号或密码错误)");
			write(jsonDto.toJson(), response);
			return;
		}
		
		List<RolePojo> rolePoJos = rolePoJoMapper.selectRolePoJos(user.getUserId()); // 登录成功后用户所对应的角色信息
		WebUtils.setSessionAttribute(request, "user", user);
		WebUtils.setSessionAttribute(request, "rolePoJos", rolePoJos);
		
		String multiSession = WebUtils.getParamValue("MULTI_SESSION", request);
		if(SystemConstants.ZERO.equals(multiSession)){ // 如果不允许多个用户登录
			
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
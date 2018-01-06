/*
 * Project: luna-manage-web
 * 
 * File Created at 2017年12月28日
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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Type TestController.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月28日 下午8:03:00
 * @version 
 */
@Controller
public class TestController {
	
	@RequestMapping("door.do")
	public void test(){
		System.out.println("------------------------");
	}
	
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 		每天进步一点点，长此以往，大海将会出现！
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年12月28日 于继伟 creat
 */
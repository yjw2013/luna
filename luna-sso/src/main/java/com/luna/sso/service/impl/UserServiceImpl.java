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
package com.luna.sso.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luna.sso.mapper.UserMapper;
import com.luna.sso.pojo.User;
import com.luna.sso.pojo.UserExample;
import com.luna.sso.pojo.UserExample.Criteria;
import com.luna.sso.service.UserService;
import com.taotao.common.service.RedisService;

/**
 * 单点登录系统用户业务接口实现
 * @Type UserServiceImpl.java
 * @Desc 
 * @author 于继伟
 * @date 2017年11月27日 下午4:41:31
 * @version 
 */
@Service
public class UserServiceImpl implements UserService{
		
	@Autowired
	private UserMapper userMapper;
	
	@Autowired(required = false)
    private RedisService redisService;
	
	private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final Integer REDIS_TIME = 60 * 30;
	
	@Override
	public Boolean doRegister(User user) {
        // 初始化的处理
        user.setId(null);
        user.setCreateTime(new Date());
        user.setUpdateTime(user.getCreateTime());
        // 加密处理，MD5加密
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        return this.userMapper.insert(user) == 1;
    }
	
	@Override
	public Boolean check(String param, Integer type) {
        User record = new User();

        switch (type) {
        case 1:
            record.setUserName(param);
            break;
        case 2:
            record.setPhoneNumber(param);
            break;
        case 3:
            record.setEmail(param);
            break;
        default:
            // 参数有误
            return null;
        }

        return this.userMapper.selectByPrimaryKey(record.getId()) == null;
    }

	@Override
	public String doLogin(String username, String password) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(username);
        List<User> users = this.userMapper.selectByExample(example);
        User user = users.get(0);
        if (null == user) {
            // 用户不存在
            return null;
        }

        if (!StringUtils.equals(DigestUtils.md5Hex(password), user.getPassword())) {
            // 密码错误
            return null;
        }

        // 登录成功，将用户的信息保存到Redis中
        String token = DigestUtils.md5Hex(username + System.currentTimeMillis());

        try {
			this.redisService.set("TOKEN_" + token, MAPPER.writeValueAsString(user), REDIS_TIME);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

        return token;
	}

	@Override
	public User queryUserByToken(String token) {
		String key = "TOKEN_" + token;
        String jsonData = this.redisService.get(key);
        if (StringUtils.isEmpty(jsonData)) {
            // 登录超时
            return null;
        }
        
        //重新设置Redis中的生存时间
        this.redisService.expire(key, REDIS_TIME);
        
        try {
            return MAPPER.readValue(jsonData, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
 * 2017年11月27日 于继伟 creat
 */
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
package com.luna.sso.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luna.sso.pojo.User;
import com.luna.sso.service.UserService;
import com.taotao.common.utils.CookieUtils;

/**
 * 单点登录系统对外接口
 * @Type UserController.java
 * @Desc 
 * @author 于继伟
 * @date 2017年11月27日 下午4:22:16
 * @version 
 */
@RequestMapping("user")
@Controller
public class UserController {
	
	private static final String COOKIE_NAME = "LUNA_TOKEN";
	
	@Autowired
	private UserService userService;
	
	/**
     * 注册
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "doRegister", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> doRegister(@Valid User user, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            // 没有通过校验
            result.put("status", "400");

            // 获取错误信息
            List<String> msgs = new ArrayList<String>();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                String msg = objectError.getDefaultMessage();
                msgs.add(msg);
            }

            result.put("data", "参数有误! " + StringUtils.join(msgs, '|'));

            return result;
        }
        try {
            Boolean bool = this.userService.doRegister(user);
            if (bool) {
                result.put("status", "200");
            } else {
                result.put("status", "500");
                result.put("data", " 哈哈~~~");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "500");
            result.put("data", " 哈哈~~~");
        }
        return result;
    }
	
    /**
     * 检测数据是否可用
     * 
     * @return
     */
    @RequestMapping(value = "{param}/{type}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> check(@PathVariable("param") String param,
            @PathVariable("type") Integer type) {
        try {
            Boolean bool = this.userService.check(param, type);
            if (bool == null) {
                // 参数有误
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            // 为了兼容前端逻辑，做出妥协（没有打过过前台，他赢了。。。。。。）
            return ResponseEntity.ok(!bool);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    
    /**
     * 用户登录
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> doLogin(User user, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            String token = this.userService.doLogin(user.getUserName(), user.getPassword());
            if (StringUtils.isEmpty(token)) {
                // 登录失败
                result.put("status", 500);
                return result;
            }

            // 登录成功，保存token到cookie
            result.put("status", 200);

            CookieUtils.setCookie(request, response, COOKIE_NAME, token);

        } catch (Exception e) {
            e.printStackTrace();
            // 登录失败
            result.put("status", 500);
        }
        return result;
    }
    
    /**
     * 根据token查询用户信息
     * 
     * @param token
     * @return
     */
    @RequestMapping(value = "{token}", method = RequestMethod.GET)
    public ResponseEntity<User> queryUserByToken(@PathVariable("token") String token) {
        try {
            User user = this.userService.queryUserByToken(token);
            if (null == user) {
                // 资源不存在
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        User user =new User();
//        user.setUserName("该服务没有了，以后别调用了，请访问ssoquery.taotao.com或dubbo中的服务。");
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
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
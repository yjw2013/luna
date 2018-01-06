package com.luna.manage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luna.common.aspect.annotation.ControllerLogAnnotation;
import com.luna.common.httpclient.HttpResult;
import com.luna.common.service.ApiService;
import com.luna.common.spring.SpringHelper;

/**
 * 后台管理系统
* @Title: BoysController.java 
* @Package com.luna.manage.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 于继伟  
* @date 2017年11月23日 下午6:51:31
 */
@Controller
@RequestMapping("api")
@Api(value = "用户操作接口")
public class ApiDemoController {
	
	@Autowired
	private SpringHelper springHelper;
	
	@Autowired
	private ApiService apiService;
	
	@RequestMapping(value = "{pageName}", method = RequestMethod.GET)
	@ControllerLogAnnotation
	@ApiOperation(value="查询所有对象信息")
	public String apiDemo(){
		String response = null;
		try {
			System.out.println("----------发送不带参数的GET请求----------");
			response = apiService.doGet("http://www.baidu.com");
			System.out.println("response ---- >>" + response);
			
			System.out.println("----------发送带参数的GET请求----------");
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("key", "value");
			response = apiService.doGet("http://localhost:8080/MSSERVER/service.do", params);
			System.out.println("response ---- >>" + response);
			
			System.out.println("----------发送不带参数的POST请求----------");
			HttpResult httpResult = apiService.doPost("http://localhost:8080/MSSERVER/post.do");
			System.out.println("响应码为 --- >" + httpResult.getCode());
			System.out.println("响应参数为 --- >" + httpResult.getBody());
			
			System.out.println("----------发送不带参数的POST请求----------");
			httpResult = apiService.doPost("http://localhost:8080/MSSERVER/mypost.do", params);
			System.out.println("响应码为 --- >" + httpResult.getCode());
			System.out.println("响应参数为 --- >" + httpResult.getBody());
			
			System.out.println("----------发送参数为JSON类型的POST请求----------");
			String json = "{'first': 'one','next': 'two'}";
			httpResult = apiService.doPostJson("http://localhost:8080/MSSERVER/json.do", json);
			System.out.println("响应码为 --- >" + httpResult.getCode());
			System.out.println("响应参数为 --- >" + httpResult.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

package com.luna.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
* @Title: PageController.java 
* @Package com.luna.manage.controller 
* @Description: TODO(通用跳转页面) 
* @author 于继伟  
* @date 2017年11月22日 下午8:15:38 
 */
@Controller
@RequestMapping("page")
public class PageController {
	
	/**
	 * 具体的页面跳转逻辑
	 * 
	 * @param pageName
	 * @return 视图名称
	 */
	@RequestMapping(value = "{pageName}", method = RequestMethod.GET)
    public String toPage(@PathVariable("pageName") String pageName) {
        return pageName;
    }
	
}

package com.luna.common.aspect.annotation;

import java.lang.annotation.*;    
    
/**
 * 
* @Title: ControllerLogAnnotation.java 
* @Package com.luna.manage.annotation 
* @Description: TODO(自定义注解 拦截Controller) 
* @author 于继伟  
* @date 2017年11月24日 下午4:53:06
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented    
public @interface ControllerLogAnnotation {    
    
    String description()  default "";    
    
    
}   
package com.luna.common.aspect.annotation;

import java.lang.annotation.*;    
    
/**
 * 
* @Title: ServiceLogAnnotation.java 
* @Package com.luna.manage.annotation 
* @Description: TODO(自定义注解 拦截service) 
* @author 于继伟  
* @date 2017年11月24日 下午4:53:43
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented    
public @interface ServiceLogAnnotation {    
    
    String description()  default "";    
    
    
}    
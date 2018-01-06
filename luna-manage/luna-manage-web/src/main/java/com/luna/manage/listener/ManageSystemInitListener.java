/*
 * Project: luna-manage-web
 * 
 * File Created at 2017年12月12日
 * 
 * Copyright 2016 LUNA Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.luna.manage.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;

import com.luna.common.constants.PropertiesConstants;
import com.luna.common.constants.SystemConstants;
import com.luna.common.listener.ServerContextListener;
import com.luna.common.spring.SpringHelper;
import com.luna.common.utils.DateHelper;
import com.luna.common.utils.PropertiesFactory;
import com.luna.common.utils.PropertiesHelper;
import com.luna.manage.helper.InitValueHelper;
import com.luna.manage.mapper.CantsPoJoMapper;
import com.luna.manage.mapper.CodePojoMapper;
import com.luna.manage.mapper.ParamPoJoMapper;
import com.luna.manage.pojo.CantsPoJo;
import com.luna.manage.pojo.CodePojo;
import com.luna.manage.pojo.ParamPoJo;

/**
 * 管理平台系统启动监听器
 * @Type ManageSystemInitListener.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月12日 下午10:22:46
 * @version 
 */
public class ManageSystemInitListener extends ServerContextListener{
	
	private static final String OPERATER_NAME = "【后台管理系统初始化】";
	
	private boolean success = true;
	
    @SuppressWarnings("unused")
	private ApplicationContext wac = null;
	
	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		super.contextInitialized(contextEvent); // 调用父类启动方法，这个方法可以封装更高层次的公共逻辑，可自行扩展
		systemStartup(contextEvent.getServletContext());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		super.contextDestroyed(sce); // 调用父类销毁方法，这个方法可以封装更高层次的公共逻辑，可自行扩展
	}
	
	/**
	 * 后台管理系统启动执行动作
	 * @param servletContext
	 */
	private void systemStartup(ServletContext servletContext){
		PropertiesHelper pHelper = 
				PropertiesFactory.getPropertiesHelper(PropertiesConstants.SYSTEM); // 获取system.properties
		String forceLoad = pHelper.getValue("forceLoad",
                SystemConstants.FORCELOAD_N);
		
		InitValueHelper initValueHelper = SpringHelper.getBean("initValueHelper"); // 获取字典操作Mapper
		
		long start = System.currentTimeMillis();
		if (forceLoad.equalsIgnoreCase(SystemConstants.FORCELOAD_N)) {
            logger.info("*******************************************************");
            logger.info("后台管理系统V1.0开始启动...");
            logger.info("*******************************************************");
        }
		try {
			wac = SpringHelper.getApplicationContext();
		} catch (Exception e) {
			success = false;
            e.printStackTrace();
		}
		if(success){ 
			logger.info(OPERATER_NAME + "系统开始启动字典装载程序...");
			logger.info(OPERATER_NAME + "开始装载字典...");
			CodePojoMapper codePojoMapper = initValueHelper.createCodePojoMapper();
			List<CodePojo> codePoJos = null;
			try {
				codePoJos = codePojoMapper.selectByExample(null);
			} catch (Exception e) {
				success = false;
                logger.error(OPERATER_NAME + "字典加载失败...");
                e.printStackTrace();
			}
			servletContext.setAttribute("EACODELIST", codePoJos); // 将字典参数放入缓存
		}
		if(success){
			logger.info(OPERATER_NAME + "系统开始启动全局参数表装载程序...");
            logger.info(OPERATER_NAME + "开始加载全局参数表...");
            List<ParamPoJo> paramPoJos = null;
            ParamPoJoMapper paramPoJoMapper = initValueHelper.createParamPoJoMapper();
            try {
            	paramPoJos = paramPoJoMapper.selectByExample(null);
			} catch (Exception e) {
				success = false;
                logger.error(OPERATER_NAME + "全局参数加载失败...");
			}
            servletContext.setAttribute("EAPARAMLIST", paramPoJos); // 将字典参数放入缓存
		}
		if(success){
			logger.info(OPERATER_NAME + "系统开始启动地区码表装载程序...");
            logger.info(OPERATER_NAME + "开始加载地区码表...");
            List<CantsPoJo> cantsPoJos = null;
            CantsPoJoMapper cantsPoJoMapper = initValueHelper.createCantsPoJoMapper();
            try {
            	cantsPoJos = cantsPoJoMapper.selectByExample(null);
            	List<CantsPoJo> PROVINCES = Variable.getPROVINCES();
                HashMap<String,ArrayList<CantsPoJo>> CITYS = Variable.getCITYS();
                HashMap<String,ArrayList<CantsPoJo>> AREAS = Variable.getAREAS();
                for (int i = 0; i < cantsPoJos.size(); i++)
                {
                	CantsPoJo cant= cantsPoJos.get(i);
                    if ("1".equals(cant.getCantType()))
                    {
                        PROVINCES.add(cant);
                    }else if ("2".equals(cant.getCantType())){
                        ArrayList<CantsPoJo> city = CITYS.get(cant.getSuperCode());
                        if(city == null){
                            city = new ArrayList<CantsPoJo>();
                            CITYS.put(cant.getSuperCode(), city);
                        }else {
                            city.add(cant);
                        }

                    }else if("3".equals(cant.getCantType())){
                        ArrayList<CantsPoJo> area = AREAS.get(cant.getSuperCode());
                        if(area == null){
                            area = new ArrayList<CantsPoJo>();
                            AREAS.put(cant.getSuperCode(), area);
                        }else {
                            area.add(cant);
                        }
                    }
                    continue;

                }
                logger.info(OPERATER_NAME + "地区码表加载成功...");
			} catch (Exception e) {
				success = false;
                logger.error(OPERATER_NAME + "地区码表加载失败...");
			}
            long timeSec = (System.currentTimeMillis() - start) / 1000;
            logger.info("********************************************");
            if (success) {
            	logger.info("开发平台启动成功[" + DateHelper.getNowTime() + "]");
            	logger.info("启动总耗时: " + timeSec / 60 + "分 " + timeSec % 60 + "秒 ");
            } else {
            	logger.error("开发平台启动失败[" + DateHelper.getNowTime() + "]");
            	logger.error("启动总耗时: " + timeSec / 60 + "分" + timeSec % 60 + "秒");
            }
            logger.info("********************************************");
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
 * 2017年12月12日 于继伟 creat
 */
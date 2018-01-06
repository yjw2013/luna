/*
 * Project: luna-common
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
package com.luna.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.luna.common.support.model.BaseDto;
import com.luna.common.support.model.Dto;
import com.luna.common.support.model.SessionContainer;

/**
 * 和Web表现层相关的工具类
 * @Type WebUtils.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月11日 下午8:32:58
 * @version 
 */
public class WebUtils {
	
	private static Log log = LogFactory.getLog(WebUtils.class);

    /**
     * 获取一个SessionContainer容器,如果为null则创建之
     *
     * @param request
     */
    public static SessionContainer getSessionContainer(
            HttpServletRequest request) {
        HttpSession httpSession = null;
        try {
            httpSession = request.getSession();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        if (httpSession == null) {
            return null;
        }
        SessionContainer sessionContainer = (SessionContainer) httpSession
                .getAttribute("SessionContainer");
        if (sessionContainer == null) {
            sessionContainer = new SessionContainer();
            HttpSession session = request.getSession(true);
            session.setAttribute("SessionContainer", sessionContainer);
        }
        return sessionContainer;
    }

    /**
     * 获取一个SessionContainer容器,如果为null则创建之
     *
     * @param session
     */
    public static SessionContainer getSessionContainer(HttpSession session) {
        SessionContainer sessionContainer = (SessionContainer) session
                .getAttribute("SessionContainer");
        if (sessionContainer == null) {
            sessionContainer = new SessionContainer();
            session.setAttribute("SessionContainer", sessionContainer);
        }
        return sessionContainer;
    }

    /**
     * 获取一个Session属性对象
     *
     * @param request
     * @param sessionKey
     * @return
     */
    public static Object getSessionAttribute(HttpServletRequest request,
                                             String sessionKey) {
        Object objSessionAttribute = null;
        HttpSession session = request.getSession(false);
        if (session != null) {
            objSessionAttribute = session.getAttribute(sessionKey);
        }
        return objSessionAttribute;
    }

    /**
     * 设置一个Session属性对象
     *
     * @param request
     * @param sessionKey
     * @param objSessionAttribute
     * @return
     */
    public static void setSessionAttribute(HttpServletRequest request,
                                           String sessionKey, Object objSessionAttribute) {
        HttpSession session = request.getSession();
        if (session != null)
            session.setAttribute(sessionKey, objSessionAttribute);
    }

    /**
     * 移除Session对象属性值
     *
     * @param request
     * @param sessionKey
     * @return
     */
    public static void removeSessionAttribute(HttpServletRequest request,
                                              String sessionKey) {
        HttpSession session = request.getSession();
        if (session != null)
            session.removeAttribute(sessionKey);
    }

    /**
     * 将请求参数封装为Dto
     *
     * @param request
     * @return
     */
    @SuppressWarnings("rawtypes")
	public static Dto getParamAsDto(HttpServletRequest request) {
        Dto dto = new BaseDto();
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map map = request.getParameterMap();
        Iterator keyIterator = (Iterator) map.keySet().iterator();
        while (keyIterator.hasNext()) {
            String key = (String) keyIterator.next();
            String value = Escape.unescape(((String[]) (map.get(key)))[0]);
            dto.put(key, value);
        }
        log.debug("-  >>  >>【请求参数】" + dto);
        return dto;
    }

    /**
     * 获取代码对照值
     *
     * @param pField  代码类别
     * @param pCode   代码值
     * @param request
     * @return
     */
    public static String getCodeDesc(String pField, String pCode,
                                     HttpServletRequest request) {
        List<?> codeList = (List<?>) request.getSession().getServletContext()
                .getAttribute("EACODELIST");
        String codedesc = null;
        for (int i = 0; i < codeList.size(); i++) {
            Dto codeDto = (BaseDto) codeList.get(i);
            if (pField.equalsIgnoreCase(codeDto.getAsString("field"))
                    && pCode.equalsIgnoreCase(codeDto.getAsString("code")))
                codedesc = codeDto.getAsString("codedesc");
        }
        return codedesc;
    }

    /**
     * 根据代码类别获取代码表列表
     *
     * @param pField
     * @param request
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getCodeListByField(String pField,
                                          HttpServletRequest request) {
        List codeList = (List) request.getSession().getServletContext()
                .getAttribute("EACODELIST");
        List lst = new ArrayList();
        for (int i = 0; i < codeList.size(); i++) {
            Dto codeDto = (BaseDto) codeList.get(i);
            if (codeDto.getAsString("field").equalsIgnoreCase(pField)) {
                lst.add(codeDto);
            }
        }
        return lst;
    }

    /**
     * 获取全局参数值
     *
     * @param pParamKey 参数键名
     * @return
     */
    public static String getParamValue(String pParamKey,
                                       HttpServletRequest request) {
        String paramValue = "";
        ServletContext context = request.getSession().getServletContext();
        if (BeanHelper.isEmpty(context)) {
            return "";
        }
        List<?> paramList = (List<?>) context.getAttribute("EAPARAMLIST");
        for (int i = 0; i < paramList.size(); i++) {
            Dto paramDto = (BaseDto) paramList.get(i);
            if (pParamKey.equals(paramDto.getAsString("paramkey"))) {
                paramValue = paramDto.getAsString("paramvalue");
            }
        }
        return paramValue;
    }
    

    /**
     * 获取全局参数
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
	public static List getParamList(HttpServletRequest request) {
        ServletContext context = request.getSession().getServletContext();
        if (BeanHelper.isEmpty(context)) {
            return new ArrayList();
        }
        return (List) context.getAttribute("EAPARAMLIST");
    }

    /**
     * 获取指定Cookie的值
     *
     * @param cookies      cookie集合
     * @param cookieName   cookie名字
     * @param defaultValue 缺省值
     * @return
     */
    public static String getCookieValue(Cookie[] cookies, String cookieName,
                                        String defaultValue) {
        if (cookies == null) {
            return defaultValue;
        }
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookieName.equals(cookie.getName()))
                return (cookie.getValue());
        }
        return defaultValue;
    }

    /**
     * 获取角色列表
     *
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<String> getRoleList(HttpServletRequest request) {
        List<String> roleList = new ArrayList();

        List list = (List) getSessionAttribute(request, "roleList");

        for (int i = 0; i < list.size(); i++) {
            Dto roleDto = (BaseDto) list.get(i);
            roleList.add(roleDto.getAsString("ROLE_ID"));
        }
        return roleList;
    }


    /**
     * 获取角色列表
     *
     * @return
     */
	public static String isSuper(HttpServletRequest request) {
//        UserInfoVo userInfo = (UserInfoVo) WebUtils.getSessionAttribute(request, "userInfo");

//        String issuper = "1";
//        if (userInfo != null && userInfo.getUsertype().equals("0")) {
//            issuper = "0";
//        }
//        return issuper;
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
 * 2017年12月11日 于继伟 creat
 */
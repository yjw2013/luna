/*
 * Project: luna-common
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
package com.luna.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * IP地址的帮助类
 * @Type IpHelper.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月12日 下午9:40:54
 * @version 
 */
public class IpHelper {
		
	private static Logger logger = Logger.getLogger(IpHelper.class);

	/**
	 * 获取客户端的地址
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ipAddr = null; 
		ipAddr = request.getHeader("x-forwarded-for");
		if (ipAddr == null || ipAddr.length() == 0 || "unknown".equalsIgnoreCase(ipAddr)) {
			ipAddr = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddr == null || ipAddr.length() == 0 || "unknown".equalsIgnoreCase(ipAddr)) {
			ipAddr = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddr == null || ipAddr.length() == 0 || "unknown".equalsIgnoreCase(ipAddr)) {
			ipAddr = request.getRemoteAddr();
			if ("127.0.0.1".equals(ipAddr) || "0:0:0:0:0:0:0:1".equals(ipAddr)) {
				//根据网卡取本机配置的IP   
				try {
					InetAddress inet = InetAddress.getLocalHost();
					ipAddr = inet.getHostAddress();
				} catch (UnknownHostException e) {
					e.printStackTrace();
					logger.error("获取客户端ip地址出错了！",e);
				}
			}
		}

		//对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割   
		if (ipAddr != null && ipAddr.length() > 15) {//ip地址中最多12位数字+3个点，如：***.***.***.***
			if (ipAddr.indexOf(",") > 0) {
				ipAddr = ipAddr.substring(0, ipAddr.indexOf(","));
			}
		}
		return ipAddr;
	}
	
	/**
	 * 获取本机ip地址
	 * @return
	 */
	public static String getLocalIP() {
		String LocalIp = "";
		try {
			InetAddress[] mArLocalIP = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
			LocalIp = null != mArLocalIP && mArLocalIP.length > 0 ? mArLocalIP[0].getHostAddress() : LocalIp;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取本机ip地址出错了！",e);
		}
		return LocalIp;
	}
	
	/**
	 * 通过IP地址获取请求用户的MAC地址
	 * @param ip
	 * @return
	 */
	public static String getMACAddress(String ip){
		String macAddress = "";
		String os = System.getProperty("os.name").toLowerCase();
		
		//windows 7操作系统  
		if(os.equals("windows 7")){
			macAddress = getMACAddressOfWin7(ip);
		}
		//其他版本的windows系统
		else if(os.startsWith("windows")){
			macAddress = getMACAddressOfWindows(ip);
		}
		//其他系统，一般是指linux 
		else{
			macAddress = getMACAddressOfLinux(ip);
		}
		return macAddress;
	}

	/**
	 * 通过IP地址获取请求用户的MAC地址 - 针对windows 7操作系统
	 * @param ip
	 * @return
	 */
	private static String getMACAddressOfWin7(String ip){
		String macAddress = "";
		try {
			//获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。  
			InetAddress inetAddress = InetAddress.getByName(ip);
	        byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();  
	        
	        //把mac地址拼装成String  
	        StringBuffer sb = new StringBuffer();  
	        for (int i = 0; i < mac.length; i++) {
	            String s = Integer.toHexString(mac[i] & 0xFF); // mac[i] & 0xFF 是为了把byte转化为正整数 
	            sb.append(i != 0 ? "-" : "").append(s.length() == 1 ? 0 + s : s);  
	        }  
	        macAddress = sb.toString().toUpperCase();  
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}  
        return macAddress;  
	}

	/**
	 * 通过IP地址获取请求用户的MAC地址 - 针对其他版本的windows操作系统
	 * @param ip
	 * @return
	 */
	private static String getMACAddressOfWindows(String ip){
		String macAddress = "";
		try {
			Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (null != line && line.trim().length() != 0) {
					if(line.indexOf("MAC Address") > -1){
						macAddress = line.substring(line.indexOf("MAC Address") + 14).trim();
						break;
					}else if(line.indexOf("MAC 地址") > -1){
						macAddress = line.substring(line.indexOf("MAC 地址") + 9).trim();
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return macAddress;
	}

	/**
	 * 通过IP地址获取请求用户的MAC地址 - 针对linux操作系统
	 * @param ip
	 * @return
	 */
	private static String getMACAddressOfLinux(String ip){
		String macAddress = "";
		try {
			//linux下的命令，一般取eth0作为本地主网卡  
			Process p = Runtime.getRuntime().exec("ifconfig eth0");  
			
	        // 显示信息中包含有mac地址信息  
			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader br = new BufferedReader(isr);  
	        String line = null;  
	        int index = -1; 
	        while ((line = br.readLine()) != null) {  
	            index = line.toLowerCase().indexOf("hwaddr");  
	            if (index > -1) {  
	            	macAddress = line.substring(index + 7).trim();  
	                break;  
	            }  
	        }  
		} catch (IOException e) {
			e.printStackTrace();
		}
		return macAddress;
	}
	
	/**
	 * 通过IP判断这台机子网络是否正常连接
	 * @param ip
	 * @return
	 */
	public static boolean isNetReachable(String ip){
		boolean b = false;
		try {
			InetAddress inetAddress = InetAddress.getByName(ip);
			b = inetAddress.isReachable(5*1000);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}	
		return b;
	}
	
	public static void main(String[] args) {
		
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
/*
 * Project: luna-common
 * 
 * File Created at 2017年12月13日
 * 
 * Copyright 2016 LUNA Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.luna.common.support.ftp;

import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.luna.common.exception.FtpException;
import com.luna.common.utils.PropertiesUtil;

/**
 * @Type SftpClient.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月13日 下午10:24:32
 * @version 
 */
public class SftpClient {
	
	private Logger logger = LogManager.getLogger(SftpClient.class);
	
    private Session session = null;
    
    private ChannelSftp channel = null;

    private SftpClient() {
    }

    public static SftpClient connect() {
        return new SftpClient().init();
    }

    public SftpClient init() {
        try {
            Properties config = new Properties();
            String host = PropertiesUtil.getString("sftp.host");
            int port = PropertiesUtil.getInt("sftp.port");
            String userName = PropertiesUtil.getString("sftp.user.name");
            String password = PropertiesUtil.getString("sftp.user.password");
            int timeout = PropertiesUtil.getInt("sftp.timeout");
            int aliveMax = PropertiesUtil.getInt("sftp.aliveMax");
            JSch jsch = new JSch(); // 创建JSch对象
            session = jsch.getSession(userName, host, port); // 根据用户名，主机ip，端口获取一个Session对象
            if (password != null) {
                session.setPassword(password); // 设置密码
            }
            config.put("userauth.gssapi-with-mic", "no");
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config); // 为Session对象设置properties
            session.setTimeout(timeout); // 设置timeout时间
            session.setServerAliveCountMax(aliveMax);
            session.connect(); // 通过Session建立链接
            channel = (ChannelSftp)session.openChannel("sftp"); // 打开SFTP通道
            channel.connect(); // 建立SFTP通道的连接
            logger.info("SSH Channel connected.");
        } catch (JSchException e) {
            throw new FtpException("", e);
        }
        return this;
    }

    public void disconnect() {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
            logger.info("SSH Channel disconnected.");
        }
    }

    /** 发送文件 */
    public void put(String src, String dst) {
        try {
            channel.put(src, dst, new FileProgressMonitor());
        } catch (SftpException e) {
            throw new FtpException("", e);
        }
    }

    /** 获取文件 */
    public void get(String src, String dst) {
        try {
            channel.get(src, dst, new FileProgressMonitor());
        } catch (SftpException e) {
            throw new FtpException("", e);
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
 * 2017年12月13日 于继伟 creat
 */
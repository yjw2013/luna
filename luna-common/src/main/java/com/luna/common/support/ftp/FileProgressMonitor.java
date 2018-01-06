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

import java.text.DecimalFormat;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jcraft.jsch.SftpProgressMonitor;

/**
 * @Type FileProgressMonitor.java
 * @Desc 
 * @author 于继伟
 * @date 2017年12月13日 下午10:35:20
 * @version 
 */
public class FileProgressMonitor implements SftpProgressMonitor {
	
	private final Logger logger = LogManager.getLogger(FileProgressMonitor.class);
	
	private long transfered; // 记录已传输的数据总大小
	
	private long fileSize; // 记录文件总大小
	
	private int minInterval = 100; // 打印日志时间间隔
	
	private long start; // 开始时间
	
	private DecimalFormat df = new DecimalFormat("#.##");
	private long preTime;

	/** 传输开始 */
	public void init(int op, String src, String dest, long max) {
		this.fileSize = max;
		logger.info("Transferring begin.");
		start = System.currentTimeMillis();
	}

	/** 传输中 */
	public boolean count(long count) {
		if (fileSize != 0 && transfered == 0) {
			logger.info("Transferring progress message: {}%" + df.format(0));
			preTime = System.currentTimeMillis();
		}
		transfered += count;
		if (fileSize != 0) {
			long interval = System.currentTimeMillis() - preTime;
			if (transfered == fileSize || interval > minInterval) {
				preTime = System.currentTimeMillis();
				double d = ((double) transfered * 100) / (double) fileSize;
				logger.info("Transferring progress message: {}%" + df.format(d));
			}
		} else {
			logger.info("Transferring progress message: " + transfered);
		}
		return true;
	}

	/** 传输结束 */
	public void end() {
		logger.info("Transferring end. used time: {}ms" + ( System.currentTimeMillis() - start ));
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
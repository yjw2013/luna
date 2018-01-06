/*
 * Project: luna-common
 * 
 * File Created at 2017年11月28日
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

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 图片工具类
 * @Type ImageHelper.java
 * @Desc 
 * @author 于继伟
 * @date 2017年11月28日 下午9:50:24
 * @version 
 */
@SuppressWarnings("restriction")
public class ImageHelper {
	/**
	 * @描述：Base64解码并生成图片
	 * @入参：@param imgStr
	 * @入参：@param imgFile
	 * @入参：@throws IOException
	 * @出参：void
	 */
	public static void generateImage(String imgStr, String imgFile) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		// Base64解码
		byte[] bytes;
		OutputStream out = null;
		try {
			bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成图片
			out = new FileOutputStream(imgFile);
			out.write(bytes);
			out.flush();
		} catch (IOException e) {
			throw new IOException();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * @throws IOException
	 * @描述：根据路径得到base编码后图片
	 * @入参：@param imgFilePath
	 * @入参：@return
	 * @出参：String
	 */
	public static String getImageStr(String imgFilePath) throws IOException {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		byte[] data = null;

		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			throw new IOException();
		}

		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	/**
	 * @描述：base64转为io流
	 * @入参：@param strBase64
	 * @入参：@return
	 * @入参：@throws IOException
	 * @出参：InputStream
	 */
	public static InputStream base64ToIo(String strBase64) throws IOException {
		// 解码，然后将字节转换为文件
		byte[] bytes = new BASE64Decoder().decodeBuffer(strBase64); // 将字符串转换为byte数组
		return new ByteArrayInputStream(bytes);
	}
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 		每天进步一点点，长此以往，大海将会出现！
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年11月28日 于继伟 creat
 */
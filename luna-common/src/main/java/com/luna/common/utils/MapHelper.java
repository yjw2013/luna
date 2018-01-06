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

import java.util.Map;

/**
 * Map工具类
 * @Type MapHelper.java
 * @Desc 
 * @author 于继伟
 * @date 2017年11月28日 下午9:51:40
 * @version 
 */
public class MapHelper {
	/**
	 * 获得字串值
	 *
	 * @param name
	 *            键值名称
	 * @return 若不存在，则返回空字串
	 */
	public static String getString(Map<?, ?> map, String name) {
		if (name == null || name.equals("")) {
			return "";
		}

		String value = "";
		if (map.containsKey(name) == false) {
			return "";
		}
		Object obj = map.get(name);
		if (obj != null) {
			value = obj.toString();
		}
		obj = null;

		return value;
	}

	/**
	 * 返回整型值
	 *
	 * @param name
	 *            键值名称
	 * @return 若不存在，或转换失败，则返回0
	 */
	public static int getInt(Map<?, ?> map, String name) {
		if (name == null || name.equals("")) {
			return 0;
		}

		int value = 0;
		if (map.containsKey(name) == false) {
			return 0;
		}

		Object obj = map.get(name);
		if (obj == null) {
			return 0;
		}

		if (!(obj instanceof Integer)) {
			try {
				value = Integer.parseInt(obj.toString());
			} catch (Exception ex) {
				ex.printStackTrace();
				System.err.println("name[" + name + "]对应的值不是数字，返回0");
				value = 0;
			}
		} else {
			value = ((Integer) obj).intValue();
			obj = null;
		}

		return value;
	}

	/**
	 * 获取长整型值
	 *
	 * @param name
	 *            键值名称
	 * @return 若不存在，或转换失败，则返回0
	 */
	public static long getLong(Map<?, ?> map, String name) {
		if (name == null || name.equals("")) {
			return 0;
		}

		long value = 0;
		if (map.containsKey(name) == false) {
			return 0;
		}

		Object obj = map.get(name);
		if (obj == null) {
			return 0;
		}

		if (!(obj instanceof Long)) {
			try {
				value = Long.parseLong(obj.toString());
			} catch (Exception ex) {
				ex.printStackTrace();
				System.err.println("name[" + name + "]对应的值不是数字，返回0");
				value = 0;
			}
		} else {
			value = ((Long) obj).longValue();
			obj = null;
		}

		return value;
	}

	/**
	 * 获取Float型值
	 *
	 * @param name
	 *            键值名称
	 * @return 若不存在，或转换失败，则返回0
	 */
	public static float getFloat(Map<?, ?> map, String name) {
		if (name == null || name.equals("")) {
			return 0;
		}

		float value = 0;
		if (map.containsKey(name) == false) {
			return 0;
		}

		Object obj = map.get(name);
		if (obj == null) {
			return 0;
		}

		if (!(obj instanceof Float)) {
			try {
				value = Float.parseFloat(obj.toString());
			} catch (Exception ex) {
				ex.printStackTrace();
				System.err.println("name[" + name + "]对应的值不是数字，返回0");
				value = 0;
			}
		} else {
			value = ((Float) obj).floatValue();
			obj = null;
		}

		return value;
	}

	/**
	 * 获取Double型值
	 *
	 * @param name
	 *            键值名称
	 * @return 若不存在，或转换失败，则返回0
	 */
	public static double getDouble(Map<?, ?> map, String name) {
		if (name == null || name.equals("")) {
			return 0;
		}

		double value = 0;
		if (map.containsKey(name) == false) {
			return 0;
		}

		Object obj = map.get(name);
		if (obj == null) {
			return 0;
		}

		if (!(obj instanceof Double)) {
			try {
				value = Double.parseDouble(obj.toString());
			} catch (Exception ex) {
				ex.printStackTrace();
				System.err.println("name[" + name + "]对应的值不是数字，返回0");
				value = 0;
			}
		} else {
			value = ((Double) obj).doubleValue();
			obj = null;
		}

		return value;
	}

	/**
	 * 获取Bool值
	 *
	 * @param name
	 *            键值名称
	 * @return 若不存在，或转换失败，则返回false
	 */
	public static boolean getBoolean(Map<?, ?> map, String name) {
		if (name == null || name.equals("")) {
			return false;
		}

		boolean value = false;
		if (map.containsKey(name) == false) {
			return false;
		}
		Object obj = map.get(name);
		if (obj == null) {
			return false;
		}

		if (obj instanceof Boolean) {
			return ((Boolean) obj).booleanValue();
		}

		value = Boolean.valueOf(obj.toString()).booleanValue();
		obj = null;
		return value;
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
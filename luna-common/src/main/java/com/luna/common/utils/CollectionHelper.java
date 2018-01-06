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

import java.util.ArrayList;
import java.util.List;

/**
 * 集合工具类
 * @Type CollectionHelper.java
 * @Desc 
 * @author 于继伟
 * @date 2017年11月28日 下午9:40:45
 * @version 
 */
public class CollectionHelper {
	
	/**
	 * 分成指定大小的多份List
	 * 
	 * @param list 源List
	 * @param blockSize 你要分成的list每个list的size是多少
	 * @return
	 */
	public static <T> List<List<T>> subList(List<T> list, int blockSize) {  
        List<List<T>> lists = new ArrayList<List<T>>();  
        if (list != null && blockSize > 0) {  
            int listSize = list.size();  
            if(listSize<=blockSize){  
                lists.add(list);  
                return lists;  
            }  
            int batchSize = listSize / blockSize;  
            int remain = listSize % blockSize;  
            for (int i = 0; i < batchSize; i++) {  
                int fromIndex = i * blockSize;  
                int toIndex = fromIndex + blockSize;  
                System.out.println("fromIndex=" + fromIndex + ", toIndex=" + toIndex);  
                lists.add(list.subList(fromIndex, toIndex));  
            }  
            if(remain>0){  
                System.out.println("fromIndex=" + (listSize-remain) + ", toIndex=" + (listSize));  
                lists.add(list.subList(listSize-remain, listSize));  
            }  
        }  
        return lists;  
    }  
	
	/**
	 * 将线性表分成平均的份数
	 * @param source 源线性表
	 * @param n 需要分成几份线性表
	 * @return
	 */
	public static <T> List<List<T>> averageAssign(List<T> source,int n){  
	    List<List<T>> result=new ArrayList<List<T>>();  
	    int remaider=source.size()%n;  //(先计算出余数)  
	    int number=source.size()/n;  //然后是商  
	    int offset=0;//偏移量  
	    for(int i=0;i<n;i++){  
	        List<T> value=null;  
	        if(remaider>0){  
	            value=source.subList(i*number+offset, (i+1)*number+offset+1);  
	            remaider--;  
	            offset++;  
	        }else{  
	            value=source.subList(i*number+offset, (i+1)*number+offset);  
	        }  
	        result.add(value);  
	    }  
	    return result;  
	}  
	
	/**
	 * 判断线性表是否为空
	 * @param collection
	 * @return
	 */
	public static boolean isEmpty(List<?> list){
		if(list.size() == 0 || null == list){
			return true;
		}
		return false;
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
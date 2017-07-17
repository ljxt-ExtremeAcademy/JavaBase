package com.xuetang9.javabase.chapter9;

import java.util.Collections;

/**
 * 加强版的字符串 - 带缓存的字符串
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月15日 下午2:16:49
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class StringBufferDemo {
	public static void main(String[] args) {
		StringBuffer strBuffer = new StringBuffer("你好，成都！");
		StringBuffer strBuffer1 = new StringBuffer("你好，成都！");
		StringBuffer strBuffer2 = new StringBuffer("你好，成都！");
		
		System.out.println(strBuffer.reverse());	//反转字符串
		
		//strBuffer1.insert(3, "3L");					//在规定的下标处插入元素
		//System.out.println(strBuffer1);
		
		//strBuffer2.deleteCharAt(3);
		//System.out.println(strBuffer2);
		strBuffer2.delete(2, 4);					//删除[2, 4)下标之间的元素
		System.out.println(strBuffer2);
		
		strBuffer1.replace(2, 4, "北京");
		System.out.println(strBuffer1);
		
		strBuffer.setCharAt(3, '神');
		System.out.println(strBuffer);
		
		System.out.println("缓存大小：" + strBuffer.capacity());
		
		strBuffer.setLength(0);						//相当于清空了字符串对象
		
		
		strBuffer.trimToSize();
		
		
		
		
		
		
		
//		final int N = 500000;	//10万
//		long startTime = System.currentTimeMillis();
//		String str = "*";
//		for(int i = 0; i < N; i++){//10万次循环
//			str += "*";
//		}
//		long endTime = System.currentTimeMillis();
//		System.out.println("+=用时：" + (endTime - startTime) + "毫秒");
//
//		//使用StringBuffer进行字符串拼接
//		startTime = System.currentTimeMillis();
//		StringBuffer str1 = new StringBuffer("*");
//		for(int i = 0; i < N; i++){//10万次循环
//			str1.append("*");
//		}
//		endTime = System.currentTimeMillis();
//		System.out.println("StringBuffer的append用时：" + (endTime - startTime) + "毫秒");
//		
//		//StringBuilder
//		startTime = System.currentTimeMillis();
//		StringBuilder str2 = new StringBuilder("*");
//		for(int i = 0; i < N; i++){//10万次循环
//			str2.append("*");
//		}
//		endTime = System.currentTimeMillis();
//		System.out.println("StringBuilder的append用时：" + (endTime - startTime) + "毫秒");
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

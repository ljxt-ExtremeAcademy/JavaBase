package com.xuetang9.javabase.chapter14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * TODO
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月29日 下午6:00:46
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class ArrayListAndLinkedListDemo {
	/**
	 * 在实际开发中，有可能两种情况（随机访问和删除、插入）交替出现
	 * 建议使用父接口List，不用关心具体的实现
	 * 在具体的情况下，传入或转换成相应的子类型进行使用即可
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		//list.addAll(c)
		System.out.println("ArrayList耗时：" + CostTime(new ArrayList<>()));
		
		System.out.println("LinkedList耗时：" + CostTime(new LinkedList<>()));
	}
	
	public static long CostTime(List<Object> list){
		Object obj = new Object();
		final int N = 150000;
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			list.add(obj);			//每次在集合的最后一个位置添加元素
			//list.add(0, obj);   	//每次向集合的0号位置添加元素
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

}

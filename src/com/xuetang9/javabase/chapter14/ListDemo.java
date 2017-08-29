package com.xuetang9.javabase.chapter14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {

	public static void main(String[] args) {
		ArrayListDemo();
//		System.out.println("ArrayList耗时：" + TimeCost(new ArrayList<>()));
//		System.out.println("LinkedList耗时：" + TimeCost(new LinkedList<>()));
	}
	
	/**
	 * 设计一个通用方法，在第一个位置处连续添加元素
	 * 返回不同类型集合的执行时间
	 * @param list
	 * @return
	 */
	public static long TimeCost(List<Object> list){
		final int N = 500000;
		long startTime = System.currentTimeMillis();
		Object obj = new Object();
		for(int i = 0; i < N; i++){
			list.add(0, obj);//在集合的首位置处连续添加N个元素
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
	public static void ArrayListDemo(){
		//使用常见的子类ArrayList进行实现父接口List
		//注意：这里的ArrayList可以替换成List接口的其他子类，操作方法一样！
		List<String> stringList = new ArrayList<String>();//动态数组
		stringList.add("red");
		stringList.add("blue");
		stringList.add("green");
		System.out.println(stringList);
		stringList.add(0, "orange");
		System.out.println(stringList);
		stringList.add(2, "yellow");
		//System.out.println(stringList);
		//System.out.println("subList:" + stringList.subList(1, 3)); //与String的方法类型，左闭右开
		stringList.remove("blue");
		System.out.println(stringList);
		
		//集合的遍历 / 迭代
		for (int i = 0; i < stringList.size(); i++) {
			System.out.print(stringList.get(i) + ", ");
		}
		System.out.println();
		
		for(String str : stringList){
			System.out.print(str + ", ");
		}
		System.out.println();
		
		System.out.println("使用迭代器迭代：");
		//1.获得集合的迭代器
		Iterator<String> it =  stringList.iterator();
		//2.使用固定的迭代器操作方法，迭代集合
		while(it.hasNext()){
			System.out.print(it.next() + ", ");
		}
		System.out.println();
		
		//使用升级版的迭代器
		//注意：传统的迭代器只能按顺序向后访问，并且不能修改集合中的元素
		//      ListIterator既可以向前也可以向后访问，并且可以修改集合中的元素！
		ListIterator<String> listIt = stringList.listIterator(stringList.size());
		//从后向前迭代
		while(listIt.hasPrevious()){
			System.out.print(listIt.previous() + ", ");
		}
		System.out.println();
		//可以通过迭代器添加元素
		listIt.set("abc");
		System.out.println(stringList);
		
		List<String> linkedList = new LinkedList<>();
		linkedList.addAll(stringList);
		System.out.println("linkedList:" + linkedList);
	}

}





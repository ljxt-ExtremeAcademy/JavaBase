package com.xuetang9.javabase.chapter14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsDemo {

	public static void main(String[] args) {
		List<Integer> intCollection = new ArrayList<>();
		intCollection.add(123);
		intCollection.add(120);
		intCollection.add(124);
		intCollection.add(122);
		intCollection.add(127);
		intCollection.add(126);	
		
		intCollection.forEach(value -> System.out.print(value + ", "));
		Collections.shuffle(intCollection, new Random(20));
		System.out.println("\n乱序后：");
		intCollection.forEach(value -> System.out.print(value + ", "));
		
		Collections.shuffle(intCollection, new Random(20));
		System.out.println("\n乱序后：");
		intCollection.forEach(value -> System.out.print(value + ", "));
		
		System.out.println("集合的复制");		
		List<Integer> longCollection = new ArrayList<>();
		longCollection.add(0);
		longCollection.add(0);
		longCollection.add(0);
		longCollection.add(0);
		longCollection.add(0);
		longCollection.add(0);
		Collections.copy(longCollection, intCollection);
		longCollection.forEach(value -> System.out.print(value + ", "));
		longCollection.add(126);
		//对比两个集合中没有公共元素
		System.out.println(Collections.disjoint(intCollection, longCollection));
		
		System.out.println("返回集合中指定元素出现的次数" + Collections.frequency(longCollection, 126));
		
		
		//补充：使用Arrays.asList转换成的List集合中，无法执行add方法
		List<String> strList = Arrays.asList("abc", "123", "321");
		strList.add("111");
		
		
		

	}

}

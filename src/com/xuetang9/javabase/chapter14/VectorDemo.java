package com.xuetang9.javabase.chapter14;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
	public static void main(String[] args) {
		//Vector从Java1.0起就存在了，ArrayList从Java1.2才开始存在
		//Vector的使用场景：JavaMe等一些微小版本中都可以使用，但是ArrayList不可以
		//在Java1.2之前，Vector就被广泛的应用在了Java设计中，因为它可以实现可变大小的数组
		//特别是大多数Swing的数据模型都使用了Vector
		//相较ArrayList，Vector中的方法采用线程同步，所以效率比ArrayList低
		
		Vector<String> vec = new Vector<>();
		vec.add("天龙八部");			//会返回boolean值
		vec.addElement("天龙九部");	//无返回值
		vec.add("aaa");
		vec.add("aaa");
		vec.add("aaa");
		vec.add("aaa");
		vec.add("aaa");
		vec.add("aaa");
		vec.add("aaa");
		vec.add("aaa");
		vec.add("aaa");
		System.out.println("size:" + vec.size());
		System.out.println("容量：" + vec.capacity());
		vec.trimToSize();
		System.out.println("trim后的容量：" + vec.capacity());
		vec.ensureCapacity(3000);
		System.out.println("ensureCapacity后的容量：" + vec.capacity());
		
		//Vector的遍历
		for(int i = 0; i < vec.size(); i++){
			System.out.print(vec.get(i) + ", ");
		}
		System.out.println();
		//vec.iterator()  迭代器的使用与List相同
		
		//使用枚举遍历 - 早期版本的方式 - 已被Iterator取代
		Enumeration<String> vecEnum = vec.elements();
		while(vecEnum.hasMoreElements()){
			System.out.print(vecEnum.nextElement() + ", ");
		}
		System.out.println();
		
		//Lambda表达式遍历
		System.out.println("使用Lambda表达式遍历");
		vec.forEach(str -> System.out.print(str + ", "));
		
		//查询元素
		System.out.println("第一个元素：" + vec.firstElement());
		System.out.println("最后一个元素：" + vec.lastElement());
		System.out.println("下标为1的元素：" + vec.elementAt(1) + "\t" + vec.get(1));
		
		vec.removeElementAt(19);// java.lang.ArrayIndexOutOfBoundsException: 19 >= 11
		System.out.println("删除后：");
		vec.forEach(str -> System.out.print(str + ", "));
		
	}
}








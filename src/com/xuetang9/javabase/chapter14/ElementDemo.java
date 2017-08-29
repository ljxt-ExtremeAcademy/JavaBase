package com.xuetang9.javabase.chapter14;
/**
 * 简单讲解泛型编程中E的含义及用法
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月29日 上午10:28:24
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class ElementDemo<E> {
	Object[] objs = new Object[999];
	
	public void add(E e){
		objs[0] = e;
	}
	
	public static void main(String[] args) {
		//<String> 表示定义E类型就是String类型
		ElementDemo<String> elementDemo = new ElementDemo<String>();
		//elementDemo.add(1);   //如果传递的参数是非约束类型String，程序在编译器就会报错-程序更加健壮
	}
	
//	public void add(String value){
//		//1.获得数组当前的实际容量
//		//2.将value元素添加到数组中第一个为null的位置
//		objs[0] = value;
//		
//		//value就被自动转型成了Object类型
//		String str1 = (String)objs[0];	//使用对象数组时的最大问题：强制转换时容易引发未知类型的异常
//		String str2 = (String)objs[1];	//编译时无异常，运行时出现 java.lang.ClassCastException
//		String str3 = (String)objs[2];
//		System.out.println(str1 + ", " + str2 + ", " + str3);
//	}
//	
//	public void add(Integer intValue){
//		//向对象数组objs中添加整型对象
//		objs[1] = intValue;
//	}
//	
//	public void add(Student stu){
//		//向数组中添加stu对象
//		objs[2] = stu;
//	}
//	
//	public static void main(String[] args) {
//		ElementDemo demo = new ElementDemo();
//		demo.add(2);
//		demo.add(new Student());
//		demo.add("abc");
//	}
}
class Student{
	
}






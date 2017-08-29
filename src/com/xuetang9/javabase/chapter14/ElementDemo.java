package com.xuetang9.javabase.chapter14;
/**
 * 理解泛型的基本含义
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月29日 下午3:49:27
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class ElementDemo<E> {
	Object[] objs = new Object[999];
	
	public static void main(String[] args) {
		//运行时给定类型
		ElementDemo<Integer> demo = new ElementDemo<Integer>();
		demo.add(12);//使用泛型后，类型错误时就会产生编译期的异常
		
		ElementDemo<String> demo1 = new ElementDemo<>();
		
		//
//		objs[0] = 1024;
//		objs[1] = "abc";
//		objs[2] = 19.9;
//		objs[3] = new Student();
//		
//		//从对象数组中取出对象进行操作
//		Integer value1 = (Integer)objs[0];
//		//java.lang.ClassCastException - 运行时异常，无法在编译期杜绝 - 有可能造成程序的崩溃
//		Integer value2 = (Integer)objs[1]; 
//		
//		System.out.println(value1);
//		System.out.println(value2);
		
	}
	/**
	 * 向对象数组中添加给定类型的元素 - 泛型
	 * @param e
	 */
	public void add(E e){
		//向obj数组中添加e元素即可
		//代码省略
	}

}
class Student{
	
}

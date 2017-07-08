package com.xuetang9.javabase.chapter9;
/**
 * 包装类
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月8日 下午3:18:55
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class BoxingDemo {
	public static void main(String[] args) {
//		Book book1 = new Book("老九君醉酒谈Java", "123-321", 98.8, 5);
//		Book book2 = new Book("老九君醉酒谈Java", "123-321", 98.8, 5);
//		System.out.println(book1 == book2);
		
		Integer num1 = new Integer(100);
		Integer num2 = new Integer(200);
		//两个对象之间的比较方法
		System.out.println(num1.compareTo(num2));
		
		
//		double num1 = 3.14;	
//		Double dNum1 = new Double("3.14");
//		Double dNum1_1 = Double.valueOf(num1);	//两种装箱的方法
//		Double dNum1_2 = 3.14;	//自动装箱
//		
//		num1 = dNum1;	//自动拆箱
//		num1 = dNum1_1.doubleValue();
//		
//		
//		System.out.println(num1 + "\t" + dNum1);

	}

}

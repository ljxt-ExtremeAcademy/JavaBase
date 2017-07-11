package com.xuetang9.javabase.chapter9;

import java.util.Scanner;

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
	public static boolean isDigit(char ch){
		return ch >= '0' && ch <= '9';
	}
	public static void main(String[] args) {
		//补充下字符包装类 - 自行完成下面的包装方法
//		Character.isLetter(ch)
//		Character.isLetterOrDigit(ch)
//		Character.isJavaIdentifierPart(ch)  //判断用来定义java变量的单词中，除首字符外，其他字符是否是合法字符
//		Character.isJavaIdentifierStart(ch) //判断java变量中，第一个字符是否是合法字符
//		Character.isUpperCase(ch)			//判断是否是大写字母
		
		//题目：判断用户输入的字符串是不是一个纯数字
		boolean isDigit = true;	//是否是纯数字
		System.out.println("请输入一个字符串，我来判断是否是一个纯数字：");
		String value = new Scanner(System.in).next();
		for (int i = 0; i < value.length(); i++) {
			//if(!isDigit(value.charAt(i))){
			if(!Character.isDigit(value.charAt(i))){
				isDigit = false;
				break;
			}
		}
		if(!isDigit){
			System.out.println("不是一个纯数字！");
		}else{
			System.out.println("是一个纯数字！");
		}
		
		
		
		
		
		
		
//		Book book1 = new Book("老九君醉酒谈Java", "123-321", 98.8, 5);
//		Book book2 = new Book("老九君醉酒谈Java", "123-321", 98.8, 5);
//		System.out.println(book1 == book2);
		
//		Integer num1 = new Integer(100);
//		Integer num2 = new Integer(200);
//		//两个对象之间的比较方法
//		System.out.println(num1.compareTo(num2));
		
		
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

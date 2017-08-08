package com.xuetang9.javabase.chapter12;

import java.util.Scanner;

/**
 * 输入不匹配异常示例
 * 用户输入的年龄只能是整型数字，使用异常处理机制捕获并处理异常情况
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月8日 上午11:12:15
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class InputMismatchExceptionDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入年龄（必须是整型数字）:");
		int age = -1;
		try {
			age = input.nextInt();
			age = age / 0;
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (Exception e) {
			//一般在开发的时候使用
			//e.printStackTrace();
			e.printStackTrace(System.err);
			//System.err.println(e.getMessage());
		} 
		
		System.out.println("输入的年龄是：" + age);
	}

}









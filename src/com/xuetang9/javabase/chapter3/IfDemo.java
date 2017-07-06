package com.xuetang9.javabase.chapter3;

import java.util.Scanner;

public class IfDemo {
	public static void main(String[] args) {
//		硬盘盘符一般采用A-Z大写字母表示
//		使用程序判断用户输入的字符是否是合法的硬盘盘符
		//1.输入硬盘的盘符
		//2.判断是否合法
		//3.打印结果
		int num1 = 4, num2 = 0;
		if(num1 > num2)
			//System.out.println("abc");
			System.out.println("bca");
			else
				System.out.println("");
		
		
		Scanner input = new Scanner(System.in);
		System.out.print("请输入硬盘盘符：");
		char ch = input.next().charAt(0);//取用户输入字符串的第一个字符
		if(ch >= 'A' && ch <= 'Z'){ // 等价写法 !(ch < 'A' || ch > 'Z')
			//'A' <= ch <= 'Z' -- 错误的写法！！！
			System.out.println("您输入的盘符是合法的盘符！");
		}else{
			System.err.println("输入了非法盘符！！！");
		}

		
	}
}

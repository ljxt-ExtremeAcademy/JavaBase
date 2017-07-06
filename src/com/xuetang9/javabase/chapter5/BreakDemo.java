package com.xuetang9.javabase.chapter5;

import java.util.Scanner;

/**
 * 演示break的基本用法
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月16日 上午10:05:26
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class BreakDemo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//统计玩家的个人贡献度，遇到负值，直接跳出循环
		int exp = 0;	//个人贡献度
		int sum = 0;	//个人总贡献度
		for(;;){//死循环
			System.out.print("请输入本次的贡献度：");
			exp = new Scanner(System.in).nextInt();//匿名的方式调用对象方法
			if(exp < 0){
				System.out.println("个人贡献度不能为负数，程序强制退出！");
				break;
			}
			sum += exp;
		}
		
		System.out.println("您输入的贡献度总数为：" + sum);
		
		
		
//		long count = 0;
//		long startTime = System.currentTimeMillis();//1970-1-1到现在的毫秒数
//		while(true){//死循环
//			if(count++ == Long.MAX_VALUE){
//				break;
//			}
//		}
//		long endTime = System.currentTimeMillis();//1970-1-1到现在的毫秒数
//		System.out.println("循环已结束" + count);
//		System.out.println("循环用时：" + (endTime - startTime) + "毫秒！");

	}

}

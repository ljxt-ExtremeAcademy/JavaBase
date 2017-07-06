package com.xuetang9.javabase.chapter5;

import java.util.Scanner;

public class MoneyTotal {

	public static void main(String[] args) {
		//循环输入5个玩家的消费，统计消费额低于500的玩家数量
		//如果消费大于等于500，则跳过；小于500则计数器+1
		Scanner input = new Scanner(System.in);
		
		//计算1-100之间的偶数和
		int sum = 0; 
		for (int i = 0; i <= 100; i++) {
			if(i % 2 != 0)
				continue;	//跳过奇数的情况
			sum += i;
		}
		for (int i = 1; i < 100; i += 2) {
			
		}
		
		
		
		//1.循环录入5个玩家的消费金额
		//2.录入后立刻判断是否小于500
		//3.累加小于500的总次数
//		int count = 0;						//次数的初值一般为0
//		double money = Double.MAX_VALUE;	//赋一个不可能的值，方便后面的判断
//		for (int i = 0; i < 5; i++) {
//			System.out.println("请输入第" + (i + 1) + "位玩家的消费金额：");
//			money = input.nextDouble();
//			
//			if(money >= 500)
//				continue;//跳过次数累加 - 跳过大于500的情况，直接到下次循环
//			count++;
////			if(money < 500){
////				count++;
////			}
//		}
//		System.out.println("消费总金额小于500的总数为：" + count);


	}

}

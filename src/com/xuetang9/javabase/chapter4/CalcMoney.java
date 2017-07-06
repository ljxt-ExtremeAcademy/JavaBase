package com.xuetang9.javabase.chapter4;
/**
 * 某宝双十一2015年的交易额为800亿，每年递增25%
	问：按此速度哪年交易额达到2000亿？
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月12日 上午11:02:51
 * @copyright 老九学堂
 * @remarks bug：臭虫
 *
 */
public class CalcMoney {
	public static void main(String[] args) {
		//1、设置断点 break point
		//2、开启调试/单步调试
		//3、观察变量的变化
		double item = 1;
		double sum = 0;
		while(item != 0){//死循环
	        sum += item;
	        item -= 0.1;
		    System.out.println(item);
		}
		System.out.println(sum);

		
		
		
		
		
		
		
		
		
//		//确定循环变量
//		int year = 2015;		//年份
//		double money = 800;		//交易额
//		while(money <= 2000){
//			year++;
//			money = money * (1 + 0.25);
//			//money *= 1.25;
//		}
//		String str = String.format("%d年，交易额达到2000亿(%.2f亿元)", year, money);
//		System.out.println(str);

	}

}

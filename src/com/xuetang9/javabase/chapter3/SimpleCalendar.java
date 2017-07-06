package com.xuetang9.javabase.chapter3;

import java.util.Scanner;

/**
 * 根据月份打印对应的天数
	如果是闰年，2月份天数为29天
	使用switch-case结构
   	闰年的条件：
	isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月9日 上午11:14:32
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class SimpleCalendar {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//1.定义变量：年、月、天数
		int year = -1, month = -1, dayOfMonth = -1; //初值给一个不可能的值，方便以后的判断
		System.out.print("年份：");
		year = input.nextInt();
		System.out.print("月份：");
		month = input.nextInt();
		//2.根据月份计算当月的天数，2月默认28天
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dayOfMonth = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dayOfMonth = 30;
			break;
		case 2:
			dayOfMonth = 28;
			break;
		default:
			System.out.println("只能输入1-12之间的整型数字！");
			System.exit(0);
		}
		
		//3.如果输入的年份是闰年，月份天数+1
		boolean isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
//		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
//			
//		}
		if(isLeapYear){
			dayOfMonth++;
		}
		System.out.println(year + "年" + month + "月有" + dayOfMonth + "天！");
	}

}






package com.xuetang9.javabase.chapter7;

import java.util.Scanner;

/**
 * 使用方法实现月历的打印
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月28日 上午11:38:40
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class PrintCalendarDemo {	
	/** 用户输入的年份 */
	public static int year = Integer.MIN_VALUE;
	/** 用户输入的月份 */
	public static int month = Integer.MIN_VALUE;
	/** 对应每个月份的天数 */
	private static int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) {
		PrintCalendar();
		//getSumDayOfYears();
	}

	/**
	 * 打印月历的核心方法
	 */
	public static void PrintCalendar() {
		//1.让用户输入年份和月份
		InputYearAndMonth();
		//2.计算1900-1-1 到 用户输入年份月份的总天数(year=2017, month=7 2017-7-1)
		//	2-1.计算各年的总天数
		//  2-2.计算各月的天数之和
		int sum = getSumDayOfYears();
		sum += getSumDayOfMonth();
		sum++;
		System.out.println(sum % 7);
		//3.打印年份和月份（英文）
		PrintMonthTitle();
		//4.打印月份的标题（星期一到星期日）
		//5.根据某月1日是星期几，打印月历的内容
		PrintCalendarContent(sum % 7);
	}
	
	/**
	 * 根据当月1号是周几打印月历的内容
	 * @param dayOfWeek 当月1号是星期几
	 */
	private static void PrintCalendarContent(int dayOfWeek){
		//注意：dayOfWeek取值范围是0-6   
		int sepCount = 0;	//\t的数量
		if(dayOfWeek == 0){
			sepCount = 6;
		}else {
			sepCount = dayOfWeek - 1;
		}
		for(int i = 0; i < sepCount; i++){
			System.out.print("\t");
		}
		for(int i = 0; i < dayOfMonth[month - 1]; i++){
			System.out.print(i + 1);
			if((dayOfWeek + i) % 7 == 0){
				//周日
				System.out.println();
			}else{
				System.out.print("\t");
			}
		}
	}
	
	private static void PrintMonthTitle(){
		String[] monthNames = {"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"};
		System.out.println("\t\t" + year + "\t" + monthNames[month - 1]);
		String[] weekdays = {"月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日", "日曜日"};
		for (int i = 0; i < weekdays.length; i++) {
			System.out.print(weekdays[i] + "\t");
		}
		System.out.println();
	}
	
	/**
	 * 获得1900-year年的总天数
	 * @return
	 */
	private static int getSumDayOfYears(){
		//需要判断用户是否已经输入了年份
		if(year == Integer.MIN_VALUE){
			System.out.println("年份错误！请重新输入年份和月份！");
			InputYearAndMonth();
		}
		int sum = 0;
		for(int i = 1900; i < year; i++){
			sum += 365;		//每一年累加365天
			if(isLeapYear(i)){
				sum++;		//闰年多+1天
			}
		}
		return sum;
	}
	
	/**
	 * 得到year年1月1号到year年month-1月最后一天的总天数
	 * @return
	 */
	private static int getSumDayOfMonth(){
		int sum = 0;
		for(int i = 0; i < month - 1; i++){
			sum += dayOfMonth[i];
		}
		//如果year年是闰年，并且month>=3
		if(isLeapYear(year) && month >= 3){
			sum++;
		}
		return sum;
	}
	
	/**
	 * 用来判断传入的year变量是不是闰年
	 * @param year 要判断的年份
	 * @return 是闰年，返回true
	 */
	private static boolean isLeapYear(int year){
		return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
	}
	
	/**
	 * 接收用户输入的年份和月份
	 */
	private static void InputYearAndMonth(){
		Scanner input = new Scanner(System.in);
		System.out.print("请输入年份：");
		year = input.nextInt();
		System.out.print("请输入月份：");
		month = input.nextInt();
		input.close();
		input = null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

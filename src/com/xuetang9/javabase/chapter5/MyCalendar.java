package com.xuetang9.javabase.chapter5;
/**
 * 打印1997年7月的月历
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月14日 上午11:47:26
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class MyCalendar {
	/*
	 * 打印月历
		请使用循环打印1997年7月的月历
		已知：1997年7月1日(星期二) ,香港回归举国同庆
	 */
	public static void main(String[] args) {
		System.out.println("星期一\t星期二\t星期三\t星期四\t星期五\t星期六\t星期日");
		System.out.print("\t");
		//System.out.print("1\t2\t3\t4\t5\t6\n");
		
		int dayOfMonth = 31;	//1997年的7月一共有31天
		for (int i = 1; i <= dayOfMonth; i++) {
			System.out.print(i);
			//判断何时\t，何时\n(周日那天)
			//已知：1号是星期二
			if((i + 1) % 7 == 0){
				System.out.print("\n");
			}else{
				System.out.print("\t");
			}
		}

	}

}







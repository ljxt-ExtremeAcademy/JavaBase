package com.xuetang9.javabase.chapter4;

import java.util.Scanner;

/**
 * 计算输入的整型数字中每位数字之和
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月12日 上午10:30:11
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class CalcSum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入一个数字，我来计算各位之和：");
		//1.得到要计算的整型数字
		int num = input.nextInt();//要进行拆分计算的整型数字
		int tempNun = num;	//临时变量
		//2.声明相关变量
		int i = 0;		//循环变量
		int sum = 0;	//累加和
		//3.循环操作计算累加和
		while(tempNun > 0){
			sum += tempNun % 10;//每次循环累加个位
			tempNun /= 10;		//卸磨杀驴：去掉个位数字
		}	
		//4.打印计算结果
		System.out.println(num + "的各位数字之和为：" + sum);

	}

}

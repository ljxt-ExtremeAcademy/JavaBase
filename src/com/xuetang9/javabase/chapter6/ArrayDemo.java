package com.xuetang9.javabase.chapter6;

import java.util.Scanner;

public class ArrayDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//要求用户动态录入5个学生的成绩，求平均成绩
		final int N = 10;
		double[] scores = new double[N];  //sizeof(scores) / sizeof(double)
		double sum = 0, avg;	//总成绩和平均成绩
		for(int i = 0; i < scores.length; i++){
			System.out.print("请输入第" + (i+1) + "位同学的成绩：");
			//将用户输入的double类型数字，赋值给数组中的第i个元素
			scores[i] = input.nextDouble();//重点语句！  
		}
		//计算总成绩     问卷在老九学堂微信公众号 
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];	//经典代码
		}
		
		System.out.printf("%d位同学的平均成绩为：%.2f", scores.length, sum / scores.length);
		
		
		
		
		
		
		
		
		//		int[] nums = null;	//声明了一个整型数组 nums
//		nums[0] = 9;		//为数组的0号元素赋值为9
		//java.lang.NullPointerException
		//异常- 空指针异常 - 没有空间
		
		//数组名就是新分配内存空间的首地址
//		int[] nums = new int[5];	//在堆内存中分配了5个int类型大小的空间
//		System.out.println(nums);
//		
//		int num;	//处理基本类型时：在栈内存中直接分配了空间（不需要手动分配空间）
//		num = 9;
//		
//		Scanner input = new Scanner(System.in); //new:在堆内存中分配了空间
//		input.next();   
	}

}

package com.xuetang9.javabase.chapter6;

import java.util.Scanner;

/**
 * 查找输入的数字在数组中的下标，没有找到则下标为-1
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月19日 上午11:32:25
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class SearchDemo {

	public static void main(String[] args) {
		String [] values = {"abc", "def", "cvb"};
		for(String value : values){
			System.out.println(value);
		}
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
		
		
		
		
		
		//随机生成一个数组，求里面的最大值和最小值
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = ((int)(Math.random() * 10000)) % 1001; //0-1000的随机数
		}
		System.out.println("数组元素");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ", ");
		}
		System.out.println();
		
		//让用户输入要查找的数字
		//循环查找  遍历数组，查找对应的元素，如果找到了，打印下标，没找到，打印-1
		System.out.print("请输入要查找的元素：");
		int searchNum = new Scanner(System.in).nextInt();
		int searchIndex = -1;//套路：一般要找的下标，初值为-1
		//循环查找
//		for (int i = 0; i < nums.length; i++) {
//			if(searchNum == nums[i]){
//				//System.out.println("找到了，下标为：" + i);.
//				//找到后，记录下要查找元素的下标
//				searchIndex = i;
//				break;
//			}
//		}
		for (int i : nums) {
			if(searchNum == nums[i]){
				//System.out.println("找到了，下标为：" + i);.
				//找到后，记录下要查找元素的下标
				searchIndex = i;
				break;
			}
		}
		
		
		//在循环后进行判断
		if(searchIndex == -1){
			System.out.println("很遗憾，没有找到这个元素！");
		}else{
			System.out.println("要查找的元素下标为：" + searchIndex);
		}
		
		
		
		
		
		
		
		
		

	}

}

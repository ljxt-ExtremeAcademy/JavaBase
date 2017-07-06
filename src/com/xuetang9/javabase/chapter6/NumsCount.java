package com.xuetang9.javabase.chapter6;
/**
 * 定义一个整型数组，赋值后求出奇数个数和偶数个数
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月19日 上午11:29:43
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class NumsCount {
	public static void main(String[] args) {
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
		
		int count1 = 0, count2 = 0;	//奇数和偶数的个数
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] % 2 == 0){//偶数
				count2++;
			}else{
				count1++;
			}
		}

	}

}

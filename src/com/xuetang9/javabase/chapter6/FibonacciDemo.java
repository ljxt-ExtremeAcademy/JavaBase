package com.xuetang9.javabase.chapter6;
/**
 * 斐波那契数列
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月19日 上午11:10:11
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class FibonacciDemo {
	public static void main(String[] args) {
		//0，1，1，2，3，5，8，13，21 ，34，55 ， 89 ， 144 
		//规律：前两个元素值固定，
		int[] nums = new int[20];
		int sum = 0;
		double avg;
		nums[0] = 0;
		nums[1] = 1;
		for(int i = 2; i < nums.length; i++){//第三个开始，是前两个元素之和
			nums[i] = nums[i - 1] + nums[i - 2];
		}
		
		System.out.println("打印结果");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ", ");
			sum += nums[i];
		}
		System.out.println();//打印换行
		System.out.println(sum / 1.0 / nums.length);
	}

}

package com.xuetang9.javabase.chapter7;

public class ParamDemo {

	public static void main(String[] args) {
		
		paramTest("参数测试");
		
		//System.out.printf(format, args)

	}
	
	public static void paramTest(String str, int... nums){
		System.out.println("第一个参数：" + str);
		
		System.out.println("参数数组的长度：" + nums.length);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}

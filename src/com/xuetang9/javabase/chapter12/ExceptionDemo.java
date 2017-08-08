package com.xuetang9.javabase.chapter12;

public class ExceptionDemo {
	/**
	 * 计算两个数字相除的商
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int division(int num1, int num2){
		System.out.println("计算除法前");
		int result = Integer.MAX_VALUE;
		try {
			result = num1 / num2;
		} catch (Exception e) {
			System.err.println("异常信息：" + e.getMessage());
			//日志记录
		}
		System.out.println("计算除法后");
		return result;
	}
	
	public static void main(String[] args) {
//		int result = division(5, 0);
//		System.out.println("result = " + result);
//		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

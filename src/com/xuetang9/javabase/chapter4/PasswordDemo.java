package com.xuetang9.javabase.chapter4;

import java.util.Scanner;

/**
 * 使用循环实现三次密码输入错误退出系统
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月12日 上午10:43:02
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class PasswordDemo {
	public static void main(String[] args) {
		final String PASSWORD = "123456";//常量
		//PASSWORD = "abc";
		Scanner input = new Scanner(System.in);
		String password = null;	//密码
		//System.out.println(password.length());
		String userName = "";   //NULL  nullptr
		//1.写出循环结构
		int i = 0;
		while(i < 3){
			System.out.print("请输入密码：");
			password = input.next();
			//Java中的字符串不允许这样判断： if(password == "123456"){
			//if(password.equals("123456")){//判断字符串相等的固定方式！！
			i++;
			if(!PASSWORD.equals(password)){
				System.out.println("密码输入错误，请重新输入！（剩余" + (3 - i) + "次）");
				if(i == 3){
					System.out.println("密码输入错误已达三次，强制退出系统！");
					System.exit(0);
				}
			}else{//输入密码相等的情况
				//想办法退出这个循环结构
				//i = 9;//如何改进？
				i = Integer.MAX_VALUE;//让i的值为整型里的最大值！
			}
		}
		System.out.println("密码正确，成功登陆本系统！");
		//2.考虑循环的次数
		//3.输入并验证用户名和密码
		

	}

}

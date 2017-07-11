package com.xuetang9.javabase.chapter9.userdemo;

import java.util.Scanner;
/**
 * 1、用户名最多25个字符长度、不能包含空格、单双引号、问号等特殊符号
	2、密码6-18位，只能包含字母、数字、特殊符号（下划线、@、#、$、!）
	纯数字、纯字母时，密码强度都是弱 （★★☆☆☆☆）
	数字+密码、数字+符号、数字+字母，强度为中（★★★★☆☆）
	同时存在三种字符，强度为强（★★★★★★）
	3、用户输入正确的email
	必须包含@符号，且只能包含一个
	@和.  符号不能在开头，也不能在结尾
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月11日 上午11:31:39
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class UserMain {
	public static void main(String[] args) {
		//Java直播课的项目链接：
		//https://github.com/ljxt-ExtremeAcademy/JavaBase.git
		
		Scanner input = new Scanner(System.in);
		//以下代码实现用户注册
//		System.out.println("请输入用户名：");
//		String userName = input.next();
		System.out.println("请输入密码：");
		String password = input.next();
		System.out.println(StringUtil.validatePassword(password));
		
		
//		String password = input.next();
//		System.out.println("请输入电子邮箱地址：");
//		String email = input.next();
		
		
	}
}

package com.xuetang9.javabase.chapter9;

public class Hero {
	
	
	String name = "默认值";
	
	public  void test1(){
		String name = "盖伦"; //null	//局部变量
		System.out.println(name);
	}
	
	
	public static void main(String[] args) {
		new Hero().test1();
	}
}

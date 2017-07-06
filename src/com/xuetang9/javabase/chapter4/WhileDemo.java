package com.xuetang9.javabase.chapter4;

public class WhileDemo {

	public static void main(String[] args) {
		//建议：循环变量尽量只用来控制循环的次数！！！
		int i = 0;		//循环变量的初值   -1   -1234    char 
		while(i < 10){	//循环变量的判断 
			System.out.println(i + 1);
			//i++;		//循环变量的更新
		}
//		
//		char ch = 'A';
//		while(ch <= 'Z'){
//			
//			ch++;
//		}

	}

}

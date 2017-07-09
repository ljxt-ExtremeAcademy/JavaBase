package com.xuetang9.javabase.chapter9;
/**
 * 字符串示例
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月8日 下午3:57:36
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class StringDemo {
	public static void main(String[] args) {
		String 刘强东老婆 = "龚小京";	//龚小京这个字符串就被存放在了字符串池中
		刘强东老婆 = "奶茶妹妹";			//奶茶妹妹 也是在字符串池中的！
		//new String("奶茶妹妹@小强东")
		刘强东老婆 = 刘强东老婆.concat("@小强东");	//注意：刘强东的老婆已经不是原来在常量池中的奶茶妹妹了！
		//思考：奶茶妹妹@小强东 是否在常量池中？？？？
		System.out.println(刘强东老婆);
		
		String 刘强东前妻 = "龚小京";
		
		
//		String value = "Hello World";
//		String value1 = value;
//		value += "Good";	//相当于调用了value.concat()方法，会直接返回一个新的字符串对象空间
//		String value2 = "Hello WorldGood";//将字符串池中的地址赋给value2
//		
//		System.out.println(value);
//		System.out.println(value1);
		
//		String value = "中国人民解放军";
//		//value += "老牛鼻子了！";
//		value = value.concat("老牛鼻子了！");
//		
//		
//		System.out.println(value);
		
	}
}

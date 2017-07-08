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
		String value = "Hello World";
		value += "Good";	//相当于调用了value.concat()方法，会直接返回一个新的字符串对象空间
		String value2 = "Hello WorldGood";//将字符串池中的地址赋给value2
		
		System.out.println(value.equals(value2));
		
//		String value = "中国人民解放军";
//		//value += "老牛鼻子了！";
//		value = value.concat("老牛鼻子了！");
//		
//		
//		System.out.println(value);
		
	}
}

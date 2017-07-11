package com.xuetang9.javabase.chapter9;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;


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
	
	/**
	 * 判断传入的字符串是否是一个正确格式的小数
	 * 字符串中只能有一个小数点，小数点不能在第一位，也不能在最后一位
	 * @param str
	 * @return
	 */
	public static boolean isDecimal(String str){
		boolean isDecimal = true;
		for (int i = 0; i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))){
				if(str.charAt(i) == '.'){
					if(i == 0 || i == str.length() - 1){//如果小数点在第一位或最后一位，仍然是非法的，返回false
						isDecimal = false;
						break;
					}
				}else{//如果当前字符不是数字并且也不是小数点，那么证明是非法字符，直接返回false
					isDecimal = false;
					break;
				}
			}
		}
		//判断字符串中只能有一个小数点
		//1.存在小数点	2.从前搜索的下标和从后往前搜索的下标刚好相等
		if(!(str.contains(".") && str.indexOf(".") == str.lastIndexOf("."))){
			return false;
		}
		//1.判断字符串中的每个元素必须是数字或小数点
		//2.如果有小数点，那么小数点不能在第一位和最后一位，并且只能有一个小数点
//		if(str.indexOf('.') == 0 || str.indexOf(".") == str.length() - 1){
//			
//		}
		
		return isDecimal;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner input = new Scanner(System.in);
		//indexOf方法
		String password = "ab3456abc";
		//System.out.println(password.indexOf("aaa"));
		//问题：判断字符串中只能有一个小数点，小数点不能在第一位，也不能在最后一位
		
		//substring [beginIndex, endIndex)   [1, 3)
		System.out.println(password.substring(1, 3));
		System.out.println(password.substring(3));
		
		
		
		//trim方法:去掉字符串左右两侧的空格
		//建议：在用户输入用户名后使用
//		System.out.println("请输入用户名：");
//		String uName = input.nextLine().trim();
//		System.out.println("--" + uName + "--");

//		System.out.println("abc".equals("abc"));
//		System.out.println("abcf".compareTo("abcd"));
		
//		System.out.println("abc".startsWith("b"));
//		System.out.println("abcdefg".endsWith("fg"));
//		System.out.println("abcdefg".contains("de"));
		
		
		//演示常用的几种String对象的构建方式
//		String str1 = "你好，世界！";
//		String str2 = new String();	//使用默认构造  String str2 = "";
//		String str3 = new String(str1);
//		
//		char[] chArray = {'a', 'b', 'c'};	//C中：字符数组和字符串的区别就在于最后一个元素是否是\0
//		//将字符数组转换成String对象
//		String str4 = new String(chArray);
//		chArray = str4.toCharArray();
//		
//		//字节数组与字符串的转换  byte数据类型：-128 到 127之间
//		byte[] byteArray = {104, 101, 108, 108, 111};
//		String str5 = new String(byteArray);
//		System.out.println(str5);
//		
//		//字符串转码：
//		String str6 = new String(str1.getBytes(), "UTF-8");
//		System.out.println(str6);
		
		
//		String 刘强东老婆 = "龚小京";	//龚小京这个字符串就被存放在了字符串池中
//		刘强东老婆 = "奶茶妹妹";			//奶茶妹妹 也是在字符串池中的！
//		//new String("奶茶妹妹@小强东")
//		刘强东老婆 = 刘强东老婆.concat("@小强东");	//注意：刘强东的老婆已经不是原来在常量池中的奶茶妹妹了！
//		//思考：奶茶妹妹@小强东 是否在常量池中？？？？
//		System.out.println(刘强东老婆);
//		
//		String 刘强东前妻 = "龚小京";
//		
		
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

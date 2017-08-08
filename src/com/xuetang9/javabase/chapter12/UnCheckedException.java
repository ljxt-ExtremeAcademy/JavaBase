package com.xuetang9.javabase.chapter12;
/**
 * 免检异常 - RunTimeException/Error
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月8日 上午10:34:49
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class UnCheckedException {

	public static void main(String[] args) {
//		String value = null;
//		System.out.println(value.toString());
//		
//		String strValue = "123a";
//		//字符串转换为数字
//		int value1 = Integer.parseInt(strValue);
//		System.out.println(value1);
//		
		
		Person p = new Person();
		Student stu = (Student)p;
		
	}

}
class Person{
	
}
class Student extends Person{
	
}







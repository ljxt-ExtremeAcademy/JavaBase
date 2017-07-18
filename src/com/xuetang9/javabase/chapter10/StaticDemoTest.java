package com.xuetang9.javabase.chapter10;
/**
 * 使用单例模式
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月18日 下午12:08:22
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class StaticDemoTest {
	public static void main(String[] args) {
		StaticDemo staticDemo1 = StaticDemo.getInstance();
		System.out.println(staticDemo1.normal_number);
		
		
		StaticDemo staticDemo2 = StaticDemo.getInstance();
		staticDemo2.normal_number = 1024;
		
		
		
		StaticDemo staticDemo3 = StaticDemo.getInstance();
		System.out.println(staticDemo3.normal_number);
		
		System.out.println(staticDemo1 == staticDemo2);

	}

}

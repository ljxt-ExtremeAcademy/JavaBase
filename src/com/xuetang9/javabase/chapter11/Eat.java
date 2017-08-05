package com.xuetang9.javabase.chapter11;
/**
 * 吃接口
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月5日 下午3:04:48
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public interface Eat {
	String name = "接口中定义的数据域";
	
	default public void eating(){
		System.out.println("Eat接口的默认实现");
	}
}
interface Eat1{
	default public void eating(){
		System.out.println("Eat1接口的默认实现");
	}
}

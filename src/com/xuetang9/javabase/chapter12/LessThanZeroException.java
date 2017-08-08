package com.xuetang9.javabase.chapter12;
/**
 * 自定义异常 - 小于零时触发
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月8日 下午12:00:11
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class LessThanZeroException extends Exception{
	//重写父类的两个构造方法即可
	
	private int value;
	
	
	public LessThanZeroException(){
		super("数字不能小于零！");
	}
	
	public LessThanZeroException(int value){
		super("输入的数字为：" + value + "，不能小于零！");
	}

}

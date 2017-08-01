package com.xuetang9.javabase.chapter11;
/**
 * 单例模式示例 - 套路
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月1日 上午10:23:06
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class SingleModel {
	/** 用来保存唯一的本类的实例 */
	private static SingleModel me = null;
	public int count = 0;
	
	private SingleModel(){
		count++;
	}
	/**
	 * 获得本类唯一的一个实例 -- 单例模式的核心方法
	 * @return
	 */
	public static SingleModel getInstance(){
		if(null == me) 
			me = new SingleModel();
		return me;
	}
}





package com.xuetang9.javabase.chapter13.decorator;
/**
 * 抽象的组件类，用来定义组件做具有的基本方法
 * InputStream/OutputStream/Reader/Writer
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月15日 上午10:40:36
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public abstract class Component {
	/**
	 * 假设组件中定义了一个通用的read读取方法，要求子类进行实现
	 */
	public abstract void read();
}

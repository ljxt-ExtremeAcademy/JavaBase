package com.xuetang9.javabase.chapter13.decorator;
/**
 * 真正“干活的”组件类
 * 实现了基本的read方法
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月15日 上午10:42:31
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class TrueComponent extends Component{

	@Override
	public void read() {
		System.out.println("TrueComponent实现的read方法");
	}

}

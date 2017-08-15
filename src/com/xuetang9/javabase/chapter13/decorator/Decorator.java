package com.xuetang9.javabase.chapter13.decorator;
/**
 * 装饰器父类，用来为基本的组件实现功能的扩展
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月15日 上午10:43:36
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class Decorator extends Component{
	private Component component;
	
	public Decorator(Component component) {
		this.component = component;
	}

	@Override
	public void read() {
		//注意：观察谁真正实现了read功能
		//将请求转发给component对象，转发后，就可以执行一些扩展操作了
		component.read();
	}
	
}

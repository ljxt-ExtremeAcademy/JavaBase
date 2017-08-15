package com.xuetang9.javabase.chapter13.decorator;
/**
 * 装饰器的实现类A
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月15日 上午10:47:11
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class ComponentImplA extends Decorator{
	
	public ComponentImplA(Component component) {
		super(component);
	}
	
	@Override
	public void read() {
		//注意：在原始的read方法前后，分别调用了自定义的方法
		//即实现了对原read方法的功能扩展！
		this.extendsReadA();
		super.read();	//原始的read方法
		this.extendsReadB();
	}
	
	private void extendsReadA(){
		System.out.println("ComponentImplA实现的扩展方法：extendsReadA");
	}
	
	private void extendsReadB(){
		System.out.println("ComponentImplA实现的扩展方法：extendsReadB");
	}
}

package com.xuetang9.javabase.chapter10.chunwan;

/**
 * 演员父类
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月18日 上午11:20:39
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public abstract class Actor {//当一个类是抽象类的时候，就不能使用new来实例化了！--抽象类是天生的父类！
	private String name;
	
	public Actor(){
		
	}
	
	public Actor(String name){
		setName(name);
	}
	
	/**
	 * 演员的表演方法
	 */
	public void performs(){
		System.out.println("演员" + name + "正在表演精彩的节目");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

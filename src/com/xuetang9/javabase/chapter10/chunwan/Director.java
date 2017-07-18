package com.xuetang9.javabase.chapter10.chunwan;
/**
 * 导演类 -- 相当于我们项目中的核心业务类
 * 主要功能：让演员就位，开始表演
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月18日 上午11:26:09
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class Director {
	/**
	 * 导演的“Action”方法，让演员就位开始表演节目
	 * @param actor
	 */
	public void action(Actor actor){
		actor.performs();
	}
}

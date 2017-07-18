package com.xuetang9.javabase.chapter10.chunwan;
/**
 * 歌唱演员
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月18日 上午11:22:57
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class Singer extends Actor {
	public Singer() {
		super();
	}

	public Singer(String name) {
		super(name);
	}
	
	@Override
	public void performs() {
		System.out.println("歌唱演员" + getName() + "正在表演歌唱节目《在这桃花盛开的地方》");
	}
	
}

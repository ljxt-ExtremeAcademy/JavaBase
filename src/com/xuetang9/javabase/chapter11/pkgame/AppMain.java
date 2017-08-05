package com.xuetang9.javabase.chapter11.pkgame;
/**
 * 用来模拟游戏核心业务逻辑层的代码
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月5日 下午2:54:54
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class AppMain {

	public static void main(String[] args) {
		Hero hero1 = new Warrior(1, "曹操", 0, 0);
		Castle castle = new Castle("温莎古堡", 120, 120, 750);
		
		hero1.PK(castle);
		castle.attack(hero1);

	}

}

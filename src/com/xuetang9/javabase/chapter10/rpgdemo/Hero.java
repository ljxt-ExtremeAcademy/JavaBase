package com.xuetang9.javabase.chapter10.rpgdemo;
/**
 * 英雄类 - 父类
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月15日 下午3:22:49
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class Hero {
	private String nickName;
	private int level;
	private int maxLife;
	private int currLife;

	public Hero() {
		System.out.println("父类默认构造！");
	}
	
	public Hero(String nickName, int level, int maxLife, int currLife) {
		super();
		this.nickName = nickName;
		this.level = level;
		this.maxLife = maxLife;
		this.currLife = currLife;
	}
	
	public void move(){
		System.out.println("Hero类的move方法");
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMaxLife() {
		return maxLife;
	}
	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}
	public int getCurrLife() {
		return currLife;
	}
	public void setCurrLife(int currLife) {
		this.currLife = currLife;
	}
	
	
}

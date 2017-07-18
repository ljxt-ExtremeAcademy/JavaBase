package com.xuetang9.javabase.chapter10.rpgdemo;
/**
 * 法师类
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月18日 上午10:27:36
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class Archmage extends Hero{
	/** 战士类的静态属性，每实例化一个新的展示对象，ID++ -- *可以用来计算某个类被实例化的次数 */
	public static int ID = 1;
	
	private int magicAttack;
	
	public Archmage(){
		setNickName("默认法师" + ID);
		setLevel(1);
		setMaxLife(100);
		setCurrLife(100);
		setMagicAttack(99);
		ID++;
	}
	
	public Archmage(String nickName){
		this();//调用本类的默认构造
		setNickName(nickName);
	}
	
	/**
	 * 重写toString方法，封装打印角色信息的逻辑
	 */
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(getLevel());
		str.append("\t");
		str.append(getNickName());
		str.append("\t");
		str.append(getMaxLife());
		str.append("\t\t");
		str.append(getCurrLife());
		str.append("\t");
		str.append(getMagicAttack());
		return str.toString();
	}
	
	public void biubiubiu(){
		System.out.println("大法师" + getNickName() + "正在搓火球！");
	}

	public int getMagicAttack() {
		return magicAttack;
	}

	public void setMagicAttack(int magicAttack) {
		this.magicAttack = magicAttack;
	}
	
	
}

package com.xuetang9.javabase.chapter10.rpgdemo;
/**
 * 战士类 - 继承了 Hero类
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月15日 下午3:25:16
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class Warrior extends Hero{
	/** 战士的特有属性：物理攻击力 */
	private int pysicalAttach;
	
	public Warrior(){
		super();	//子类构造中，默认就会调用父类构造
		System.out.println("子类默认构造");
	}
	
	public Warrior(String nickName, int pysicalAttach){
		setNickName(nickName);
		setPysicalAttach(pysicalAttach);
	}
	
	@Override //注解：重写
	public void move() {
		System.out.println("战士的移动：交通基本靠走！");
	}
	
	/**
	 * 重写Object类的equals方法，以便比较两个对象是否相等
	 */
	@Override
	public boolean equals(Object obj) {
		//如果传入的obj对是Warrior类的实例
		if(!(obj instanceof Warrior)){
			return false;
		}
		Warrior newWarrior = (Warrior)obj;
		//比较两个属性
		if(getNickName().equals(newWarrior.getNickName()) && getPysicalAttack() == newWarrior.getPysicalAttack()){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		return getNickName() + "\t" + getLevel() + "\t" + getPysicalAttack();
	}

//	public void movee(){
//		System.out.println(getNickName() + ":移动基本靠腿！");
//	}

	public int getPysicalAttack() {
		return pysicalAttach;
	}

	public void setPysicalAttach(int pysicalAttach) {
		this.pysicalAttach = pysicalAttach;
	}
	
	
}

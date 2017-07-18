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
	/** 战士类的静态属性，每实例化一个新的展示对象，ID++ */
	public static int ID = 1;
	
	/** 战士的特有属性：物理攻击力 */
	private int pysicalAttach;
	
	/**
	 * 子类的构造
	 */
	public Warrior(){
		super();	//子类构造中，默认就会调用父类构造
		//System.out.println("子类默认构造");
		setNickName("默认战士" + ID);
		setLevel(1);
		setMaxLife(100);
		setCurrLife(100);
		setPysicalAttach(99);
		ID++;
	}
	
	public Warrior(String nickName, int pysicalAttach){
		this();
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
		StringBuffer str = new StringBuffer();
		str.append(getLevel());
		str.append("\t");
		str.append(getNickName());
		str.append("\t");
		str.append(getMaxLife());
		str.append("\t\t");
		str.append(getCurrLife());
		str.append("\t");
		str.append(getPysicalAttack());
		return str.toString();
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

package com.xuetang9.javabase.chapter11.modeldemo;
/**
 * 远程攻击英雄
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月5日 下午2:05:59
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public abstract class LongRangeHero extends Hero{
	private int attackRange;	//攻击距离
	
	public LongRangeHero(){
		super();
	}
	
	public LongRangeHero(long id, String name, int attackRange, int x, int y){
		super(id, name);
		setAttackRange(attackRange);
		setX(x);
		setY(y);
	}

	public int getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}
	
	
}

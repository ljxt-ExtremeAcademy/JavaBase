package com.xuetang9.javabase.chapter11.modeldemo;
/**
 * 法师类 - 继承自远程攻击英雄
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月10日 下午5:28:22
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class Magical extends LongRangeHero{
	public Magical() {
		super();
	}
	
	public Magical(long id, String name, int attackRange, int x, int y){
		super(id, name, attackRange, x, y);
	}
	
	@Override
	public boolean canFightByDistance(Hero hero) {
		double distance = getDistance(this.getX(), this.getY(), hero.getX(), hero.getY());
		if(Math.abs(distance) <= getAttackRange()){//如果在攻击范围内
			return true;
		}
		System.out.println("目标距离过远，无法攻击！");
		return false;
	}

	@Override
	public void fight(Hero hero) {
		// 法师的攻击距离较远，每次的攻击设置低些：5-10
		setAttack((int)Math.round(Math.random() * 5) + 5);
		hero.setHp(hero.getHp() - getAttack());
		System.out.println(getName() + "成功实施了一次远程攻击！");
	}

}

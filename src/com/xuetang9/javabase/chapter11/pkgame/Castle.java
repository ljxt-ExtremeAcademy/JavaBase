package com.xuetang9.javabase.chapter11.pkgame;
/**
 * 城堡类 - 城堡不是英雄！
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月5日 下午2:45:07
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class Castle implements Assailable{
	private String name;
	private int x;
	private int y;
	private int maxHp;
	private int hp;
	private int attackRange;
	
	public Castle(String name, int x, int y, int attackRange){
		setName(name);
		setX(x);
		setY(y);
		setAttackRange(attackRange);
		setMaxHp(100);
		setHp(100);
	}
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttackRange() {
		return attackRange;
	}
	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}
	
	/**
	 * 计算两个点之间的距离
	 * 在更加接近实际的应用中，我们可以把计算距离的方法定义在工具类中，方便使用
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	protected double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
	/**
	 * 城堡的攻击方法（故意使用其他名称，以区别于英雄类）
	 * @param assa
	 */
	public void attack(Assailable assa){
		if(canFightByDistance(assa) && getHp() > 0 && assa.getHp() > 0){
			fight(assa);
		}else{
			System.out.println("攻击失败！");
		}
		
	}
	
	@Override
	public boolean canFightByDistance(Assailable assa) {
		//1.计算与另一个可攻击对象之间的距离
		//2.如果攻击距离合法，就进行攻击
		double distance = getDistance(getX(), getY(), assa.getX(), assa.getY());
		//假设城堡的攻击距离默认为500
		//城堡的攻击速度暂未实现
		return distance <= 500;
	}
	@Override
	public void fight(Assailable assa) {
		//假设城堡的攻击力固定
		int attack = 15;
		assa.setHp(assa.getHp() - attack);
		System.out.println(getName() + "攻击了" + assa.getName() + "!");
	}
}

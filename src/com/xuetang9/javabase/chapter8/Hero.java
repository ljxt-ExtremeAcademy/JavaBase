package com.xuetang9.javabase.chapter8;

/**
 * 游戏中的英雄类
 * 
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月4日 上午10:32:55
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class Hero {
	/**
	 * 玩家的名称创建后不能更改
		级别在1-999之间
		玩家每级升级所需经验公式：
		((等级-1)^3 + 60) / 5 * ((等级-1) * 2 + 60)
	 */
	private long id;
	private String nickName;
	private int level;
	private long currExp;	//当前的经验值
	private long exp;		//当前级别升级所需的经验值 - 固定值玩家每级升级所需经验公式：((等级-1)^3 + 60) / 5 * ((等级-1) * 2 + 60)
	
	//老师说明下另一个类中怎样访问其他类的pravite的变量或者方法
	//1.在另一个类中，是无法访问本类中的私有属性或方法的
	//2.在内部类可以直接访问
	//3.可以通过定义方法的形式，让外部类调用，以获得方法的返回值
	public Hero() {
		super();
	}
	
	class Weapon{
		public void fight(){
			System.out.println(id);
		}
	}
	
	
	public Hero(String nickName){
		this.nickName = nickName;
	}

	public Hero(long id, String nickName, int level, long exp) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.level = level;
		this.exp = exp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if(id <= 0) id = 1;
		else
			this.id = id;
	}

	public String getNickName() {
		return nickName;
	}


	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if(level <1 || level > 999){
			this.level = 1;//如果級別超限，就重新從1級開始
			//如果大于999，可以设置英雄角色转生轮数+1 -- 中国特色
		}else{
			this.level = level;
		}
		
	}

	public long getCurrExp() {
		return currExp;
	}

	public void setCurrExp(long currExp) {
		this.currExp = currExp;
	}

	public long getExp() {
//		玩家每级升级所需经验公式：
//		((等级-1)^3 + 60) / 5 * ((等级-1) * 2 + 60)
		exp = ((long)Math.pow(level - 1, 3) + 60) / 5 * ((level - 1) * 2 + 60);
		return exp;
	}

	//因为玩家每个级别升级所需的经验值是固定公式计算的，所以不需要用户手动调用
//	public void setExp(long exp) {
//		this.exp = exp;
//	}

}

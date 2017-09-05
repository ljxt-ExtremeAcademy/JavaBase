package com.xuetang9.javabase.chapter14;
/**
 * 仅用来演示关键字synchronized的作用：在多线程的程序中实现同步
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年9月1日 下午3:18:01
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class SynDemo {
	
	public static void main(String[] args) throws InterruptedException {
		Boss boss = new Boss(100000);
		//1w个人去围殴boss
		AttackThread[] threads = new AttackThread[10000];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new AttackThread(boss);
			threads[i].start();
		}		
		Thread.sleep(3000);//等待所有的线程运行完毕后再打印boss的hp
		System.out.println("10万人每人攻击10次后Boss的HP：" + boss.hp);
		
	}

}
/**
 * 游戏里的boss
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年9月1日 下午3:35:37
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
class Boss{
	public int hp;	
	public Boss(int hp){
		this.hp = hp;
	}	
	/**
	 * boss每次被攻击时，掉1点血
	 */
	public synchronized void hited(){//不加synchronized关键字时，最终结果有可能会有误差
		this.hp -= 1;
	}
}
/**
 * 用来模拟攻击boss的线程
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年9月1日 下午3:19:01
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
class AttackThread extends Thread{
	private Boss boss;
	public AttackThread(Boss boss) {
		this.boss = boss;
	}
	@Override
	public void run() {
		//天马流星拳.....连续攻击10下
		for(int i = 0; i < 10; i++)
			boss.hited();
	}
}

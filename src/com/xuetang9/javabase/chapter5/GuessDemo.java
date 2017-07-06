package com.xuetang9.javabase.chapter5;

import java.util.Scanner;

/**
 * 猜数字游戏
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月16日 上午10:27:16
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class GuessDemo {
	public static void main(String[] args) {
		//用户要猜的数字
		//用户猜的次数
		final int price = (((int)(Math.random() * 1000)) % 9 + 1) * 1000;	//常量 1000-9000
		//System.out.println(price);
		int guessPrice = -1;	//用户猜测的单价
		int count = 0;			//用户猜的总次数
		String prizeName = null;//奖品的名称
		for (int i = 0; i < 5; i++) {
			System.out.println("请输入神秘商品的单价：(" + ++count + "次)");
			guessPrice = new Scanner(System.in).nextInt();
			if(guessPrice == price){//在猜测正确的情况下，再判断猜测的次数
				if(count == 1){
					System.out.println("牛逼了，一次就猜对了");
					prizeName = "iPhone8S Plus Plus 土豪金";
					//System.out.println("奖品：iPhone8S Plus Plus 土豪金");
				}else if(count >= 2 && count <= 3){
					//System.out.println("奖品：华为荣耀手环Zero");
					prizeName = "华为荣耀手环Zero";
				}else{
					//System.out.println("奖品：小米蓝牙耳机青春版");
					prizeName = "小米蓝牙耳机青春版";
				}
				break;
			}else if(guessPrice < price){
				System.out.println("小了！请继续！");
			}else if(guessPrice > price){
				System.out.println("大了！请继续！");
			}
		}
		if(null == prizeName){
			System.out.println("很遗憾，五次机会已用完，期待下次吧！");
		}else{
			System.out.println("恭喜，您中奖了，奖品是：");
			System.out.println(prizeName);
		}
		
	}
}





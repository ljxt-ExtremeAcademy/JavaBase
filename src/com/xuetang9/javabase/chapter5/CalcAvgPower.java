package com.xuetang9.javabase.chapter5;

import java.util.Scanner;

/**
 * 求游戏工会玩家的平均战斗力
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月14日 上午11:40:45
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class CalcAvgPower {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int power = 0;	//玩家的战斗力
		int sum = 0;	//累加和
		double avg = 0;	//平均值
		//输入三个战力，求平均值
		for (int i = 0; i < 3; i++) {
			System.out.print("请输入第" + (i + 1) + "位玩家的战斗力：");
			power = input.nextInt();
			sum += power;
		}
		avg = sum / 3.0;
		System.out.printf("三位玩家的战斗力平均值为：%.2f\n", avg);
		//强烈建议：一个循环最好只做一件事
		//在以后学习数组后，使用单独的循环求战力之和
//		for (int i = 0; i < 3; i++) {
//			
//		}
		
	}

}





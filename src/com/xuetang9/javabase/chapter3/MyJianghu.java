package com.xuetang9.javabase.chapter3;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * 根据角色的内力值打印角色的能力描述
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月9日 上午10:31:29
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class MyJianghu {
	public static void main(String[] args) {
		String info = null;	//角色信息
		Scanner input = new Scanner(System.in);
		System.out.print("请输入角色的内力值：");
		int power = input.nextInt();
		if(power <= 1000){
			info = "不堪一击";
		}else if(power < 3000){
			info = "毫不足虑";
		}
		System.out.println("雁南飞大侠" + info);
		
//		if(power >=0 && power < 1000){
//			System.out.println("他看起来不堪一击");
//		}else if(!(power < 1000 || power > 3000)){//1000 - 3000之间
//			System.out.println("看起来好不足虑");
//		}
	}

}











package com.xuetang9.javabase.chapter3;

import java.util.Scanner;

/**
 * 刚好是打折季，如果总价大于50000就打7折，否则9折
 * 计算最后应付金额
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月9日 上午10:05:45
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class ShoppingDemo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float price;	//商品的单价
		float price1, price2, price3;
		int count;		//商品的数量
		double total;	//购买商品的总价
		float zhekou;	//折扣率
		//1.让用户输入三种商品的单价和数量
		System.out.print("请输入路易斯威登中号手表的单价：");
		price1 = price = input.nextFloat();	//接收用户输入的单价数字
		System.out.print("请输入商品的数量：");
		count = input.nextInt();
		total = price * count;	//计算总价
		
		System.out.print("请输入爱马仕时尚休闲皮带的单价：");
		price2 = price = input.nextFloat();	//接收用户输入的单价数字
		System.out.print("请输入商品的数量：");
		count = input.nextInt();
		total += price * count;	//计算两种商品的累加总价
		
		System.out.print("请输入香奈儿东方屏风香水的单价：");
		price3 = price = input.nextFloat();	//接收用户输入的单价数字
		System.out.print("请输入商品的数量：");
		count = input.nextInt();
		total += price * count;	//计算三种商品的累加总价
		//2.计算总价
		//3.根据总价判断是否打折
		
		//商家更改享受折扣的规则：
		//如果购买的三种商品每种商品的总价都大于5000
		//或三种商品总金额大于35000，折扣率为30%，
		//否则折扣率为80%
		if(price1 > 5000 && price2 > 5000 && price3 > 5000 || total > 35000){
			zhekou = 0.3f;
			System.out.println("打3折！！");
		}else{
			zhekou = 0.8f;
			System.out.println("打8折！");
		}

//		if(total >= 50000){
//			//打七折
//			//total *= 0.7;	//total = total * 0.7;
//			zhekou = 0.7f;
//		}else{
//			//total *= 0.9;
//			zhekou = 0.9f;
//		}
		total *= zhekou;
		//4.打印打折后应该支付的金额
		System.out.printf("最终应支付的金额为：%.1f", total);
	}

}












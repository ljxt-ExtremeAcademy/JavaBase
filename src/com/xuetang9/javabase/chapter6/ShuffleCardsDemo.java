package com.xuetang9.javabase.chapter6;
/**
 * 模拟实现洗牌的过程
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月19日 上午11:49:04
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class ShuffleCardsDemo {
	public static void main(String[] args) {
		//牌的花色数组
		String[] cardColors = {"黑桃", "红心", "方块", "梅花"};
		//牌面数组
		String[] cardValues = {
			"A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"J", "Q", "K"
		};
		final int N = 52;
		//52张牌
		int[] cards = new int[N];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = i;//牌面与循环变量的值一致，0-51之间
		}
		System.out.println("洗牌前：");
		for (int i = 0; i < cards.length; i++) {
			//System.out.print(cards[i]);
			System.out.printf("%s-%s", cardColors[cards[i] / 13], cardValues[cards[i] % 13]);
			if((i + 1) % 13 == 0){
				System.out.println();
			}else{
				System.out.print("\t");
			}
		}
		
		//洗牌：随机生成一个0-51之间的数字newIndex，cards[i]和cards[newIndex]元素相交换
		for (int i = 0; i < cards.length; i++) {
			int newIndex = (int)(Math.random() * N);//0-51之间的随机数字
			int temp = cards[i];
			cards[i] = cards[newIndex];
			cards[newIndex] = temp;		
		}

		System.out.println("洗牌后：");
		for (int i = 0; i < cards.length; i++) {
			//System.out.print(cards[i]);
			System.out.printf("%s-%s", cardColors[cards[i] / 13], cardValues[cards[i] % 13]);
			if((i + 1) % 13 == 0){
				System.out.println();
			}else{
				System.out.print("\t");
			}
		}
	}

}











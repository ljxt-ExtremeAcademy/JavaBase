package com.xuetang9.javabase.chapter5;
/**
 * 双循环
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月16日 上午11:09:04
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class DoubleFor {
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {//打印10行
			//内层循环控制列 控制列数、控制列打印的符号
			for (int j = 0; j <= 2 - i; j++) {//每行打印19个符号
				System.out.print(" ");	//只能打印符号，不要换行！
			}
			//打印完井号后，再打印星号：
			
			for (int j = 0; j <= 2 * i; j++) {
				if(j == 0 || j == 2 * i)//j是最大值或最小值的时候，打印星号
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();//由外层循环控制的换行
		}
		for (int i = 0; i < 3; i++) {//打印10行
			//内层循环控制列 控制列数、控制列打印的符号
			for (int j = 0; j <= i; j++) {//每行打印19个符号
				System.out.print(" ");	//只能打印符号，不要换行！
			}
			//打印完井号后，再打印星号：
			
			for (int j = 0; j <= 4 - 2 * i; j++) {
				if(j == 0 || j == 4 - 2 * i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();//由外层循环控制的换行
		}
		
		
		//行、列 - 双循环
		char ch = 'A';
		//外层循环控制行 控制行数、控制换行
//		for (int i = 0; i < 4; i++) {//打印10行
//			//内层循环控制列 控制列数、控制列打印的符号
//			for (int j = 0; j <= 2 - i; j++) {//每行打印19个符号
//				System.out.print(" ");	//只能打印符号，不要换行！
//			}
//			//打印完井号后，再打印星号：
//			
//			for (int j = 0; j <= 2 * i; j++) {
//				System.out.print((char)ch);
//			}
//			ch++;
//			System.out.println();//由外层循环控制的换行
//		}
//		for (int i = 0; i < 3; i++) {//打印10行
//			//内层循环控制列 控制列数、控制列打印的符号
//			for (int j = 0; j <= i; j++) {//每行打印19个符号
//				System.out.print(" ");	//只能打印符号，不要换行！
//			}
//			//打印完井号后，再打印星号：
//			
//			for (int j = 0; j <= 4 - 2 * i; j++) {
//				System.out.print((char)ch);
//			}
//			ch++;
//			System.out.println();//由外层循环控制的换行
//		}
		
		
		
//		for (int i = 0; i < 5; i++) {		//外层循环 - 控制行数
//			for (int j = 0; j < 5; j++) {
//				System.out.print("*");
////				if(j == 4){
////					System.out.println();
////				}
//			}
//			System.out.println();
//		}

	}

}






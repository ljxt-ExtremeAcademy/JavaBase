package com.xuetang9.javabase.chapter4;
/**
 * 使用循环计算1-100的累加和
	需要循环变量 
	需要累加和变量
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月12日 上午10:23:58
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class SumDemo {
	public static void main(String[] args) {
		//写出循环基本结构
		int sum = 0;	//用来保存累加和
		int i = 0;
		while(i < 100){
			//sum = sum + (i + 1);//累加  i+1的值
			sum += i + 1; //累加的核心代码！！！
			//sum += i;	//累加0-99的和
			i++;
		}
		
//		i = 1;
//		while(i <= 100){
//			sum += i;
//			i++;
//			//等价写法： sum += i++;
//		}
		
		
		
		System.out.println("1-100的累加和为：" + sum);
	}

}

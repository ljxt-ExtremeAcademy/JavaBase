package com.xuetang9.javabase.chapter4;

import java.util.Scanner;

/**
 * 模拟我的武侠世界选择人物功能
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月14日 上午10:38:22
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class MyWuxiaWorld {
	public static void main(String[] args) {
//		String str = String.format("%d%s", 123, "abc");
//		System.out.println(str);
		
		Scanner input = new Scanner(System.in);
		String answer = "y";	//用户输入的是否继续
		String name = null;		//给一个初值
		do{
			System.out.println("欢迎进入老九武侠世界，请大侠起个响当当的名号闯荡江湖吧：");
			name = input.nextLine();
			System.out.println("头衔：【初入江湖】");
			System.out.println("江湖名号：" + name);
			System.out.println(name + "大侠，满意您的江湖名号吗？(y/n)");
			answer = input.nextLine();
		//}while(answer.equals("y"));	//字符串比较时，不可以使用 ==
		//}while(answer.equalsIgnoreCase("y"));	//忽略大小写比较
		}while(!"y".equalsIgnoreCase(answer));	//建议的写法
		System.out.printf("【%s】大侠重入江湖，宵小之辈速速退避！\n", name);
		//input.close();
	}

}







package com.xuetang9.javabase.chapter10.rpgdemo;

public class HeroTest {

	public static void main(String[] args) {
		Warrior 曹操1 = new Warrior("曹操", 1500);
		Warrior 曹操2 = new Warrior("曹操", 1500);
		
		System.out.println(曹操1 == 曹操2);
		System.out.println(曹操1.equals(曹操2));
	
		System.out.println(曹操1);
		
		//万物皆对象 - EveryThing is Object! 
		
		
//		//Hero 韩信 =  new Warrior();
//		Hero 韩信;				//声明了一个Hero类型的变量  韩信
//		韩信 = new Warrior();		//在堆内存中分配了空间（同时调用子类构造进行初始化），将地址赋值给了韩信变量，
//		韩信.move();
//		
//		//问题：对象 韩信  的类型是什么？
//		
		

	}

}

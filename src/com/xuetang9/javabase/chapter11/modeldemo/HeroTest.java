package com.xuetang9.javabase.chapter11.modeldemo;

public class HeroTest {

	public static void main(String[] args) {
		//Á½¸öÕ½Ê¿Ö®¼äµÄ¶ÔÕ½
		Hero hero1 = new Warrior(1, "¸ÇÂ×", 0, 0);
		Hero hero2 = new Warrior(2, "õõ²õ", 50, 50);
//		hero1.PK(hero2);
//		System.out.println();
//		hero2.PK(hero1);
		
		Hero hero3 = new Magical(3, "²Ü²Ù", 500, 250, 250);
		hero3.PK(hero1);		//²Ü²Ù¹¥»÷¸ÇÂ×
		System.out.println("\n");
		hero1.PK(hero3);		//¸ÇÂ×¹¥»÷²Ü²Ù
		
	}

}

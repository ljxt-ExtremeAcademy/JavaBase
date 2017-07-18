package com.xuetang9.javabase.chapter10.rpgdemo;
/**
 * 对象数组的排序示例
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月18日 上午10:44:12
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class ObejctArraySortDemo {
	
	public static void sort(Hero[] heroArray){
		Hero tempHero = null;	//用来交换的英雄对象
		for (int i = 0; i < heroArray.length; i++) {
			for (int j = 0; j < heroArray.length - i - 1; j++) {
				if(heroArray[j].compareToByName(heroArray[j + 1]) < 0){
					tempHero = heroArray[j];
					heroArray[j] = heroArray[j + 1];
					heroArray[j + 1] = tempHero;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Warrior 战士1 = new Warrior();
		Warrior 战士2 = new Warrior();
		Warrior 战士3 = new Warrior();
		Warrior 战士4 = new Warrior();
		Warrior 战士5 = new Warrior();
		Archmage 法师1 = new Archmage();
		Archmage 法师2 = new Archmage();
		Archmage 法师3 = new Archmage();
		Archmage 法师4 = new Archmage();
		Archmage 法师5 = new Archmage();
		
		Hero[] heroArray = {
			战士1, 战士2, 战士3, 战士4, 战士5,
			法师1, 法师2, 法师3, 法师4, 法师5
		};
		System.out.println("排序前：");
		System.out.println("级别\t昵称\t\tmaxLife\tlife\t攻击力");
		for(Hero hero : heroArray){
			System.out.println(hero);
		}
		sort(heroArray);
		System.out.println("排序后：");
		System.out.println("级别\t昵称\t\tmaxLife\tlife\t攻击力");
		for(Hero hero : heroArray){
			System.out.println(hero);
		}

	}

}

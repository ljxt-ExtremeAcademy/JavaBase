package com.xuetang9.javabase.chapter4;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Scanner;

import javax.swing.plaf.ComboBoxUI;

/**
 * 使用循环实现简单的拳皇对战
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月12日 上午11:37:51
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class KingOfFighter {
	
	
	//随机数字：
	//Math.random()   //[0.0, 1.0)
	//(int)(Math.random() * 10000) % 10		 [0-9]
	//(int)(Math.random() * 10000) % 10 + 5  [5-14]
	//(int)(Math.random() * 10000) % 11 + 5  [5-15]
	//推导出随机数字公式： a - b
	// (int)(Math.random() * 12345) % (b - a + 1) + a
//	//播放音乐代码
//	File sound1 = new File("sounds/拳皇98选人画面.wav");
//	AudioClip sound_choose = Applet.newAudioClip(sound1.toURL());
//	sound_choose.play();//播放音乐
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		Scanner input = new Scanner(System.in);
		File sound1 = new File("sounds/拳皇98选人画面.wav");
		AudioClip sound_choose = Applet.newAudioClip(sound1.toURL());
		sound_choose.play();//播放音乐
		//1.让双方选名字：（只需要让用户选择即可）
		System.out.print("请输入玩家名称：");
		String userName = input.next();
		String comName = "大蛇";//电脑名称
		System.out.println(userName + " VS " + comName);
		
		sound_choose.stop();
		sound1 = new File("sounds/拳皇98格斗开始.wav");
		sound_choose = Applet.newAudioClip(sound1.toURL());
		sound_choose.play();//播放音乐
		
		//2.初始化双方的数据（体力值默认100）
		int hp1 = 100, hp2 = 100;		//双方的HP
		int attack1 = 0, attack2 = 0;	//双方的攻击力
		//3.使用循环模拟对战过程
		while(hp1 > 0 && hp2 >= 0){
			//生成双方的随机攻击力
			attack1 = (int)(Math.random() * 10000) % 11 + 5;
			attack2 = (int)(Math.random() * 10000) % 11 + 5;
			
			//让玩家先攻击
			hp2 -= attack1; //玩家攻击，电脑掉血
			System.out.println(userName + "打出了一记-里百八式 八酒杯，" + comName + "掉血" + attack2 + "两！");
			if(attack1 >= 0 && attack1 <= 5){
				System.out.println(comName + "被重重的打了一拳！");
			}else if(attack1 >= 6 && attack1 <= 10){
				System.out.println(comName + "被攻击到了要害部分，倒地1分钟才爬起来！");
			}
			sound_choose.stop();
			sound1 = new File("sounds/草稚京--百十四式 荒咬.wav");
			sound_choose = Applet.newAudioClip(sound1.toURL());
			sound_choose.play();//播放音乐
			Thread.sleep(3000);	//延迟3秒执行下面的代码

			hp1 -= attack2;
			System.out.println(comName + "打出了一记-里百八式 八酒杯，" + userName + "掉血" + attack1 + "两！");
			sound_choose.stop();
			sound1 = new File("sounds/攻击音效.wav");
			sound_choose = Applet.newAudioClip(sound1.toURL());
			sound_choose.play();//播放音乐
			Thread.sleep(500);	//延迟500毫秒执行下面的代码
		}
		//4.打印最终结果
		System.out.println("KO!");
		System.out.println("玩家姓名\t血量");
		System.out.println(userName + "\t" + hp1);
		System.out.println(comName + "\t" + hp2);
		
		
		
		//需要让程序暂停下，以便播放音乐		
		System.out.println("请输入任意键继续！");
		input.nextLine();
		

	}

}

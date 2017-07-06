package com.xuetang9.javabase.chapter6.project;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

/**
 * 后宫选妃-基础字符界面版
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月18日 上午9:09:21
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class AppMain_V1 {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		Scanner input = new Scanner(System.in);

    	AudioClip sound = Applet.newAudioClip(new File("sounds/背景音乐.wav").toURL());

	    int count = 5;  	//存放当前娘娘的总数
	    int currDay = 0;	//游戏当前进行到了第几天
	    final int DAY_COUNT = 10;	//游戏一共10天
	    int choice;     	//用来存放用户的选择
	    int tempCount;  	//临时变量，用来存放好感度低于60的个数
	    int index = -1; 	//用来存放删除、查找时的索引
	    String name;   	//用来存放用户输入的姓名
	    //姓名数组，最多容纳6个字符串，每个字符串的最大长度为8个字符（英文）
	    String[] names = {"西施", "貂蝉", "王昭君", "杨玉环", "赵飞燕", ""};
	    //级别数组，最多容纳5个字符串，每个字符串的最大长度为8个字符（英文）
	    String[] levelNames = {"贵人", "嫔妃", "贵妃", "皇贵妃", "皇后", ""};
	    //用来存放每个妃子的等级，与levelNames联用。-1表示未启用
	    int level[] = {0, 2, 0, 0, 0, -1};
	    //用来存放每个妃子的好感度，-1表示未启用
	    int loves[] = {100, 100, 100, 100, 100, -1};
	    do{
	    	sound.stop();
	        sound = Applet.newAudioClip(new File("sounds/背景音乐.wav").toURL());
	        sound.play();
	        System.out.printf("第%d天：\n", ++currDay);
	        String str = "1、皇帝下旨选妃！\t（增加）\n";
	        str += "2、翻牌宠幸\t（修改状态）\n";
	        str += "3、打入冷宫！\t（删除）\n";
	        str += "4、朕的爱妃呢？\t（查找）\n";
	        JOptionPane.showInputDialog(null, str);
	        for (int i = 0; i < str.length(); i++) {
				System.out.print(str.charAt(i));
				Thread.sleep(20);//休眠20毫秒
			}        
	        System.out.printf("陛下请选择：");
	        choice = input.nextInt();
	        switch(choice){
	        case 1://新增妃子，其他人好感度-10
	            sound.stop();
	        	sound = Applet.newAudioClip(new File("sounds/选妃.wav").toURL());
	            sound.play();
	            //首先判断数组长度是否可以增加元素
	            if(count >= level.length)
	            {
	                System.out.printf("\n后宫人满为患，陛下还是再等等吧！\n\n");
	                break;
	            }
	            System.out.printf("爱江山更爱美人，万千佳丽一点红~\n");
	            System.out.printf("娘娘名讳：");
	            name = input.next();
	            //将新增元素放在count处
	            names[count] = name;
	            level[count] = 0;
	            loves[count] = 100;
	            System.out.printf("\n新增妃子，其他人好感度-10\n\n");
	            for(int i = 0; i < count; i++){
	                loves[i] -= 10;
	            }
	            count++;
	            break;
	        case 2://翻牌宠幸，宠幸的妃子好感度+20，其他人-10
	        	sound.stop();
	        	sound = Applet.newAudioClip(new File("sounds/翻牌.wav").toURL());
	            sound.play();
	            System.out.printf("陛下请输入要宠幸的姓名：");
	            name = input.next();
	            for(int i = 0; i < count; i++){
	            	if(name.equals(names[i])){
	                    index = i;
	                    continue;
	                }
	                loves[i] -= 10;
	            }
	            if(index == -1)//没有找到
	            {
	                System.out.printf("\n祖国尚未统一，怎能儿女情长！\n\n");
	            }
	            else
	            {
	                loves[index] += 20;
	                //每临幸一次，级别提升1级，最高为4级，皇后
	                if(level[index] == 4){
	                	level[index] = 4;
	                }else{
	                	level[index]++;
	                }
	                System.out.printf("\n******************************\n");
	                System.out.printf("Duang~%s提升等级为：%s\n", names[index], levelNames[level[index]]);
	                System.out.printf("******************************\n\n");
	                System.out.printf("憔悴容华怯对春，寂寥宫殿锁闭门。\n此身却羡宫中树，不失芳时雨露恩。 \n");
	                System.out.printf("所有娘娘好感度-10！\n\n");
	            }
	            index = -1;
	            break;
	        case 3://打入冷宫，执行删除操作，其他妃子好感度统一+10
	        	sound.stop();
	        	sound = Applet.newAudioClip(new File("sounds/冷宫.wav").toURL());
	            sound.play();
	            System.out.printf("陛下要将哪位娘娘打入冷宫呢：");
	            name = input.next();
	            for(int i = 0; i < count; i++){
	            	if(name.equals(names[i])){
	                   index = i;
	                   break;
	                }
	            }
	            if(index == -1)//未找到要删除的姓名
	            {
	                System.out.printf("\n虚惊一场，无人打入冷宫，该吃吃该喝喝~\n\n");
	                break;
	            }
	            //执行删除操作
	            for(int i = index; i < count - 1; i++)
	            {
	            	names[i] = names[i + 1];
	                level[i] = level[i + 1];
	                loves[i] = loves[i + 1];
	            }
	            count--;//总人数-1
	            index = -1;//变量用完重置为初始值，方便下次使用
	            System.out.printf("\n%s已被打入冷宫，人情冷暖，所有娘娘好感度+10！\n\n", name);
	            for(int i = 0; i < count; i++){
	                loves[i] += 10;
	            }
	            index = -1;
	            break;
	        case 4://根据姓名查找，好感度+10
	        	sound.stop();
	        	sound = Applet.newAudioClip(new File("sounds/一笑倾城.wav").toURL());
	            sound.play();
	            System.out.printf("请输入要查找的姓名：");
	            name = input.next();
	            for(int i = 0; i < count; i++){
	                if(name.equals(names[i])){
	                    System.out.printf("\n微微一笑挺倾城，%s的好感度+10\n\n", name);
	                    loves[i] += 10;
	                    break;
	                }
	            }
	            break;
	        }// end of switch
	        System.out.printf("姓名\t等级\t好感度\n");
	        System.out.printf("-----------------------\n");
	        for(int i = 0; i < count; i++){
	            System.out.printf("%s\t%s\t%d\n", names[i], levelNames[level[i]], loves[i]);
	        }
	        //每天结算好感度，一旦有三个或以上的嫔妃好感度低于60，则发生暴乱，游戏结束
	        tempCount = 0;//临时变量，用来存放好感度低于60的个数
	        for(int i = 0; i < count; i++){
	            if(loves[i] < 60)
	                tempCount++;
	        }
	        if(tempCount >= 3){
	            System.out.printf("觉醒的嫔妃：姐妹们，组队刷皇上去了！\n");
	            //时间函数的固定用法
	            Calendar cal = Calendar.getInstance();	 //日历类          
	            //Date today = new Date();
	            //today.getYear() + 1900;
	            //SimpleDateFormat  
	            System.out.printf("公元%d年%d月%d日，皇帝卒！共执政%d天\n", 
	            		cal.get(Calendar.YEAR), 
	            		cal.get(Calendar.MONTH) + 1, 
	            		cal.get(Calendar.DATE), 
	            		currDay
	            );
	            System.exit(0);
	        }
	    }while(currDay < DAY_COUNT);

	    System.out.printf("皇帝登基10天来，五谷丰登、风调雨顺、妻妾成群。。。。。\n");
	    System.out.printf("没羞没臊的生活继续进行着。。。。。。。\n");
	    System.out.printf("姓名\t等级\t好感度\n");
	    System.out.printf("-----------------------\n");
	    for(int i = 0; i < count; i++){
	        System.out.printf("%s\t%s\t%d\n", names[i], levelNames[level[i]], loves[i]);

	    }

	}

}

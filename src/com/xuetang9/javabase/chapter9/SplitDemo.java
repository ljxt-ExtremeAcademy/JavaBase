package com.xuetang9.javabase.chapter9;
/**
 * 字符串分割
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月15日 下午2:04:34
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class SplitDemo {

	public static void main(String[] args) {
		String lyrics = 
				"太阳对我眨眼睛,鸟儿唱歌给我听.我是一个努力干活儿|还不粘人的小妖精,"
		        + "别问我从哪里来,也别问我到哪里去,我要摘下最美的花儿,献给我的小公举,"
		        + "大王叫我来巡山,我把人间转一转,打起我的鼓敲起我的锣,生活充满节奏感";
		String keywords = "马化腾,马x腾;马X腾";//敏感词
		String[] keywordArray = keywords.split(",|;");
		
		String[] newArray = lyrics.split(",|\\.|\\|");
		for (int i = 0; i < newArray.length; i++) {
			System.out.println(newArray[i]);
		}
		
		String newStr = String.join(";", newArray);
		System.out.println(newStr);

	}

}

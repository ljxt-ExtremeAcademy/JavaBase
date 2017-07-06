package com.xuetang9.javabase.chapter8.guessdemo;
/**
 * 人类玩家
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月4日 上午10:56:42
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class HumanPlayer {
	/** 静态常量：出拳的信息 */
	public static final int MessageTypeFist = 1;
	/** 静态常量：赢得比赛时的信息 */
	public static final int MessageTypeWin = 2;
	/** 静态常量：输掉比赛时的信息 */
	public static final int MessageTypeLose = 3;

	//属性：名称、分数、所出的拳、（角色对应的音效）、角色的个性化台词
	private String name;
	private int score;
	private int fist;
	//..............
	/** 角色在出拳的时候，所说的个性化台词 */
	private String[] fistWords = {
		"动感光波~biubiubiu~~~",
		"大象大象你的鼻子为什么这么长~~",
		"必杀：露PP外星人~~~",
		"大姐姐你喜欢吃青椒吗？",
		"胸部扁扁的欧巴桑，吃我一拳~"
	};
	
	private String[] winWords = {
		"还有谁~~",
		"猜拳，有点意思~~",
		"~~~超~~~~神~~~",
		"全军出击~~~！！！",
		"吃着火锅唱着歌，然后你就输了~"
	};
	
	private String[] loseWords = {
		"通往成功的路总在施工中。。。",
		"等到潮水退去，就知道谁在裸泳了。。。",
		"夏天就是不好，穷的时候我连西北风都没得喝。。。",
		"将来我死了。把QQ捐给希望工程。让孩子们一上来就能用带太阳的QQ。。。",
		"众人皆醉我独醒，举世皆浊我独清。。。"
	};
	
	/**
	 * 根据传入的消息类型，随机打印对应类型的消息
	 * @param msgType 对应HumanPlayer类中定义的静态常量
	 */
	public void sendMessage(int msgType){
		//生成一个0-4之间的随机数字
		int index = ((int)(Math.random() * 1000)) % 5;
		String message = null;	//要打印的消息
		switch (msgType) {
		case MessageTypeFist:
			message = fistWords[index];
			break;
		case MessageTypeWin:
			message = winWords[index];
			break;
		case MessageTypeLose:
			message = loseWords[index];
			break;
		}
		System.out.println(message);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getFist() {
		return fist;
	}

	public void setFist(int fist) {
		this.fist = fist;
	}
	
	
	
	//方法：设置和得到名称、分数、（播放音效）、说个性化台词、出拳
	
	
}












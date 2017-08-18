package com.xuetang9.javabase.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象的序列化和反序列化操作
 * 前提：对象必须实现Serializable接口（序列化接口）
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月18日 上午11:17:25
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class ObjectStreamDemo {
	private static final String FilePath = "src/com/xuetang9/javabase/chapter13/Object.dat";
	public static void main(String[] args) {
		Player player1 = new Player("我的世界你不懂", 99);
		
		//使用对象流将序列化的对象写入到文件中
		try(
				FileOutputStream fOutStream = new FileOutputStream(FilePath);
				ObjectOutputStream objOutStream = new ObjectOutputStream(fOutStream)
		){
			objOutStream.writeObject(player1);
			System.out.println("对象写入成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//从文件中读取对象内容，转换成我们可操作的对象
		try(
				FileInputStream fInStream = new FileInputStream(FilePath);
				ObjectInputStream objInStream = new ObjectInputStream(fInStream)
		){
			Player player2 = (Player)objInStream.readObject();
			System.out.println("读取出的对象内容：" + player2);
			System.out.println(player1 == player2);   //注意：这里比较的是两个对象的地址
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}
}
class Player implements Serializable{
	private static final long serialVersionUID = 421569974961829571L;
	
	private String nickName;
	private int level;
	
	public Player(){}
	
	public Player(String nickName, int level){
		setNickName(nickName);
		setLevel(level);
	}
	
	@Override
	public String toString() {
		return nickName + "\t" + level;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
}

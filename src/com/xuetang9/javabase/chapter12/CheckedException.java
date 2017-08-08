package com.xuetang9.javabase.chapter12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 必检异常 - 除了RunTimeExcetion和Error的其他类的子类
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月8日 上午10:36:40
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class CheckedException {
	public static void main(String[] args) {//arguments
		
		
		
		File file = new File("c:/test.txt");
		try {
			FileWriter writer = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//文件的写入器，用来将内容写入到文件中
		//判断这个文件是否存在
		System.out.println(file.exists());
	}
}

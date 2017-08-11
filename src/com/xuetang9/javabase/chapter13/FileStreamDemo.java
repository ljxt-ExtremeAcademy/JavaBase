package com.xuetang9.javabase.chapter13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * 演示文件输入、输出流的基本用法
 * 注意：目前的讀寫方式還比較原始，建議在這裡熟悉InputStream/OutputStream的一些重用方法即可
 * 後續會有一些高階的類對讀寫方法進行升級和擴展
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月11日 上午11:36:00
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class FileStreamDemo {
	private static final String FilePath = "src/com/xuetang9/javabase/chapter13/FileDemo.java";
	public static void main(String[] args) throws IOException {
		
//		//ReadFile();
		writeFile();
	}
	
	public static void writeFile() throws IOException{
		//注意：此文件默认不存在
		final String FilePath1 = "src/com/xuetang9/javabase/chapter13/FileDemo1.java";
		OutputStream outStream = new FileOutputStream(FilePath1, false);//第二个参数：是否追加写入
		String content = "package com.xuetang9.javabase.chapter13;\n";
		content += "//本类由代码自动生成\n";
		content += "public class FileDemo1{\n";
		content += "\tpublic static void main(String[] args){\n";
		content += "\t\tSystem.out.println(\"Hello World!\");\n\t}\n}";
		outStream.write(content.getBytes());//核心语句：将字符串转换成字节数组，写入到文件中
		//写入完毕后一定记得关闭打开的资源
		outStream.close();
		System.out.println("内容已成功写入到文件中，请检查：");
		System.out.println(FilePath1);
	}
	
	public static void ReadFile() throws IOException{
		File file = new File(FilePath);//省略判断
		InputStream inputStream = new FileInputStream(file);
		//inputStream.available() 获取输入流可以读取的文件大小（字节）
		//读取文件的基本操作 - 相对比较固定
		byte[] bytes = new byte[20000];
		inputStream.read(bytes);
//		int count = 0;
//		while((bytes[count] = (byte)inputStream.read()) != -1){
//			count++;
//		}
		String content = new String(bytes);	//将读取出的字节数组转换成字符串，以便打印
		System.out.println(content);
		inputStream.close();
	}

}








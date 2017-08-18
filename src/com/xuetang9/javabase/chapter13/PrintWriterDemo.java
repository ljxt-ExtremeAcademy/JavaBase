package com.xuetang9.javabase.chapter13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * PrintWriter和PrintStream
 * printWriter用来处理字符流，一次写入2个字节；PrintStream用来处理字节流，一次写入1个字节
 * 建议：在处理文本文件时，使用PrintWriter
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月15日 上午11:51:07
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class PrintWriterDemo {
	static final String FilePath = "src/com/xuetang9/javabase/chapter13/FileDemo1.java";
	public static void main(String[] args) {
		
		PrintWriter writer1 = new PrintWriter(System.out);
		writer1.println("使用PrintWriter打印出的内容！");
		writer1.flush();
		writer1.close();
//		//补充：关于Java中的分隔符  windows - \r\n   
//		String separator = System.getProperty("line.separator");//获得系统默认的分隔符 - 固定写法
//		String content = "package com.xuetang9.javabase.chapter13;" + separator;
//		content += "public class FileDemo1{" + separator;
//		content += "\tpublic static void main(String[] args){" + separator;
//		content += "\t\tSystem.out.println(\"HelloWorld!\");" + separator;
//		content += "\t}" + separator;
//		content += "}";
//		
//		
//		
//		try(PrintWriter writer = new PrintWriter(new File(FilePath))){
//			writer.write(content);
//			System.out.println("写入成功！");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		try(Scanner input = new Scanner(new File(FilePath))){
//			StringBuffer value = new StringBuffer();
//			while(input.hasNextLine()){
//				value.append(input.nextLine());
//				value.append(separator);
//			}
//			System.out.println("以下是从文件中读取出的内容：");
//			System.out.println(value.toString());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}

	}

}

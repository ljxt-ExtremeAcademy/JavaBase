package com.xuetang9.javabase.chapter13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * 修改歌词中的内容 - 实际上是一个文件读写操作
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月18日 上午10:23:45
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class ReplaceLyriceDemo {
	//注意：这里的sav后缀名是随便起的！
	static final String FilePath = "src/com/xuetang9/javabase/chapter13/lyrice.sav";
	
	/**
	 * 字符流
	 * 将读取文件的操作封装在方法中，方便以后的使用
	 * @param filePath
	 * @return
	 */
	public static String ReadFileByReader(String filePath){
		StringBuffer content = new StringBuffer();
		Reader reader = null;
		BufferedReader bReader = null;
		try {
			reader = new FileReader(filePath);
			bReader = new BufferedReader(reader);
			String line = null;
			while((line = bReader.readLine()) != null){
				content.append(line);
				content.append(System.getProperty("line.separator"));//拼接一个系统默认的分隔符 win-\r\n
			}
			//删除最后的系统分隔符
			content.delete(content.toString().lastIndexOf(System.getProperty("line.separator")), content.toString().length());		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bReader.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return content.toString();
		
	}

	/**
	 * 使用PrintWriter对象实现写入文件
	 * Scanner跟PrintWriter是一对
	 * 优点：代码简洁
	 * @param filePaht
	 * @param isAppend
	 */
	public static void WriteFileByPrintWriter(String content, String filePath, boolean isAppend){
		try(//JDK1.7以后的写法：可以自动关闭打开的资源！
				FileOutputStream outStream = new FileOutputStream(filePath, isAppend);
				PrintWriter writer = new PrintWriter(outStream);
			){
			writer.print(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//调用方法获得文件中的所有内容
		String content = ReadFileByReader(FilePath);
		//调用方法，将content字符串写入到文件中 - 请自行完成
		WriteFileByPrintWriter(content, FilePath, true);
		
	}
	
//	public static void main(String[] args) {
//		//使用字符流进行操作
//		Reader reader = null;
//		BufferedReader bReader = null;
//		Writer writer = null;
//		BufferedWriter bWriter = null;
//		StringBuffer lyrice = new StringBuffer();
//		try {
//			reader = new FileReader(FilePath);
//			bReader = new BufferedReader(reader);
//			
//			String line = null;
//			while((line = bReader.readLine()) != null){
//				lyrice.append(line);
//				lyrice.append(System.getProperty("line.separator"));//拼接一个系统默认的分隔符 win-\r\n
//			}
//			String newLyrice = lyrice.toString().replaceAll("（女）", "女：").replaceAll("（男）", "男：");
//			//将歌词写入文件
//			writer = new FileWriter(FilePath);
//			bWriter = new BufferedWriter(writer);
//			bWriter.write(newLyrice);
//			System.out.println("已替换成功！");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				bReader.close();
//				reader.close();
//				bWriter.flush();
//				bWriter.close();
//				writer.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//
//	}

}






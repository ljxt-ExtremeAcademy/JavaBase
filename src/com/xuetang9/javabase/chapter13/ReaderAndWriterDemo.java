package com.xuetang9.javabase.chapter13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 使用字符流对文件进行基本的读写操作
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月15日 上午11:35:36
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class ReaderAndWriterDemo {
	private static final String FilePath1 = "src/com/xuetang9/javabase/chapter13/FileDemo1.java";
	private static final String FilePath2 = "src/com/xuetang9/javabase/chapter13/FileDemo1.java";
	
	public static void main(String[] args) {
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(FilePath1));
			//固定的读取格式：
			String line = null;
			while((line = bReader.readLine()) != null){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//要写入的字符串
		String content = "package com.xuetang9.javabase.chapter13;\n";
		content += "//本类由代码自动生成1111111111\n";
		content += "public class FileDemo1{\n";
		content += "\tpublic static void main(String[] args){\n";
		content += "\t\tSystem.out.println(\"Hello World!\");\n\t}\n}";
		try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(FilePath2))) {
			//使用了jdk7以后新增的自动关闭资源的写法
			//使用前提：资源类必须实现Closeable接口
			bWriter.write(content);	//将字符串写入到缓冲中
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			//注意：由于bWriter.close会抛出IOException，这里的异常就被新结构抑制了
			//以下的代码用来查看被抑制的异常信息
			if(e.getSuppressed() != null){
				Throwable[] throwables = e.getSuppressed();
				for(Throwable t : throwables){
					System.err.println(t.getMessage() + "cased by " + t.getClass().getSimpleName());
				}
			}
		}

	}

}

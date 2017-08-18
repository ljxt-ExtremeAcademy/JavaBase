package com.xuetang9.javabase.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 从给定的url上读取文件内容 - 暂时只支持http协议
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月18日 上午11:37:13
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class ReadURLContent {
	static final String FilePath = "src/com/xuetang9/javabase/chapter13/163.html";
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.163.com/index.html");
		//将InputStream转换成Reader的套路：使用装饰器类InputStreamReader
		StringBuffer content = new StringBuffer();
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))){
			String line = null;
			while((line = reader.readLine()) != null){
				content.append(line);
				content.append(System.getProperty("line.separator"));
			}
			ReplaceLyriceDemo.WriteFileByPrintWriter(content.toString(), FilePath, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

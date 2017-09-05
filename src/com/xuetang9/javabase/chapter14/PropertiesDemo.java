package com.xuetang9.javabase.chapter14;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		//读取properties文件的常用做法
		Properties props = new Properties();
		//加载配置文件 - 固定的写法
		props.load(PropertiesDemo.class.getResourceAsStream("Config.properties"));
		//读取配置
		String value = props.getProperty("user1", "abc");//通过key获得value
		System.out.println(value);
		//向配置文件中写入内容
		props.setProperty("name", "Monkey·D·Luffy");
		props.setProperty("中文", "中华人们共和国");
		FileOutputStream outStream = new FileOutputStream("bin/com/xuetang9/javabase/chapter14/Config.properties");
		props.store(outStream, "写入时的注释 - Comments");
		
		props.load(PropertiesDemo.class.getResourceAsStream("Config.properties"));
		System.out.println("遍历所有的键值对");
		for(Entry<Object, Object> entry : props.entrySet()){
			System.out.println(entry.getKey() + " -- " + entry.getValue());
		}
	}

}

package com.xuetang9.javabase.chapter14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * 三种图的基本用法
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年9月5日 上午10:09:32
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class MapDemo {
	public static void main(String[] args) {
		//Map的基本用法();		
		//需求：统计java源文件中，每个关键字出现的次数
		统计关键字出现的次数();
	}
	
	public static void 统计关键字出现的次数(){
		final String fileName = "src/com/xuetang9/javabase/chapter14/MapDemo.java";
		final String keywords = "package, import, public, class, void, final, static, new, while, if, catch, for, try, return";
		//1、获得Java源文件中的字符串（行的集合、StringBuffer）
		List<String> contentList = ReadSourceFile(fileName);
		Set<String> keywordsSet = new HashSet<>();	
		keywordsSet.addAll(Arrays.asList(keywords.split(",")));
		//String[] keywordsArray = keywords.split(",");	//简单的做法	
		//2、遍历关键字集合，统计每一个关键字在源文件字符串中出现的次数 - 将关键字和次数以键-值的方式存放在Map集合中
		Map<String, Integer> keywordsMap = new HashMap<>();
		for(String keyword : keywordsSet){//外循环遍历关键字集合
			keyword = keyword.trim();
			for(String line : contentList){//内循环-每个关键字都遍历一次源码的所有行
				//统计每一行中，keyword出现的次数 (进行累加)
				//int num1 = 0;	int num2 = 0; int num3 = 0;
				int count = getLineKeywordCount(line, keyword);
				if(count == 0) continue;
				//将count放到map集合中
				if(keywordsMap.containsKey(keyword)){
					int oldCount = keywordsMap.get(keyword).intValue();
					keywordsMap.put(keyword, new Integer(count + oldCount));
				}else{
					keywordsMap.put(keyword, count);//关键字第一次出现，直接添加即可
				}
			}
		}
		//3、遍历Map集合（以关键字出现的次数来排序）
		for(Entry<String, Integer> entry : keywordsMap.entrySet()){
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		//排序显示
		System.out.println("-------------------------------------------------");
		Map<String, Integer> treeMap = new TreeMap<>(new MyTreeComparator(keywordsMap));
		treeMap.putAll(keywordsMap);
		for(Entry<String, Integer> entry : treeMap.entrySet()){
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
	/**
	 * 统计这一行（line）中，keyword出现的次数
	 * @param line
	 * @param keyword
	 * @return
	 */
	private static int getLineKeywordCount(String line, String keyword){
		if(null == line || line.length() == 0) return 0;
		//可以在这里添加其他逻辑判断：跳过注释行
		if(line.startsWith("/*") || line.startsWith("*") || line.startsWith("*/") || line.startsWith("//")){
			return 0;
		}
		int count = 0;
		//int num1 = 0;	int num2 = 0; int num3 = 0;
		String strLine = new String(line);
		int index = -1;
		while((index = strLine.indexOf(keyword)) != -1){
			count++;
			strLine = strLine.substring(index + keyword.length() + 1);
		}
		return count;
	}
	
	/**
	 * 读取传入路径的Java源文件，以字符串的方式返回源文件的所有内容
	 * @param fileName
	 * @return
	 */
	private static List<String> ReadSourceFile(String fileName){
		List<String> contentList = new ArrayList<>();
		try(
			FileReader freader = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(freader);
		){
			String line = null;
			while((line = reader.readLine()) != null){
				if(line.trim().length() == 1) continue;
				contentList.add(line.trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contentList;
	}
	
	public static void Map的基本用法(){
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Monkey·D·Luffy", 18);
		hashMap.put("Nami", 19);
		hashMap.put("Sanji", 25);
		hashMap.put("Nico Robin", 26);
		hashMap.put("Roronoa Zoro", 21);
		System.out.println("hashmap:" + hashMap);
		Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("Monkey·D·Luffy", 18);
		linkedHashMap.put("Nami", 19);
		linkedHashMap.put("Sanji", 25);
		linkedHashMap.put("Nico Robin", 26);
		linkedHashMap.put("Roronoa Zoro", 21);
		System.out.println("linkedHashMap:" + linkedHashMap);
		Map<String, Integer> treeMap = new TreeMap<>(new MyTreeComparator(hashMap));
		treeMap.putAll(hashMap);
//		treeMap.put("Monkey·D·Luffy", 18);
//		treeMap.put("Nami", 19);
//		treeMap.put("Sanji", 25);
//		treeMap.put("Nico Robin", 26);
//		treeMap.put("Roronoa Zoro", 21);
		System.out.println("treeMap:" + treeMap);
		
		System.out.println("第一种遍历方式：通过Map.keySet遍历key，通过key取出对应的value - 比较常用，需要二次取值");
		for(String key : treeMap.keySet()) {
			System.out.println(key + " -- " + treeMap.get(key));
		}
		
		System.out.println("第二种遍历方式：通过Map.entrySet使用迭代器遍历key和value");
		Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();
		Iterator<Map.Entry<String, Integer>> entrySetIt = entrySet.iterator();
		while(entrySetIt.hasNext()){
			Map.Entry<String, Integer> entry = entrySetIt.next();
			System.out.println(entry.getKey() + "\t\t" + entry.getValue());
		}
		
		System.out.println("第三种遍历方式：直接遍历Map.entrySet集合 - 容量大时，推荐使用本方法遍历map");
		for(Entry<String, Integer> entry : treeMap.entrySet()){
			System.out.println(entry.getKey() + "  ==  " + entry.getValue());
		}
		
	}
	
}
/**
 * 我们自己定义的比较器
 * 注意：默认情况下，Map的比较器只能对key进行排序
 * 根据值比较：需要自定义属性
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年9月5日 下午12:16:01
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
class MyTreeComparator implements Comparator<String>{
	private Map<String, Integer> map;
	public MyTreeComparator(Map<String, Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(String key1, String key2) {
//		if(key1.compareTo(key2) > 0) return -1;
//		if(key1.compareTo(key2) < 0) return 1;
		//根据value值进行比较
		if(map.get(key1).intValue() < map.get(key2).intValue()){
			return 1;
		}
		if(map.get(key1).intValue() > map.get(key2).intValue()){
			return -1;
		}
		return 0;
	}
	
}







































//	public static void Map的基本用法(){
//		//基本用法
//		Map<String, Integer> hashMap = new HashMap<String, Integer>();
//		hashMap.put("Monkey·D·Luffy", 18);
//		hashMap.put("Nami", 19);
//		hashMap.put("Sanji", 25);
//		hashMap.put("Nico Robin", 26);
//		hashMap.put("Roronoa Zoro", 21);
//		//遍历Map
//		System.out.println("Sanji的年龄：" + hashMap.get("Sanji"));
//		System.out.println("键的集合：");
//		for(String key : hashMap.keySet()){
//			System.out.print(key + ", ");
//		}
//		System.out.println();
//		System.out.println("值的集合：");
//		for(Integer value : hashMap.values()){
//			System.out.print(value + ", ");
//		}
//		System.out.println();
//		
//		System.out.println("第一种遍历方式：通过keySet遍历key和value(普遍使用的，缺点是需要二次取值)");
//		for(String key : hashMap.keySet()){
//			System.out.println(key + ", " + hashMap.get(key));
//		}
//		
//		System.out.println("第二种方式：通过Map.entrySet使用迭代器遍历key和value");
//		Set<Entry<String, Integer>> entrySet = hashMap.entrySet();
//		Iterator<Entry<String, Integer>> it = entrySet.iterator();
//		while(it.hasNext()){
//			Entry<String, Integer> entry = it.next();//取出Map中的一个键值对  对象
//			//分别打印键和值
//			System.out.println(entry.getKey() + ", " + entry.getValue());
//		}
//		
//		System.out.println("第三种方式：直接遍历Map.entrySet -- 大容量数据时，推荐使用");
//		for(Entry<String, Integer> entry : hashMap.entrySet()){
//			System.out.println(entry.getKey() + ", " + entry.getValue());
//		}
//		
//		
//		//TreeMap -- 我们希望使用value值来排序
//		Map<String, Integer> treeMap = new TreeMap<>(new MyComparator(hashMap));
//		treeMap.putAll(hashMap);
//		System.out.println("遍历TreeMap:");
//		for(Entry<String, Integer> entry : treeMap.entrySet()){
//			System.out.println(entry.getKey() + ", " + entry.getValue());
//		}
//		
//		Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
//		linkedHashMap.putAll(treeMap);
//		System.out.println("遍历LinkedHashMap:");
//		for(Entry<String, Integer> entry : linkedHashMap.entrySet()){
//			System.out.println(entry.getKey() + ", " + entry.getValue());
//		}
//	}
//	
//	
/**
 * 自定义比较器，可以通过value进行排序
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年9月5日 上午10:33:47
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
//class MyComparator implements Comparator<String>{
//	Map<String, Integer> map;
//	
//	public MyComparator(Map<String, Integer> map) {
//		this.map = map;
//	}
//
//	@Override
//	public int compare(String o1, String o2) {
//		//通过传入的键，找到对应的value进行比较
//		if(map.get(o1) > map.get(o2)) return 1;
//		if(map.get(o1) < map.get(o2)) return -1;
//		return 0;
//	}
//}
//	
//	
//	
//	
//	
	
	
	
	
	
	
//	public static void 统计Java源码中的关键字出现的次数(){
//	//当前要读取的Java源文件
//	final String fileName = "src/com/xuetang9/javabase/chapter14/MapDemo.java";
//	//要统计的关键字
//	String keywords = "package, import, public, class, void, final, null, new, try, catch, for, static, if, while";
//	//使用io流读取java源文件
//	//1.先从文件中读取出所有的行，把行添加到StringBuffer(StringBuilder)中（可以封装成单独的方法）
//	StringBuffer content = new StringBuffer();
//	try (
//		FileReader freader = new FileReader(fileName);
//		BufferedReader reader = new BufferedReader(freader);
//	){
//		String line = null;
//		while((line = reader.readLine()) != null){
//			content.append(line);
//			content.append(System.getProperty("line.separator"));//每行末尾添加分隔符，方便后续的循环判断
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	//2.再统计StringBuffer中的关键字及出现的次数
//	Map<String, Integer> keywordsMap = new HashMap<>();
//	Map<String, Integer> keywordsMap_Sorted = new TreeMap<>(new MyComparator(keywordsMap));
//	//关键字数组-使用逗号分隔
//	String[] keywordsArray = keywords.split(",");
//	//遍历源码中的每一行
//	String[] contentArray = content.toString().split(System.getProperty("line.separator"));
//	for (int i = 0; i < keywordsArray.length; i++) {//遍历每一个关键字
//		//统计每一个关键字在整篇文档中出现的次数
//		String keyword = keywordsArray[i].trim();	//取出某个关键字
//		for (int j = 0; j < contentArray.length; j++) {
//			String line = contentArray[j].trim();	//取出某一行
//			if(!line.contains(keyword)) continue;
//			//获取在这一行（line）中keyword出现的次数 - 封装成方法，减少这里的代码量
//			int count = getLineKeyWordsCount(line, keyword);
//			if(count == 0) continue;//如果没有关键字，就继续判断下一行
//			if(keywordsMap.get(keyword) != null){//如果关键字Map中已包含此关键字
//				//将关键字的次数取出并+count
//				int oldCount = keywordsMap.get(keyword).intValue();
//				keywordsMap.put(keyword, new Integer(oldCount + count));
//			}else{//如果关键字不存在，就直接添加即可
//				keywordsMap.put(keyword, new Integer(count));
//			}
//			
//		}
//	}
//	
//	System.out.println("每个关键字出现的次数：");
//	for(Entry<String, Integer> entry : keywordsMap.entrySet()){
//		System.out.println(entry.getKey() + " -- " + entry.getValue());
//	}
//	
//}
//
///**
// * 获取line中keyword出现的次数
// * @param line
// * @param keyword
// * @return
// */
//private static int getLineKeyWordsCount(String line, String keyword){
//	if(null == line || line.length() == 0) return 0;
//	//可以自行规定一个逻辑
//	//比如：跳过注释行
//	if(line.startsWith("//") || line.startsWith("/*") || line.endsWith("*/") || line.startsWith("* @")){
//		return 0;
//	}
//	int count = 0;
//	//int count = 0;	int count1 = 0;		int count2 = 0;
//	String lineStr = new String(line);	//为了截取方便，重新构建lineStr
//	int index = -1;
//	while((index = lineStr.indexOf(keyword)) != -1){
//		count++;
//		lineStr = lineStr.substring(index + keyword.length() + 1);
//	}	
//	return count;
//}
//








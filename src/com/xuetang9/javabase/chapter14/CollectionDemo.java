package com.xuetang9.javabase.chapter14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/**
 * TODO
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月29日 下午6:00:53
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class CollectionDemo {
	/**
	 * 集合使用建议：
	 * ArrayList/LinkedList/ArrayDeque/HashSet/LinkedHashSet/TreeSet
	 * 1、如果要遍历List结合，对于ArrayList、Vector来说，使用随遍历（get)效率更高；对于LinkedList/LinkHashSet来说，使用迭代器效率更高
	 * 2、如果需要经常执行插入、删除操作来改变包含大量数据的集合大小，建议使用LinkedList。（ArrayList、Vector可能需要重新分配内部数组的大小，从而影响效率）
	 * 3、如果有多个线程需要同时访问集合中的元素，可以考虑使用Collectons将集合包装成线程安全的集合
	 * @param args
	 */
	public static void main(String[] args) {
		//多态：使用List接口的一个子类ArrayList进行实现
		List<String> list1 = new ArrayList<>();
		list1.add("曹操");
		list1.add("曹冲");
		list1.add("曹植");
		list1.add("曹培");
		list1.add("曹仁");	
		System.out.println(list1);
		list1.add(1, "刘璇的");
		System.out.println(list1);
		list1.set(1, "关云长");
		System.out.println(list1);
		
		List<String> list2 = new ArrayList<>();
		list2.add("张翼德");
		list2.add("张飞龙");
		
		list1.addAll(list2);
		System.out.println(list1);
		
		System.out.println("集合的遍历");
		//1、List的遍历
		for(int i = 0; i < list1.size(); i++){
			System.out.print(list1.get(i) + ",  ");
		}
		System.out.println();
		//2、使用foreach循环
		for(String str : list1){
			System.out.print(str + ",  ");
		}
		System.out.println();
		//3、使用迭代器遍历
		Iterator<String> it = list1.iterator();
		//使用迭代器的方法相对比较固定
		while(it.hasNext()){
			System.out.print(it.next() + ",  ");
		}
		System.out.println();
		//4、使用ListIterator迭代器
		ListIterator<String> listIt = list1.listIterator();
		while(listIt.hasNext()){
			System.out.print(listIt.next() + ",  ");
		}
		System.out.println();
		//使用ListIterator与传统迭代器的区别
		//1、ListIterator不止可以向后访问，也可以向前访问
		//2、ListIterator可以修改集合中的元素
		System.out.println("使用ListIterator从后向前遍历集合元素（逆序）");
		ListIterator<String> listIt2 = list1.listIterator(list1.size());
		while(listIt2.hasPrevious()){//当迭代器中的元素存在上一个时
			System.out.print(listIt2.previous() + ",  ");
		}
		System.out.println("\n");
		ListIterator<String> listIt3 = list1.listIterator(3);
		if(listIt3.hasPrevious()){
			listIt3.previous();
			listIt3.set("赵子龙");//使用迭代器修改元素
		}
		System.out.println(list1);
		
		
		System.out.println("删除下标为4的元素：");
		//list1.remove(4);
		list1.remove("曹培");
		System.out.println(list1);
		
		System.out.println("subList(3, 5) : " + list1.subList(3, 5));
	}
	
	/**
	 * 使用迭代器的好处：在遍历集合时，不依赖某个类的实现
	 * @param it
	 */
	public void show(Iterator<? extends Employee> it){
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
//	public void show(List<Student> stuList){
//		
//	}
//	
//	public void show(List<Teacher> teacherList){
//		
//	}
}
class Employee{
	
}





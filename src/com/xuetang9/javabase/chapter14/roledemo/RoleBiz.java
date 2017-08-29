package com.xuetang9.javabase.chapter14.roledemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RoleBiz {
	List<Role> roleList = null;;
	public RoleBiz(){
		roleList = new ArrayList<>();
	}
	
	public void add(Role role){
		roleList.add(role);
	}
	
	public boolean delete(Role role){
		return roleList.remove(role);
	}
	
	public void show(){
		System.out.println("角色\t\t称号\t\t\t气血\t攻击力");
		Iterator<Role> roleIt = roleList.iterator();
		while(roleIt.hasNext()){
			System.out.println(roleIt.next());
		}
	}
	
	/**
	 * 可以使用迭代器书写更加《通用》的方法
	 * 迭代器是一个对抽象编程原则的良好实现案例：对具体类的依赖最小 
	 * @param it
	 */
	public void show(Iterator<Role> it){
		System.out.println("角色\t\t称号\t\t\t气血\t攻击力");
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public void order(){
		//使用指定的比较器进行排序
		Collections.sort(roleList, new RoleComparator());
		//逆序
		Collections.sort(roleList, Collections.reverseOrder(new RoleComparator()));
	}
}







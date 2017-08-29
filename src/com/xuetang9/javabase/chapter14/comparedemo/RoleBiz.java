package com.xuetang9.javabase.chapter14.comparedemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/**
 * 角色的业务类
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月29日 下午5:05:10
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class RoleBiz {
	//Role[] roleArray = new Role[999];
	ArrayList<Role> roleList = null;
	
	public RoleBiz(){
		roleList = new ArrayList<Role>();
	}
	
	public void add(Role role){
		if(role != null){
			roleList.add(role);
		}
	}
	
	public void delete(Role role){
		roleList.remove(role);
	}
	
	/**
	 * 将传入的角色对象在集合中进行修改
	 * @param role
	 */
	public void update(Role role){
		//1.在集合中找到这个对象
		//2.修改对象
		int index = roleList.indexOf(role);
		if(index != -1){
			roleList.set(index, role);    
		}
	}
	
	public void sort(){
		//1、自己实现排序算法：冒泡、插入、快速
		//2、使用内置的工具类进行排序 - 前提：必须实现比较器接口
		//2-1:实体类实现Compareble接口
//		Collections.sort(roleList);
//		Collections.reverse(roleList);//逆序
		//2-2:自定义一个比较器接口
		//Collections.sort(roleList, new RoleComparator_Attack());
		//基于比较器RoleComparator_Attack的逆序
		Collections.sort(roleList, Collections.reverseOrder(new RoleComparator_Attack()));
		
		//乱序
		//Collections.shuffle(roleList);
	}
	
	public void show(){
		System.out.println("角色\t\t称号\t\t\t气血\t攻击力");
		System.out.println("--------------------------------");
		Iterator<Role> roleIt = roleList.iterator();
		while(roleIt.hasNext()){
			Role role = roleIt.next();
			System.out.println(role.getName() + "\t" + role.getTitle() + "\t\t" + role.getHp() + "\t" + role.getAttack());
		}
	}
	
	
}
/**
 * 角色类中攻击力的比较器
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月29日 下午5:36:14
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
class RoleComparator_Attack implements Comparator<Role>{

	@Override
	public int compare(Role role1, Role role2) {
		if(role1.getAttack() > role2.getAttack()) return 1;
		if(role1.getAttack() < role2.getAttack()) return -1;
		return 0;
	}
	
}














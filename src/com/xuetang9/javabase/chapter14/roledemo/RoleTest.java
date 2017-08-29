package com.xuetang9.javabase.chapter14.roledemo;

import java.util.Comparator;

public class RoleTest {

	public static void main(String[] args) {
		RoleBiz biz = new RoleBiz();
		biz.add(new Role("梅长苏1", "麒麟才子1", 50, 100));
		biz.add(new Role("梅长苏2", "麒麟才子2", 120, 200));
		biz.add(new Role("梅长苏3", "麒麟才子3", 150, 500));
		biz.add(new Role("梅长苏4", "麒麟才子4", 80, 400));
		biz.add(new Role("梅长苏5", "麒麟才子5", 90, 250));
		//如果想实现在集合中的对象删除、排序等功能，需要用到比较器接口
		//1、实体类直接实现Comparable接口 - 需要实体类的支持
		//2、单独定义Comparator的子类
		Role delRole = new Role("梅长苏4", "麒麟才子4", 80, 300);
		System.out.println(biz.delete(delRole));
		biz.show();
		
		biz.order();
		biz.show();
		
		
	}

}
/**
 * 集合排序的第二种方式：直接为某个集合定义一个比较器
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月29日 上午11:54:30
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
class RoleComparator implements Comparator<Role>{

	@Override
	public int compare(Role role1, Role role2) {
		if(role1.getAttack() > role2.getAttack()) return 1;
		if(role1.getAttack() < role2.getAttack()) return -1;
		return 0;
	}
	
}






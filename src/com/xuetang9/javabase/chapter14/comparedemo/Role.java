package com.xuetang9.javabase.chapter14.comparedemo;

public class Role{ // implements Comparable<Role>{
	private String name;
	private String title;
	private int hp;
	private int attack;

	public Role(String name, String title, int hp, int attack) {
		this.name = name;
		this.title = title;
		this.hp = hp;
		this.attack = attack;
		
	}
	
//	@Override
//	public int compareTo(Role role) {
//		//为了能够使用Collections工具类中的sort方法进行默认的排序，实体类要实现Comparable接口
//		//为了方便观察，我们在比较对象的时候，使用气血属性进行对比
//		if(hp > role.getHp()) return 1;
//		if(hp < role.getHp()) return -1;
//		return 0;
//	}
	
	//重写equals方法，以便在集合中可以自动通过对象比较的方式进行删除元素
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Role)){
			return false;//传入对象类型不匹配，直接返回false
		}
		Role role = (Role)obj;//强制转换成子类型
		//我们认为：两个对象的name属性相同时，就表示两个对象相同 - 实际开发中的逻辑可以自定义
		return name.equals(role.getName());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}

	
	
	
}

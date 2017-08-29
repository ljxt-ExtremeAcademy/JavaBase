package com.xuetang9.javabase.chapter14.comparedemo;

public class RoleTest {

	public static void main(String[] args) {
		RoleBiz biz = new RoleBiz();
		biz.add(new Role("Ã·³¤ËÕ", "÷è÷ë²Å×Ó1", 50, 450));
		biz.add(new Role("Ã·¶ÌËÕ", "÷è÷ë²Å×Ó2", 150, 350));
		biz.add(new Role("Ã·ÖÐËÕ", "÷è÷ë²Å×Ó3", 250, 250));
		biz.add(new Role("Ã·ÀÇËÕ", "÷è÷ë²Å×Ó4", 350, 150));
		biz.add(new Role("Ã·ÓÐËÕ", "÷è÷ë²Å×Ó5", 450, 50));		
		biz.show();   
		System.out.println();
//		Role role4 = new Role("Ã·ÀÇËÕ", "÷è÷ë²Å×Ó4", 350, 150);
//		biz.delete(role4);
		
		//Role role4 = new Role("Ã·ÀÇËÕ", "4ºÅ÷è÷ë²Å×Ó", 350, 150);
		//biz.update(role4);
		//biz.show();
		
		System.out.println("ÅÅÐò£º");
		biz.sort();
		biz.show();
		
		
	}

}

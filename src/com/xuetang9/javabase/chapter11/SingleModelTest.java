package com.xuetang9.javabase.chapter11;

public class SingleModelTest {

	public static void main(String[] args) {
		SingleModel single1 = SingleModel.getInstance();
		System.out.println(single1.count);
		single1.count++;
		
		SingleModel single2 = SingleModel.getInstance();
		System.out.println(single2.count);
		
		System.out.println(single1 == single2);
		
	}

}

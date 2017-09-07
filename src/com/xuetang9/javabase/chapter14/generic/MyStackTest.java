package com.xuetang9.javabase.chapter14.generic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class MyStackTest {

	public static void main(String[] args) {
		
		//JDK系统实现的栈类：
		Stack<Integer> stack1 = new Stack<>();
		for(int i = 1; i <= 5; i++){
			stack1.push(i);
		}
		
		//使用迭代器遍历栈：
		System.out.println("使用迭代器进行遍历：");
		Iterator<Integer> stackIt = stack1.iterator();
		while(stackIt.hasNext()){
			System.out.println(stackIt.next());
		}
		
		System.out.println("出栈：");
		for (int i = 0; i < 5; i++) {
			System.out.println(stack1.pop());
		}
		
		System.out.println("使用迭代器进行遍历：");
		stackIt = stack1.iterator();
		while(stackIt.hasNext()){
			System.out.println(stackIt.next());
		}
		
//		//实例化自定义的栈对象 
//		MyStack<String> stack = new MyStack<String>();
//		stack.push("1");
//		stack.push("2");
//		stack.push("3");
//		stack.push("4");
//		stack.push("5");
//		System.out.println("出栈：" + stack.pop());
//		System.out.println("出栈：" + stack.pop());
//		System.out.println("出栈：" + stack.pop());
//		System.out.println("出栈：" + stack.pop());
//		System.out.println("出栈：" + stack.pop());
//		System.out.println("出栈：" + stack.pop());
//		
//		
//		System.out.println("size:" + stack.getSize());
//		System.out.println("容量：" + stack.capacity());
		
		
		//stack.add(123);		//自动装箱 - Integer
		
		
//		//遍历
//		for(int i = 0; i < stack.elementCount; i++){
//			//在没有使用泛型的情况下：我们需要打印所有字符串元素的前2个字符
//			//在默认情况下，没有出现编译错误 --  但是，出现了运行时异常
//			//谈朋友时没有任何问题，结果结婚后，不让上床。。。。
//			//作为一个程序员，我们希望异常/错误出现在编译期，而不是运行时
//			String str = (String)stack.get(i);
//			System.out.println(str.substring(0, 2));
//		}
		

	}

}

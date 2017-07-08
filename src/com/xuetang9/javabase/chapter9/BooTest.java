package com.xuetang9.javabase.chapter9;

public class BooTest {

	public static void main(String[] args) {
//		Book book = new Book("老九君醉酒谈Java", "123-321", 98.8, 5);
//		System.out.println(book.toString());
//		//实例化图书业务对象
//		BookBiz bookBiz = new BookBiz();
//		int num = 1234;
//		
//		bookBiz.sellBook(book);
//		bookBiz.test(num);
//		
//		System.out.println(num);
		
		
		
//		int[] nums = {1, 2};
//		Swap(nums);
//		System.out.println(nums[0] + "\t" + nums[1]);
		
		
		//引用传递
		Demo demo = new Demo();
		Swap(demo);
		System.out.println(demo.attr1 + "\t" + demo.attr2);

	}
	
	static class Demo{
		int attr1 = 10;
		int attr2 = 50;
	}
	
	public static void Swap(Demo demo){
		demo = new Demo();
		int temp = demo.attr1;
		demo.attr1 = demo.attr2;
		demo.attr2 = temp;
	}
	
	
	
	
	
	
	
	
	public static void Swap(int[] nums){
		int temp = nums[0];
		nums[0] = nums[1];
		nums[1] = temp;
	}

}

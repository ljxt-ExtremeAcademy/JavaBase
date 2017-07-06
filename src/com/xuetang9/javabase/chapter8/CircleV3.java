package com.xuetang9.javabase.chapter8;

public class CircleV3 {
	/** 圆的半径 */
	private double radius;
	/** 圆的周长 */
	private double perimeter;
	/** 圆的面积 */
	private double area;
	
//	public  //公有的
//	private //私有的
//	(default)	//默认  同一个包
//	protected	//受保护的 同一包或有父子关系
	
	
	public double getRadius(){
		return radius;
	}
	
	public void show(){
		System.out.println("周长为：" + this.getPerimeter());
		System.out.println("面积为：" + this.getArea());
	}
	
	public CircleV3() {}
	public CircleV3(double radius) {
		//this.radius = radius;
		this.setRadius(radius);
	}

	public void setRadius(double radius){
		if(radius <= 0){//封装的好处：可以对传入的属性进行简单的验证
			radius = 1;
		}else{
			//this->自指针   朕/寡人
			this.radius = radius;
		}		
	}

	public double getPerimeter() {
		perimeter = 2 * Math.PI * radius;
		return perimeter;
	}

	public double getArea() {
		area = Math.PI * Math.pow(radius, 2);
		return area;
	}

	
	
	
}

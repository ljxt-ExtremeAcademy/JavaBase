package com.xuetang9.javabase.chapter8;

import java.util.Scanner;

public class CircleTest {

	public static void main(String[] args) {
//		Circle circle = new Circle();
//		circle.inputRaius();
//		circle.showPerimeter();
//		circle.showArea();
		
//		CircleV2 circle = new CircleV2(25);
//		circle.showArea();
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("«Î ‰»Î‘≤µƒ∞Îæ∂£∫");
		double radius = input.nextDouble();
		CircleV3 circle = new CircleV3(radius);
		circle.show();
		

	}

}

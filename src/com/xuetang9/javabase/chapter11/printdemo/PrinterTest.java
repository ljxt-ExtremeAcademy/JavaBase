package com.xuetang9.javabase.chapter11.printdemo;

import com.xuetang9.javabase.chapter11.printdemo.impl.A4PaperImpl;
import com.xuetang9.javabase.chapter11.printdemo.impl.ColorInkBoxImpl;

public class PrinterTest {
	public static void main(String[] args) {
		Printer printer = new Printer();
		
		//为打印机安装纸张和墨盒
		printer.setInkbox(new ColorInkBoxImpl());
		printer.setPaper(new B5PaperImpl());
		
		printer.print("测试内容");
	}
}

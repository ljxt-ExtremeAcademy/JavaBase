package com.xuetang9.javabase.chapter9.productdemo;

import javax.swing.JOptionPane;

/**
 * 商品管理类
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月8日 下午3:36:27
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class ProductBiz {
	public static void main(String[] args) {
		/** 用来保存每种商品的 总量 */
		int[] counts = new int[3];
		double total = 0;	//最终要支付的总金额
		//改进方案：使用对象数组
		Product[] products = new Product[3];
		for (int i = 0; i < counts.length; i++) {
			if(products[i] == null)
				products[i] = new Product();	//对象数组中的元素使用之前，一定要记得分配空间		
			//Product product = new Product();
			String name = JOptionPane.showInputDialog("请输入商品名称：");
			products[i].setName(name);
			//接收用户输入的商品单价，要注意，返回值是字符串类型！！
			String strPrice = JOptionPane.showInputDialog("请输入商品的单价：");
			//需要将字符串类型转换为double类型，再进行赋值！
			//转换前最好进行正确性验证，以避免异常
			products[i].setPrice(Double.parseDouble(strPrice));
			String strCount = JOptionPane.showInputDialog("请输入购买的数量：");
			counts[i] = Integer.parseInt(strCount);
			
			//累加总金额
			total += products[i].getPrice() * counts[i];
		}
		System.out.println("购物结算：");
		for (int i = 0; i < products.length; i++) {
			System.out.println(products[i].getName() + "\t" + products[i].getPrice());
		}
		System.out.println("商品总金额为：" + total);
	}
}







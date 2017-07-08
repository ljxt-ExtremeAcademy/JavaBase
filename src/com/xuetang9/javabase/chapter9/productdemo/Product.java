package com.xuetang9.javabase.chapter9.productdemo;
/**
 * 商品实体类
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月8日 下午3:33:38
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class Product {
	private String name;
	private double price;
	/** 商品的描述 */
	private String description;
	/** 商品的服务 */
	private String[] services;
	
	public Product(){}
	
	public Product(String name, String description){
		setName(name);
		setDescription(description);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String[] getServices() {
		return services;
	}
	public void setServices(String[] services) {
		this.services = services;
	}
	
	
}











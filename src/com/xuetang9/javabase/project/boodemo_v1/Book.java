package com.xuetang9.javabase.project.boodemo_v1;
/**
 * 图书实体类
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月22日 上午11:07:38
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class Book {
	private String bookId;		//图书的内部编号
	private String bookName;	//图书名称
	private String isbn;		//图书的出版号
	private String type;		//图书的类型
	private String author;		//作者 - 暂时不使用
	private String publisher;	//出版社 - 暂时不使用
	private int count;			//当前书籍的库存量 - （入库-增加库存）、（出库-减少库存的操作）
	private double price;		//图书的单价
	
	public Book(){
		
	}
	
	/**
	 * 重写了图书对象的equals方法，方便后续进行的对象恒等性比较
	 * book1.equals(book2)
	 */
	@Override
	public boolean equals(Object obj) {
		//如果传入的参数为空 或 不是Book类的实例，直接不需要判断，返回false
		if(null == obj || !(obj instanceof Book)){
			return false;
		}
		Book book = (Book)obj;	
		return bookId.equals(book.getBookId());
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}

package com.xuetang9.javabase.project.boodemo_v1;

import java.util.Scanner;

/**
 * 管理系统界面的控制台实现类
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月25日 上午11:11:43
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class BookViewConsoleImpl extends AbstractBookView{
	private Scanner input = null;
	private BookBiz bookBiz = null;
	
	public BookViewConsoleImpl() {
		input = new Scanner(System.in);
		bookBiz = new BookBiz();
		
		System.out.println("*********************************");
		System.out.println("\t欢迎使用X9图书管理系统");
		System.out.println("\t1、登录\t\t2、退出系统");
		System.out.println("*********************************");
		System.out.print("请选择：");
		String choice = input.next();
		if("1".equals(choice)){
			//执行登录操作
			//如果验证成功，就显示主菜单
			System.out.println("登录功能暂未实现，默认已登录\n");
			//while(showMainView()){}
			//showMainView();
			doMainView();
		}
		System.out.println("X9图书系统已成功退出，欢迎再次使用！");
	}
	
	@Override
	public String showMainView() {
		System.out.println("\nX9图书管理系统 >> 主菜单");
		System.out.println("1、新增图书\t2、删除图书\t3、查看所有图书\t4、按编号查询\t5、入库\t6、出库\t7、退出");
		System.out.print("请选择：");
		String choice = input.next();
		return choice;
	}

	@Override
	public void showOutStore() {
		System.out.println("\nX9图书管理系统 >> 图书出库");
		System.out.print("出库的图书编号：");
		String bookId = input.next();
		System.out.print("出库的数量：");
		int bookCount = input.nextInt();
		if(bookBiz.outStore(bookId, bookCount)){
			System.out.println("出库成功！");
			showBooks(null);
		}else{
			System.out.println("出库失败，请检查输入的图书编号或出库数量是否超限！");
		}
	}

	@Override
	public void showInStore() {
		//入库需要两个参数：图书id，入库的数量
		System.out.println("\nX9图书管理系统 >> 图书入库");
		System.out.print("入库的图书编号：");
		String bookId = input.next();
		System.out.print("入库的数量：");
		int bookCount = input.nextInt();
		if(bookBiz.inStore(bookId, bookCount)){
			System.out.println("入库成功！");
			showBooks(null);
		}else{
			System.out.println("入库失败，请检查输入的图书编号！");
		}
	}

	@Override
	public void showFindById() {
		System.out.println("\nX9图书管理系统 >> 按编号查询");
		System.out.println("请输入要查询的图书编号：");
		String bookId = input.next();	
		Book book = bookBiz.findById(bookId);
		if(book == null){
			System.out.println("没有找到任何的图书信息！");
			return;
		}
		showBooks(book);
	}

	@Override
	public void showDelBookView() {
		System.out.println("\nX9图书管理系统 >> 删除图书");
		//暂时只实现根据id删除
		System.out.print("请输入要删除的图书编号：");
		String delId = input.next();
		Book delBook = new Book();
		delBook.setBookId(delId);
		if(bookBiz.delBook(delBook)){//如果删除成功
			System.out.println("删除成功！");
			showBooks(null);	//打印默认的图书仓库，相当于刷新显示当前图书仓库中的内容
		}else{//删除失败
			System.out.println("删除失败！");
		}
	}

	@Override
	public Book showAddNewBookView() {
		System.out.println("\nX9图书管理系统 >> 新增图书");
		System.out.print("内部编号：");
		String bookId = input.next();
		//这里需要验证用户输入的编号是否存在
		Book newBook = bookBiz.findById(bookId);
		if(newBook == null){//可以添加图书
			newBook = new Book();
			newBook.setBookId(bookId);
			System.out.print("名称：");
			newBook.setBookName(input.next());
			System.out.print("库存：");
			newBook.setCount(input.nextInt());
			//...........
			bookBiz.addBook(newBook);//调用图书业务对象，将新增的图书对象添加到图书仓库中
		}else{//图书已存在
			System.out.println("此内部编号已存在，请重新录入！");
			newBook = showAddNewBookView();	//重新调用本方法，让用户再次输入 - 递归调用
		}
		return newBook;
	}

	@Override
	public void showBooks(Book... bookArray) {
		System.out.println("内部编号\t名称\t\t\t库存");
		if(bookArray == null){
			bookArray = Datas.BookStore;
		}
		int bookCount = bookBiz.getBookCount(bookArray);
		for(int i = 0; i < bookCount; i++){
			System.out.printf("%s\t\t%s\t%d\n", 
					bookArray[i].getBookId(), bookArray[i].getBookName(), bookArray[i].getCount());
		}
		
	}

}

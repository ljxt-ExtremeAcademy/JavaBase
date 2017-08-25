package com.xuetang9.javabase.project.boodemo_v1;
/**
 * 图书的业务类 - 业务经理
 * 包含对图书以及图书数组的基本操作
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月22日 上午11:20:05
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class BookBiz {
	
	//以下开始书写基本的业务方法 - 天人交战
	//增加图书、出库、入库、查询、排序
	
	/**
	 * 获得图书仓库中Datas.BookStore数组中图书对象的个数
	 * @return
	 */
	public int getBookCount(){
		int count = 0;
		for(Book book : Datas.BookStore){
			if(book == null) break;
			count++;
		}
		return count;
	}
	
	public int getBookCount(Book ...books){
		int count = 0;
		for(Book book : books){
			if(book == null) break;
			count++;
		}
		return count;
	}
	
	/**
	 * 将传入的图书对象放置到图书仓库（数组）中去
	 * @param book
	 * @return 是否放置成功 - 假设图书仓库的空间已满，返回false
	 */
	public boolean addBook(Book book){
		int bookCount = getBookCount();
		if(Datas.BookStore.length == bookCount){
			return false;
		}
		//如果仓库不满，就将传入的图书对象放置在数组的最后一个位置（第一个非null位置）
		Datas.BookStore[bookCount] = book;
		return true;
	}
	
	/**
	 * 删除传入的图书对象
	 * @param book
	 * @return 是否删除成功
	 */
	public boolean delBook(Book book){
		int bookCount = getBookCount();
		int delIndex = -1;	//要删除元素的下标
		for(int i = 0; i < bookCount; i++){
			//if(book.getBookId().equals(Datas.BookStore[i].getBookId())){
			if(book.equals(Datas.BookStore[i])){
				delIndex = i;
				break;
			}
		}
		if(delIndex == -1){
			return false;//没有找到要删除的元素时，直接结束方法，返回false
		}
		//执行数组删除的套路
		for(int i = delIndex; i < bookCount - 1; i++){
			Datas.BookStore[i] = Datas.BookStore[i + 1];
		}
		//将最后一个元素置为null
		Datas.BookStore[bookCount - 1] = null;
		return true;		
	}
	
	/**
	 * 通过图书id查找对应的图书对象
	 * @param bookId
	 * @return 没有找到，返回null
	 */
	public Book findById(String bookId){
		int bookCount = getBookCount();
		for(int i = 0; i < bookCount; i++){
			if(bookId.equals(Datas.BookStore[i].getBookId())){
				return Datas.BookStore[i];
			}
		}
		return null;
	}
	
	/**
	 * 入库：为仓库中现有的图书增加库存
	 * @param bookId 要入库的图书id
	 * @param count  入库的数量
	 * @return 如果入库的bookId不存在，入库失败
	 */
	public boolean inStore(String bookId, int count){
		Book book = findById(bookId);
		if(null == book){//如果入库的bookId不存在
			return false;//尽量在业务类中不要使用打印语句
		}
		//增加库存 - 注意，这里是引用传递
		book.setCount(book.getCount() + count);
		return true;
	}
	
	/**
	 * 出库：将仓库现有库存减少
	 * @param bookId
	 * @param count
	 * @return 现有库存小于count时，出库失败
	 */
	public boolean outStore(String bookId, int count){
		Book book = findById(bookId);
		if(null == book){
			return false;
		}
		if(book.getCount() < count){
			return false;
		}
		book.setCount(book.getCount() - count);
		return true;
	}
	
	
}









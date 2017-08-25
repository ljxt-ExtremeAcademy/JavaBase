package com.xuetang9.javabase.project.boodemo_v1;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件工具类，包含对文件的读写静态方法，方便使用
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月25日 上午11:35:33
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class FileUtil {
	/** 用来进行读写操作的图书信息文件路径 */
	private static final String BookFile = "src/com/xuetang9/javabase/project/boodemo_v1/BookInfo.dat";
	/** 用来分割属性的分隔符，默认是英文逗号 */
	private static final String SepAttr = ",";
	/** 默认的行的分隔符 */
	private static final String SepLine = System.getProperty("line.separator");
	
	/**
	 * 将传入的图书对象数组写入到文件中
	 * 注意：本方法会将图书仓库数组中的内容全新的写入到文件中（覆盖操作）
	 * @param bookArray
	 */
	public static void SaveBooks(Book ...bookArray){
		
		if(bookArray == null || bookArray.length == 0) return;
		BookBiz bookBiz = new BookBiz();
		File bookFile = new File(BookFile);
		if(!bookFile.exists())
			try {
				bookFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		try(FileWriter fout = new FileWriter(bookFile, false);//不追加，会覆盖当前文件
			BufferedWriter out = new BufferedWriter(fout);	
			){
			StringBuffer content = new StringBuffer();
			int bookCount = bookBiz.getBookCount(bookArray);//获得传入图书数组中的图书对象个数（不为null的）
			for(int i = 0; i < bookCount; i++){//这里暂时实现的是简单的属性拼接
				content.append(bookArray[i].getBookId());	content.append(SepAttr);
				content.append(bookArray[i].getBookName());	content.append(SepAttr);
				content.append(bookArray[i].getCount());	content.append(SepLine);//一行结束，就拼接行的分隔符
			}
			//将字符串写入到文件
			out.write(content.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从文件中读取内容，将内容逐行拆解，重新整合成对象、对象数组并返回
	 * @return
	 */
	public static Book[] LoadBooks(){
		File bookFile = new File(BookFile);
		if(!bookFile.exists()){
			return null;
		}
		Book[] bookArray = new Book[999];//注意：读取的时候，最多只能读取999个图书对象
		try(FileReader fReader = new FileReader(bookFile);
			BufferedReader reader = new BufferedReader(fReader);
		){
			String line = null;
			int count = 0;
			while((line = reader.readLine()) != null){//读取文件的套路
				Book currBook = new Book();
				//line : 1000,老九君外传1,10
				String[] attrs = line.split(SepAttr);//将读取出的一行以属性分隔符进行分隔，返回分隔后的字符串数组
				currBook.setBookId(attrs[0].trim());
				currBook.setBookName(attrs[1].trim());
				currBook.setCount(Integer.parseInt(attrs[2].trim()));
				//将构建成功的图书对象添加到图书数组中，以便返回
				bookArray[count] = currBook;
				count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookArray;
	}
}








package com.xuetang9.javabase.chapter13;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 使用带缓冲的流增加读写效率
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月15日 上午10:09:47
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class BufferedStreamDemo {
	/**
	 * 注意：本文件路径是在老九君的电脑中
	 * 如果是本地测试，一定记得将文件路径修改成自己电脑中的路径！
	 */
	private static final String FilePath1 = "C:/Users/窖头/Videos/Recordings/Java直播之皇帝选妃项目配套录音.mp3";
	private static final String FilePath2 = "C:/Users/窖头/Videos/Recordings/已复制文件.mp3";
	
	
	public static void main(String[] args) throws IOException {
		//使用缓冲流装饰系统的输入流对象
//		BufferedInputStream inStream = new BufferedInputStream(System.in);
//		byte[] bytes = new byte[200];
//		System.out.println("请输入字符串：");
//		inStream.read(bytes);
//		System.out.println("用户输入的字符串是：" + new String(bytes));
		
		long time = CopyFileByBufferedStream();
		System.out.println("拷贝用时：" + time + "毫秒");
		
		//小作业：请各位小伙伴自行使用FileInputStream实现文件的复制
		//通过复制所用的时间，对比使用缓存的好处
		//通过设置不同的缓存大小，体会效率的区别
	}
	/**
	 * 使用缓存流拷贝文件
	 * @return 拷贝过程的用时（毫秒）
	 */
	private static long CopyFileByBufferedStream(){
		File file = new File(FilePath1);//要复制的文件对象
		if(!file.exists()){
			System.out.println("文件不存在，复制失败！");
			return 0;
		}
		long starTime = System.currentTimeMillis();
		InputStream inStream = null;
		BufferedInputStream bInStream = null;
		OutputStream outStream = null;
		BufferedOutputStream bOutStream = null;
		try {
			inStream = new FileInputStream(file);
			bInStream = new BufferedInputStream(inStream);
			outStream = new FileOutputStream(FilePath2);
			bOutStream = new BufferedOutputStream(outStream);
			int i = -1;//读取出的临时变量
			while((i = bInStream.read()) != -1){
				bOutStream.write(i);
				//注意：读取一个字节，就写入到了缓存中！需要在最后，将缓存中的内容写入到文件中！.
				//即，需要清空缓冲区，将缓冲区的内容写到文件中 - flush()
			}
			System.out.println("文件复制成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//bOutStream.flush();
				bOutStream.close();//可以直接调用close方法，内部已经帮我们自动调用了flush方法
				outStream.close();
				bInStream.close();
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		return endTime - starTime;
	}
	
	
	
	
//	static final String FilePath1 = "src/com/xuetang9/javabase/chapter13/FileStreamDemo.java";
//	static final String FilePath2 = "src/com/xuetang9/javabase/chapter13/BufferTest.txt";
	
//	public static void main(String[] args) {
//		FileInputStream fInputStream = null;
//		BufferedInputStream bInputStream = null;
//		try {
//			fInputStream = new FileInputStream(FilePath1);
//			bInputStream = new BufferedInputStream(fInputStream);
//			byte[] bytes = new byte[bInputStream.available()]; 
//			bInputStream.read(bytes);
//			System.out.println(new String(bytes));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				bInputStream.close();
//				fInputStream.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		BufferedOutputStream bOutStream = null;
//		try {
//			bOutStream = new BufferedOutputStream(new FileOutputStream(FilePath2), 10240);
//			bOutStream.write("今天天气很好！".getBytes());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				bOutStream.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//
//	}

}

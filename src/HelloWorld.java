import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * 使用Java打印角色信息
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月5日 上午10:28:56
 * @copyright 老九学堂
 * @remarks TODO
 *
 */

public class HelloWorld {
	/*
	 * 多行注释
	 */
	public static void main(String[] args) {
		
		
		
		Scanner input = new Scanner(System.in);
		
		//int i = input.nextInt();
		
		String str1 = input.next();
		input.reset();
		String str2 = input.next();
		
		System.out.println(str1);
		System.out.println(str2);
	}
}


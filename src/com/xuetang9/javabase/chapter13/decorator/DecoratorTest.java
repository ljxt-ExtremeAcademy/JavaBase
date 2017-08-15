package com.xuetang9.javabase.chapter13.decorator;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 使用装饰器模式的场合
 * 1、当我们需要在不影响其他对象的情况下，以动态、透明的方式为对象添加功能（扩展方法的实现）
 * 2、当不适合使用继承，但是又想进行方法的扩展时
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月15日 上午10:58:29
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class DecoratorTest {

	public static void main(String[] args) throws FileNotFoundException {
		//创建要被装饰的原始对象
		Component component = new  TrueComponent();
		//为原始对象透明的增加功能
		ComponentImplA componentA = new ComponentImplA(component);
		ComponentImplB componentB = new ComponentImplB(componentA);
		componentB.read();
		
		
		InputStream inputSteam = new FileInputStream("");
		//使用带缓存的流对象装饰输入流对象
		BufferedInputStream bInStream = new BufferedInputStream(inputSteam);

	}

}

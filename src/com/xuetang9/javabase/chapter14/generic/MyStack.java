package com.xuetang9.javabase.chapter14.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 堆栈类 - 先进 后出
 * 放入元素：入栈 - 在首元素位置进行插入
 * 取出元素：出栈 - 取出并删除首元
 * 作业1：模仿MyStack，实现自定义队列：MyQueue - 先进先出
 * boolean offer(T)			向对列尾插入一个元素					   -  入队			
 * E poll()					获取并删除队列头元素，如果队列为空，返回null  -  出队
 * E remove()				获取并删除队列头元素，如果队列为空，返回null
 * *Iterator<T> iterator()	返回迭代器
 * 
 * 作业2：实现LinkedList - 链表   每个元素保存下一个元素的内存地址（单向链表）
 * 实现对链表元素的增减、删除、遍历操作
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年9月7日 下午8:09:52
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class MyStack<T> {//在编译期定义的泛型类型，如果有多个类型：<T1, T2, E1, E2, V1, V2>
	/** 栈结构中用来保存元素的对象数组 */
	protected Object[] elementData;
	/** 用来保存栈结构中元素的总数 */
	protected int elementCount;
	/** 容量的增加量 - 当存储元素的数组空间不够的时候，数组空间自动增加capacityIncrement */
	protected int capacityIncrement;
	
	public MyStack(){
		//默认10个元素空间大小
		this(10);
	}
	
	public MyStack(int initialCapacity){//初始容量
		this(initialCapacity, 10);
	}
	/**
	 * 通过给定的初始容量和容量增长量创建一个栈对象
	 * @param initialCapacity
	 * @param capacityIncrement
	 */
	public MyStack(int initialCapacity, int capacityIncrement){
		if(initialCapacity < 0){
			//return;//return目前来讲就比较low了
			throw new IllegalArgumentException("初始化容量不能小于零：" + initialCapacity);
		}
		elementData = new Object[initialCapacity];
		this.capacityIncrement = capacityIncrement;	
	}
	
	/**
	 * 在栈的最后一个位置添加元素，不属于栈方法，类似ArrayList的add方法
	 * @param t
	 */
	public void add(T t){
		grow();
		elementData[elementCount] = t;
		elementCount++;
	}
	
	/**
	 * 增加容量
	 */
	private void grow(){
		//当元素总数 与 元素数组的大小相同时，就需要为数组增加容量了
		if(elementCount == elementData.length){
			//使用Arrays类创建一个新数组，并分配elementCount + capacityIncrement空间，然后将elementData中的数据拷贝进去，
			elementData = Arrays.copyOf(elementData, elementCount + capacityIncrement);
		}
	}
	
	/**
	 * 入栈：在栈的第一个元素位置，插入新元素t / 在栈顶插入新元素
	 * @param t
	 */
	public void push(T t){
		grow();
		//src:要复制的源数组		srcPos:要复制的源数组的起始下标
		//dest:复制的目的/目标数组	destPost:复制到目标数组的destPos处
		//length:复制的长度
		System.arraycopy(elementData, 0, elementData, 1, elementCount);
		elementData[0] = t;
		elementCount++;
	}
	
	/**
	 * 出栈：返回栈顶元素，不删除
	 * @return
	 */
	public T peek(){
		if(!isEmptry()){
			return (T)elementData[0];
		}
		return null;
	}
	/**
	 * 出栈：返回栈顶元素，并删除栈顶元素
	 * @return
	 */
	public T pop(){
		if(isEmptry()) return null;//或抛出异常
		//删除并返回
		T t = peek();
		//删除元素 - 我们单独将删除也封装成一个方法，方便后续的调用
		remove(0);//删除首元素
		return t;
	}
	
	/**
	 * 返回栈对象的迭代器
	 * @return
	 */
	public Iterator<T> iterator(){
		return new Iterator<T>() {//以匿名的方式实现Iterator接口
			int index = 0;
			@Override
			public boolean hasNext() {
				return index < elementCount;//如果当前访问的下标小于总元素个数，证明有下一个元素
			}

			@Override
			public T next() {
				if(index < elementCount){
					return (T)elementData[index++];
				}
				//return null;
				throw new NoSuchElementException("木有元素啦，不要再找啦！");
			}
			
		};
	}
	
	/**
	 * 根据下标删除
	 * @param index
	 */
	public void remove(int index){
		if(isEmptry()) return;
		
		if(index < 0 || index >= elementCount){//要删除的下标为负或大于等于元素总个数
			//数组下标越界
			throw new ArrayIndexOutOfBoundsException(index);
		}
		int copyLength = elementCount - index - 1;
		System.arraycopy(elementData, index + 1, elementData, index, copyLength);
		//元素总数-1
		elementCount--;
		//将最后一个元素置为null
		elementData[elementCount] = null;
	}
	
	public boolean isEmptry(){
		return elementCount == 0;
	}
	
	/**
	 * 获得栈空间中实际的元素个数
	 * @return
	 */
	public int getSize(){
		//思考：elementData.length是什么？
		return elementCount;
	}
	
	/**
	 * 获得栈空间的实际容量
	 */
	public int capacity(){
		return elementData.length;//这才是栈真实占用的空间大小
	}
	
//	/**
//	 * 添加传入的element元素到对象数组elementData中
//	 * @param element
//	 */
//	public void add(Object element){
//		elementData[elementCount] = element;
//		elementCount++;
//	}
	
	@SuppressWarnings("unchecked")//告诉编译器，不需要检测警告
	public T get(int index){
		return (T)elementData[index];
	}
	
	/**
	 * 根据下标获得index位置处的元素
	 * @param index
	 */
//	public Object get(int index){
//		return elementData[index];
//	}
	
	
}

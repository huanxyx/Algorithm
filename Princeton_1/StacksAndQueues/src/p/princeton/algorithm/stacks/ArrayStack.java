/**
 * 
 */
package p.princeton.algorithm.stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @ClassName: ArrayStack
 * @author: Huan
 * @date: 2018年4月3日 下午4:21:53
 * @Description 栈的可变数组实现（resize）
 * 				数组元素的数量在数组大小的25%到100%之间
 * 				分摊下来push N个数需要的时间为3N
 * 		
 * 		泛型的使用：
 * 				不能创建泛型的数组。
 * 				父类数组不能强制转换为子类数组
 * 				子类数组可以强制转换为父类数组
 * 		
 * 		Java中不能创建泛型数组的原因：
 * 				数组是协变的  ，  泛型是不变的。
 * 				协变：意味着可以将子类型数组赋值给它的超类数组引用。
 * 				不变：意味着不能将子类型泛型指派给其超类泛型的引用。
 * 		协变:子类引用赋值给父类引用
 * 		
 * 		
 */
public class ArrayStack<Item> implements Stack<Item>{

	//用来存储元素的数组
	private Item[] stack;
	//当前栈的大小
	private int N;
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		//由于Item[]之后再编译 的时候会转换为Object[],所以运行的时候不会出现异常
		stack = (Item[]) new Object[1];
	}
	
	/** 
	 * 当数组里面的元素达到了数组的大小时，将数组的大小翻一倍（反复倍增）
	 */
	@Override
	public void push(Item ele) {
		//假如容量不足，则扩充数组的容量
		if (N == stack.length) resize(stack.length * 2);
		stack[N++] = ele;
	}

	/**
	 * 当数组里面的元素的数量为数组大小的1/4时，将数组大小缩小一倍
	 * @return 出栈的元素
	 */
	@Override
	public Item pop() {
		if (N == 0) throw new NoSuchElementException();
		Item ele = stack[--N];
		//记得将出栈元素位置置空，将内存回收,避免空间浪费（解决游离对象）
		stack[N] = null;	
		//缩小数组的大小
		if (N > 0 && N == stack.length/4) resize(stack.length / 2);	
		return ele;
	}

	/**
	 * 判断该栈是否为空
	 */
	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	/**
	 * 获取该栈的大小
	 */
	@Override
	public int size() {
		return N;
	}

	/*
	 * 重新设置数组的大小，并将之前数组里面的元素复制到新数组中
	 */
	private void resize(int capacity) {
		@SuppressWarnings("unchecked")
		Item[] newEles = (Item[]) new Object[capacity];
		
		for (int i = 0; i < N; i++) {
			newEles[i] = stack[i];
		}
		stack = newEles;
	}

	/* 
	 * 返回该栈的迭代器
	 */
	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<Item>{
		private int current = N;
		
		@Override
		public boolean hasNext() {
			return current != 0;
		}

		@Override
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			return stack[--current];
		}
	}
}

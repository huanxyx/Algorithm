/**
 * 
 */
package p.princeton.algorithm.stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @ClassName: LinkedStack
 * @author: Huan
 * @date: 2018年4月3日 下午5:08:32
 * @Description 链表实现
 * 			
 * 			
 */
public class LinkedStack<Item> implements Stack<Item>{

	//第一个节点
	private Node first;
	//该栈的大小
	private int N;
	
	/** 
	 * 入栈
	 */
	@Override
	public void push(Item ele) {
		Node oldFirst = first;
		first = new Node();
		first.item = ele;
		first.next = oldFirst;
		
		N++;
	}

	/**
	 * 出栈
	 */
	@Override
	public Item pop() {
		if (N == 0) throw new NoSuchElementException();
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	/**
	 * 判断该栈是否为空
	 */
	@Override
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * 获取该栈的大小
	 */
	@Override
	public int size() {
		return N;
	}
	
	/*
	 * 链表的节点
	 */
	private class Node {
		Item item;
		Node next;
	}

	/* 
	 * 返回该栈的迭代器
	 */
	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item>{

		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			
			Item item 	= current.item;
			current 	= current.next;
			return item;
		}
		
	}

}

/**
 * 
 */
package p.princeton.algorithm.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @ClassName: LinkedQueue
 * @author: Huan
 * @date: 2018年4月4日 下午3:41:06
 * @Description 队列的链表实现
 * 
 * 			first代表着队首
 * 			last代表着对尾
 * 			
 * 			入队操作：(操作last)
 * 				若是当前队列为空，那么则将first指向当前入队的元素
 * 			出队操作：(操作first)
 * 				若是出队后的队列为空，那么则将last指向null
 * 
 * 			判空操作：
 * 				判断当前队首是否为空
 */
public class LinkedQueue<Item> implements Queue<Item> {

	//队首
	private Node first;
	//队尾
	private Node last;
	//该队的大小
	private int N = 0; 
	
	/**
	 * 入队
	 */
	@Override
	public void enqueue(Item item) {
		Node node = new Node();
		node.item = item;
		if (isEmpty()) 	first	 	= node;
		else 			last.next 	= node;
		last = node;
		N++;
	}

	/**
	 * 出队
	 */
	@Override
	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException();
		Item result = first.item;
		first 		= first.next;
		if (isEmpty()) last = null;
		N--;
 		return result;
	}

	/* 
	 * 判断该队列是否为空
	 */
	@Override
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * 返回该队列的大小
	 */
	@Override
	public int size() {
		return N;
	}
	
	/*
	 * 链表节点
	 */
	private class Node {
		private Item item;
		private Node next;
	}

	/**
	 * 迭代器
	 */
	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item> {
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}

}
